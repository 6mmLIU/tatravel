package cn.wolfcode.wolf2w.common.core.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QueryObject implements Serializable {
    private int currentPage = -1;
    private int pageNum = -1;
    private int pageSize = 10;

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
