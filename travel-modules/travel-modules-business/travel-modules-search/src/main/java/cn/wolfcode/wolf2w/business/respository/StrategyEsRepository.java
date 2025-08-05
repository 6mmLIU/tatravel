package cn.wolfcode.wolf2w.business.respository;

import cn.wolfcode.wolf2w.business.api.domain.StrategyES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StrategyEsRepository extends ElasticsearchRepository<StrategyES,Long> {

}
