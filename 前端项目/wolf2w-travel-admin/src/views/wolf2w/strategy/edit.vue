<template>
  <div class="app-container">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="封面图片">
              <image-upload v-model="form.coverUrl"/>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="标题" prop="title">
              <el-input v-model="form.title" placeholder="请输入标题" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="副标题" prop="subTitle">
              <el-input v-model="form.subTitle" placeholder="请输入副标题" />
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="主题" prop="themeId">
              <el-select v-model="form.themeId" placeholder="请选择主题" clearable>
                <el-option
                  v-for="item in themeList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                />
              </el-select>  
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="分类" prop="catalogId">
               <el-select v-model="form.catalogId" placeholder="请选择">
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
          </el-col>

          <el-col :span="6">
            <el-form-item label="是否国外" prop="isabroad">
              <el-select v-model="form.isabroad" placeholder="请选择状态" clearable>
                <el-option
                  v-for="dict in [{'label':'是','value':1}, {'label':'否','value':0}]"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="状态" prop="state">
              <el-select v-model="form.state" placeholder="请选择状态" clearable>
                <el-option
                  v-for="dict in dict.type.strategy_release_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="摘要" prop="summary">
              <el-input v-model="form.summary" type="textarea" placeholder="请输入摘要内容"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="内容">
              <editor v-model="form.txt" :min-height="192"/>
            </el-form-item>
          </el-col>
          
        </el-row>
        
      </el-form>
      <el-row>
       <el-col :span="24" align="right">
        <el-button type="primary" @click="handleSave">确 认</el-button>
         <el-button @click="handleCancel">取 消</el-button>
       </el-col>  
      </el-row>
  </div>
</template>

<script>
import { addStrategy, updateStrategy,getStrategy } from "@/api/wolf2w/strategy";
import { groupList } from "@/api/wolf2w/strategyCatalog";
import { themeListAll } from "@/api/wolf2w/strategyTheme";

export default {
  name: "StrategyAdd",
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
      id:this.$route.params.id,
      
      // 表单参数
      form: {
      },
      // 表单校验
      rules: {
      }
    };
  },
  created() {
   this.getList();
  },
  methods: {
    getList() {
      groupList().then(resp=>{
        this.catalogGroupList = resp.data;
      })
      themeListAll().then(resp=>{
        this.themeList = resp.data;
      })

      getStrategy(this.id).then(resp=>{
        this.form = resp.data;
        this.form.txt = resp.data.content.content
        this.form.state = resp.data.state + ""
      })

    },
    handleSave(){

      this.form['content.content'] = this.form.txt;
      let store = this.$store;
      let route = this.$route
      let router = this.$router

      delete this.form.content;

      updateStrategy(this.form).then(resp=>{
        this.$modal.confirm('编辑成功').then(function() {
            // 调用全局挂载的方法，关闭当前页
          store.dispatch("tagsView/delView", route);
            // 返回上一步路由
          router.go(-1)
        })
      })
      
    },
    handleCancel(){
      this.$store.dispatch("tagsView/delView", this.$route);
      // 返回上一步路由
      this.$router.go(-1)
    }
  }
};
</script>

