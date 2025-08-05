package cn.wolfcode.wolf2w.business.respository;

import cn.wolfcode.wolf2w.business.api.domain.DestinationES;
import cn.wolfcode.wolf2w.business.api.domain.StrategyES;
import co.elastic.clients.elasticsearch.core.reindex.Destination;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DestinationEsRepository extends ElasticsearchRepository<DestinationES,Long> {

}
