package cn.sixmm.sixsixsix.business.respository;

import cn.sixmm.sixsixsix.business.api.domain.StrategyES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StrategyEsRepository extends ElasticsearchRepository<StrategyES,Long> {

}
