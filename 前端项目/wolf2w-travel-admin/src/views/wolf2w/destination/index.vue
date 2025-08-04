<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="keyword">
        <el-input
          v-model="queryParams.keyword"
          placeholder="请输入中文名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
     
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.ta_dest_status"
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
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          :v-hasPermi="['system:destination:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          :v-hasPermi="['system:destination:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          :v-hasPermi="['system:destination:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          :v-hasPermi="['system:destination:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
     
    </el-row>    

    <el-row>
       <el-tag size="medium" type="danger" @click="handleClick()">吐司导航：</el-tag>
      <el-tag
        v-for="item in toasts"
        :key="item.id"
        effect="dark"
        @click="handleClick(item.id)"
        >
        {{ item.name }} >> 
      </el-tag>
    </el-row>

    <el-table v-loading="loading" :data="destinationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="名称" align="center" prop="name" >
          <template slot-scope="scope">
            <el-link :underline="false" @click="handleClick(scope.row.id)">{{ scope.row.name + '(' + scope.row.english +')' }}</el-link>
          </template>
      </el-table-column>
      <el-table-column label="展示图片" align="center" prop="coverUrl" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.coverUrl" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="介绍" align="center" prop="info" show-overflow-tooltip />
      <el-table-column label="上级名称" align="center" prop="parentName"  :formatter="row=>row.parentName?'row.parentName':'顶级'"  />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.ta_dest_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            :v-hasPermi="['system:destination:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            :v-hasPermi="['system:destination:remove']"
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

    <!-- 添加或修改目的地对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="中文名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入中文名称" />
        </el-form-item>
        <el-form-item label="英文名称" prop="english">
          <el-input v-model="form.english" placeholder="请输入英文名称" />
        </el-form-item>
        <el-form-item label="展示图片">
          <image-upload v-model="form.coverUrl"/>
        </el-form-item>
        <el-form-item label="介绍" prop="info">
          <el-input v-model="form.info" placeholder="请输入介绍" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.ta_dest_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {getDestination, listDestination, addDestination , delDestination , updateDestination,queryToasts} from "@/api/wolf2w/destination";

export default {
  name: "Destination",
  dicts: ['ta_dest_status'],
  data() {
    return {
      toasts:[],
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
      // 目的地表格数据
      destinationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        keyword: null,
        english: null,
        coverUrl: null,
        info: null,
        parentName: null,
        parentId: null,
        regionId: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询目的地列表 */
    getList() {
      this.loading = true;
      listDestination(this.queryParams).then(response => {
        this.destinationList = response.data.records;
        this.total = response.data.total;
        this.loading = false;
      });

      queryToasts({destId:this.queryParams.parentId}).then(resp=>{
        this.toasts = resp.data;
      })

    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        english: null,
        coverUrl: null,
        info: null,
        parentName: null,
        parentId: null,
        regionId: null,
        status: 0
      };
      this.resetForm("form");
    },
    handleClick(id){
      this.queryParams.parentId = id;
      this.queryParams.pageNum = 1;
      this.getList();
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
      this.title = "添加目的地";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDestination(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改目的地";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDestination(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDestination(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除目的地编号为"' + ids + '"的数据项？').then(function() {
        return delDestination(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/destination/export', {
        ...this.queryParams
      }, `destination_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
