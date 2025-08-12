package cn.wolfcode.wolf2w.common.core.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value = "分页对象类",description = "所以分页查询对象的父类")
public class QueryObject implements Serializable {
    @ApiModelProperty(name = "currentPage",value = "当前页",dataType = "int",required = true,example = "1")
    private int currentPage = -1;
    @ApiModelProperty(name = "pageNum",value = "当前页",dataType = "int",required = true,example = "1")
    private int pageNum = -1;
    @ApiModelProperty(name = "pageSize",value = "每页的条数",dataType = "int",required = false,example = "10")
    private int pageSize = 10;
    @ApiModelProperty(name = "keyWord",value = "查询关键字",dataType = "String",required = false,example = "广州")
    private String keyword;

    public int getCurrentPage(){
        if(currentPage != -1){
            return this.currentPage;
        }
        if(currentPage == -1 && pageNum != -1){
            return pageNum;
        }
        return 1;
    }

    public int getPageNum(){
        if(pageNum != -1){
            return this.pageNum;
        }
        if(pageNum == -1 && currentPage != -1){
            return currentPage;
        }
        return 1;
    }
}
