package cn.sixmm.sixsixsix.business.respository;

import cn.sixmm.sixsixsix.business.api.domain.DestinationES;
import cn.sixmm.sixsixsix.business.api.domain.StrategyES;
import co.elastic.clients.elasticsearch.core.reindex.Destination;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DestinationEsRepository extends ElasticsearchRepository<DestinationES,Long> {

}
