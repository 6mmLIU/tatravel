package cn.wolfcode.wolf2w.business.respository;

import cn.wolfcode.wolf2w.business.api.domain.StrategyES;
import cn.wolfcode.wolf2w.business.api.domain.UserInfoES;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserInfoRepository extends ElasticsearchRepository<UserInfoES,Long> {

}
