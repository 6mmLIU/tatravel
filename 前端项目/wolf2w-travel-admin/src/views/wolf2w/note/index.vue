<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否公开" prop="isPublic">
        <el-select v-model="queryParams.isPublic" placeholder="请选择是否公开" clearable>
          <el-option
            v-for="dict in dict.type.note_is_public"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态 " prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态 " clearable>
          <el-option
            v-for="dict in dict.type.note_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['note:note:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['note:note:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="noteList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="目的地" align="center" prop="destName" />
      <el-table-column label="作者" align="center" prop="authorId" />
      <el-table-column label="标题" align="center" prop="title" show-overflow-tooltip />
      <el-table-column label="封面" align="center" >
        <template slot-scope="scope">
            <image-preview :src="scope.row.coverUrl" :width="50" :height="50"/>
          </template>
      </el-table-column>
      <el-table-column label="旅游时间" align="center" prop="travelTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.travelTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="人均消费" align="center" prop="avgConsume" />
      <el-table-column label="旅游天数" align="center" prop="days" />
      <el-table-column label="和谁旅游" align="center" prop="personDisplay" />
      <el-table-column label="发布时间" align="center" prop="releaseTime" width="180">
        <template slot-scope="scope">
          <span>{{ scope.row.releaseTime?parseTime(scope.row.releaseTime, '{y}-{m}-{d}'):'未发布' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否公开" align="center" prop="isPublic">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.note_is_public" :value="scope.row.isPublic"/>
        </template>
      </el-table-column>
      <el-table-column label="阅读数" align="center" prop="viewnum"  />
      <el-table-column label="回复数" align="center" prop="replynum" />
      <el-table-column label="收藏数" align="center" prop="favornum" />
      <el-table-column label="分享数" align="center" prop="sharenum" />
      <el-table-column label="点赞数" align="center" prop="thumbsupnum" />
      <el-table-column label="状态 " align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.note_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleShow(scope.row)"
            v-hasPermi="['note:note:edit']"
          >查看</el-button>
           <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleAudit(scope.row)"
            v-hasPermi="['note:note:edit']"
          >审核</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['note:note:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 查看对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <div v-html="content">
      </div>
    </el-dialog>

     <!-- 查看对话框 -->
    <el-dialog title="套餐审核" :visible.sync="auditOpen" width="500px" append-to-body>
      <el-form ref="form" :model="auditInfo" label-width="80px">
        <el-form-item label="审批" prop="status">
          <el-select v-model="auditInfo.status" placeholder="请选择状态">
            <el-option
              v-for="item in [{'label':'通过','value':2},{'label':'拒绝', 'value':3}]"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="意见" prop="info">
          <el-input v-model="auditInfo.info" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitAuditForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>



  </div>
</template>

<script>
import { listNote, getNote, delNote, addNote, updateNote,getNoteContent,noteAudit } from "@/api/wolf2w/note";

export default {
  name: "Note",
  dicts: ['note_status', 'note_is_public'],
  data() {
    return {
      auditOpen:false,
      content: null,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 旅游日记表格数据
      noteList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        isPublic: null,
        status: null
      },
      // 表单参数
      form: {},
      auditInfo: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询旅游日记列表 */
    getList() {
      this.loading = true;
      listNote(this.queryParams).then(response => {
        this.noteList = response.data.records;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.auditOpen = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.auditInfo={},
      this.form = {
        id: null,
        destId: null,
        destName: null,
        authorId: null,
        title: null,
        summary: null,
        coverUrl: null,
        travelTime: null,
        avgConsume: null,
        days: null,
        person: null,
        createTime: null,
        releaseTime: null,
        updateTime: null,
        isPublic: null,
        viewnum: null,
        replynum: null,
        favornum: null,
        sharenum: null,
        thumbsupnum: null,
        status: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加旅游日记";
    },
    /** 修改按钮操作 */
    handleShow(row) {
      getNoteContent(row.id).then(response => {
        this.open = true;
        this.title = "查看旅游日记";
        this.content = response.data.content;
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateNote(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addNote(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除旅游日记编号为"' + ids + '"的数据项？').then(function() {
        return delNote(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    handleAudit(row){
        this.auditOpen = true;
        this.auditInfo ={id:row.id}
        console.log(this.auditInfo)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('note/note/export', {
        ...this.queryParams
      }, `note_${new Date().getTime()}.xlsx`)
    },
    submitAuditForm(){
      noteAudit(this.auditInfo).then(resp=>{
        this.$modal.msgSuccess("审核成功")
        this.auditOpen =false;
        this.getList();
      })
    }
  }
};
</script>
