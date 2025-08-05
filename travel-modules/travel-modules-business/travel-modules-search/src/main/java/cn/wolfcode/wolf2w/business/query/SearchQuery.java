package cn.wolfcode.wolf2w.business.query;

import cn.wolfcode.wolf2w.common.core.query.QueryObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchQuery extends QueryObject {
    private int type=-1; //-1全部 1攻略 2游记 3 找人 4 问答

}
