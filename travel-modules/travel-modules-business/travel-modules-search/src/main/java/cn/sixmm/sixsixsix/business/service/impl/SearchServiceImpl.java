package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.RemoteDestinationService;
import cn.sixmm.sixsixsix.business.api.RemoteNoteService;
import cn.sixmm.sixsixsix.business.api.RemoteStrategyService;
import cn.sixmm.sixsixsix.business.api.domain.Destination;
import cn.sixmm.sixsixsix.business.api.domain.Note;
import cn.sixmm.sixsixsix.business.api.domain.Strategy;
import cn.sixmm.sixsixsix.business.query.SearchQuery;
import cn.sixmm.sixsixsix.business.service.ISearchService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.member.api.RemoteUserInfoService;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements ISearchService {

    private final ElasticsearchRestTemplate template;
    private final RemoteStrategyService remoteStrategyService;
    private final RemoteNoteService remoteNoteService;
    private final RemoteDestinationService remoteDestinationService;
    private final RemoteUserInfoService remoteUserInfoService;

    @Override
    public <T> Page<T> searchHighLight(Class<T> clazz, Class<?> esClazz, SearchQuery qo, String... fields) throws InvocationTargetException, IllegalAccessException {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(
                QueryBuilders.multiMatchQuery(qo.getKeyword(), fields)
        );
        Pageable pageable = PageRequest.of(qo.getCurrentPage() - 1, qo.getPageSize());
        builder.withPageable(pageable);

        List<HighlightBuilder.Field> highlightFields = new ArrayList<>();
        for (String field : fields) {
            HighlightBuilder.Field highlightField = new HighlightBuilder.Field(field)
                    .preTags("<span style='color:red'>")
                    .postTags("</span>");
            highlightFields.add(highlightField);
        }
        builder.withHighlightFields(highlightFields);

        SearchHits<?> hits = template.search(builder.build(), esClazz);
        long total = hits.getTotalHits();

        //当前页数据
        List<T> content = new ArrayList<>();

        for (SearchHit<?> hit : hits.getSearchHits()) {
            Long id = Long.valueOf(hit.getId());
            T t = null; //到mysql中查询得到的结果放在t中
            if (Strategy.class == clazz) {
                t = (T) remoteStrategyService.getOne(id, SecurityConstants.INNER).getData();
            } else if (Note.class == clazz) {
                t = (T) remoteNoteService.getOne(id, SecurityConstants.INNER).getData();
            } else if (UserInfo.class == clazz) {
                t = (T) remoteUserInfoService.getOne(id, SecurityConstants.INNER).getData();
            } else if (Destination.class == clazz) {
                t = (T) remoteDestinationService.getOne(id, SecurityConstants.INNER).getData();
            }

            Map<String, List<String>> map = hit.getHighlightFields();
            for (String key : map.keySet()) {
                List<String> list = map.get(key);
                StringBuffer stringBuffer = new StringBuffer();
                for (String s : list) {
                    stringBuffer.append(s + " ");
                }
                String value = stringBuffer.toString();
                BeanUtils.setProperty(t, key, value);
            }
            content.add(t);
        }
        Page<T> page = new PageImpl<T>(content, pageable, total);
        return page;
    }


}
