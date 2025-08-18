package cn.sixmm.sixsixsix.business.query;


import cn.sixmm.sixsixsix.common.core.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
* 点赞用户id查询参数封装对象
*/
@Setter
@Getter
public class StrategyCommentQuery extends  QueryObject{
    private Long strategyId;
}
