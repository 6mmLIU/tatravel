package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.RemoteDestinationService;
import cn.wolfcode.wolf2w.business.api.RemoteNoteService;
import cn.wolfcode.wolf2w.business.api.RemoteStrategyService;
import cn.wolfcode.wolf2w.business.api.domain.Destination;
import cn.wolfcode.wolf2w.business.api.domain.Note;
import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.query.SearchQuery;
import cn.wolfcode.wolf2w.business.service.ISearchService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.member.api.RemoteUserInfoService;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private ElasticsearchRestTemplate template;
    @Autowired
    private RemoteStrategyService remoteStrategyService;
    @Autowired
    private RemoteNoteService remoteNoteService;
    @Autowired
    private RemoteDestinationService remoteDestinationService;
    @Autowired
    private RemoteUserInfoService remoteUserInfoService;

    @Override
    public <T> Page<T> searchHighLight(Class<T> clazz, Class<?> esClazz, SearchQuery qo, String... fields) throws InvocationTargetException, IllegalAccessException {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(
                QueryBuilders.multiMatchQuery(qo.getKeyword(), fields)
        );
        Pageable  pageable = PageRequest.of(qo.getCurrentPage()-1, qo.getPageSize());
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
            if(Strategy.class == clazz){
                t = (T) remoteStrategyService.getOne(id, SecurityConstants.INNER).getData();
            }else if(Note.class == clazz){
                t = (T) remoteNoteService.getOne(id, SecurityConstants.INNER).getData();
            }else if(UserInfo.class == clazz){
                t =  (T) remoteUserInfoService.getOne(id, SecurityConstants.INNER).getData();
            }else if (Destination.class == clazz){
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
