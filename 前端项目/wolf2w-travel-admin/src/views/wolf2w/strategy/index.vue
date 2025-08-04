<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      
      <el-form-item label="攻略主题" prop="themeId">
        <el-select v-model="queryParams.themeId" placeholder="请选择状态" clearable>
          <el-option
            v-for="item in themeList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="攻略分类" prop="catalogId">
        <el-select v-model="queryParams.catalogId" placeholder="请选择">
          <el-option-group
            v-for="group in catalogGroupList"
            :key="group.destName"
            :label="group.destName">
            <el-option
              v-for="item in group.catalogList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-option-group>
        </el-select>
      </el-form-item>
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否国外" prop="isabroad">
         <el-select v-model="queryParams.isabroad" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in [{'label':'是','value':1}, {'label':'否','value':0}]"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-select v-model="queryParams.state" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.strategy_release_status"
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
          v-hasPermi="['strategy:strategy:add']"
        >新增</el-button>
      </el-col>
      
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="strategyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="目的地" align="center" prop="destName" />
      <el-table-column label="主题" align="center" prop="themeName" />
      <el-table-column label="分类" align="center" prop="catalogName" />
      <el-table-column label="标题" align="center" prop="title" show-overflow-tooltip />
      <el-table-column label="内容概要" align="center" prop="summary"  show-overflow-tooltip/>
      <el-table-column label="封面" align="center" prop="coverUrl" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.coverUrl" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="是否国外" align="center" prop="isabroad"  :formatter="row=>row.isabroad == 1?'国外':'国内'"/>
         
      <el-table-column label="点击数" align="center" prop="viewnum" />
      <el-table-column label="评论数" align="center" prop="replynum" />
      <el-table-column label="收藏数" align="center" prop="favornum" />
      <el-table-column label="分享数" align="center" prop="sharenum" />
      <el-table-column label="点赞数" align="center" prop="thumbsupnum" />
      <el-table-column label="状态" align="center" prop="state">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.strategy_release_status" :value="scope.row.state"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['strategy:strategy:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['strategy:strategy:remove']"
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
  </div>
</template>

<script>
import { listStrategy, getStrategy, delStrategy, addStrategy, updateStrategy } from "@/api/wolf2w/strategy";
import { groupList } from "@/api/wolf2w/strategyCatalog";
import { themeListAll } from "@/api/wolf2w/strategyTheme";

export default {
  name: "Strategy",
  dicts: ['strategy_release_status', 'ta_dest_status'],
  data() {
    return {
      catalogGroupList:[],
      themeList:[],
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
      // 攻略管理表格数据
      strategyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        destId: null,
        themeId: null,
        catalogId: null,
        title: null,
        isabroad: null,
        state: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  watch: {
    '$route': 'refresh'
  },
  methods: {
    refresh() {
      this.getList();
    },

    /** 查询攻略管理列表 */
    getList() {
      this.loading = true;
      listStrategy(this.queryParams).then(response => {
        this.strategyList = response.data.records;
        this.total = response.data.total;
        this.loading = false;
      });

      groupList().then(resp=>{
        this.catalogGroupList = resp.data;
        console.log(this.catalogGroupList)
      })

      themeListAll().then(resp=>{
        this.themeList = resp.data;
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
        destId: null,
        destName: null,
        themeId: null,
        themeName: null,
        catalogId: null,
        catalogName: null,
        title: null,
        subTitle: null,
        summary: null,
        coverUrl: null,
        createTime: null,
        isabroad: null,
        viewnum: null,
        replynum: null,
        favornum: null,
        sharenum: null,
        thumbsupnum: null,
        state: null
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
       this.$router.push("/strategy/add");

    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.$router.push("/strategy/edit/" + row.id);
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStrategy(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStrategy(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除攻略管理编号为"' + ids + '"的数据项？').then(function() {
        return delStrategy(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('strategy/strategy/export', {
        ...this.queryParams
      }, `strategy_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
