package cn.sixmm.sixsixsix.business.respository;

import cn.sixmm.sixsixsix.business.api.domain.StrategyES;
import cn.sixmm.sixsixsix.business.api.domain.UserInfoES;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserInfoRepository extends ElasticsearchRepository<UserInfoES,Long> {

}
