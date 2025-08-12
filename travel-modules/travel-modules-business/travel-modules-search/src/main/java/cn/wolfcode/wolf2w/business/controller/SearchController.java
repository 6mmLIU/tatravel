package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.business.api.domain.*;
import cn.wolfcode.wolf2w.business.query.SearchQuery;
import cn.wolfcode.wolf2w.business.service.ISearchService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @GetMapping("/search")
    public R<?> search(SearchQuery qo) throws InvocationTargetException, IllegalAccessException {

        System.err.println(qo.getKeyword());

        switch (qo.getType()){
            case 1:
                return R.ok(searchStrategy(qo));
            case 2:
                return R.ok(searchNote(qo));
            case 3:
                return R.ok(searchUser(qo));
            default:
                return R.ok(searchAll(qo));
        }
    }

    //返回map对象，其中游users，strategies，notes，dests，total
    private Object searchAll(SearchQuery qo) throws InvocationTargetException, IllegalAccessException {
        Page<UserInfo> userPage = searchService.searchHighLight(UserInfo.class, UserInfoES.class, qo, "nickname", "info", "city");
        Page<Strategy> strategyPage = searchService.searchHighLight(Strategy.class, StrategyES.class, qo, "title", "subTitle", "summary");
        Page<Note> notePage = searchService.searchHighLight(Note.class, NoteES.class, qo, "title", "summary");
        Page<Destination> destinationPage = searchService.searchHighLight(Destination.class, DestinationES.class, qo, "name", "info");
        long total = userPage.getTotalElements()+
                strategyPage.getTotalElements()+
                notePage.getTotalElements()+
                destinationPage.getTotalElements();
        List<UserInfo> userList = userPage.getContent();
        List<Strategy> strategyList = strategyPage.getContent();
        List<Note> noteList = notePage.getContent();
        List<Destination> destinationList = destinationPage.getContent();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("users", userList);
        map.put("strategies", strategyList);
        map.put("notes", noteList);
        map.put("dests", destinationList);
        return map;
    }

    //返回用户的分页数据
    private Object searchUser(SearchQuery qo) throws InvocationTargetException, IllegalAccessException {
        Page<UserInfo> page = searchService.searchHighLight(UserInfo.class, UserInfoES.class, qo, "nickname", "info", "city");
        return page;
    }

    //返回游记的分页数据
    private Object searchNote(SearchQuery qo) throws InvocationTargetException, IllegalAccessException {
        Page<Note> page = searchService.searchHighLight(Note.class, NoteES.class, qo, "title", "summary");
        return page;
    }

    //返回攻略的分页数据
    private Object searchStrategy(SearchQuery qo) throws InvocationTargetException, IllegalAccessException {
        Page<Strategy> page = searchService.searchHighLight(Strategy.class, StrategyES.class, qo, "title", "subTitle", "summary");
        return page;
    }

    //返回问答页面高亮页面

}
