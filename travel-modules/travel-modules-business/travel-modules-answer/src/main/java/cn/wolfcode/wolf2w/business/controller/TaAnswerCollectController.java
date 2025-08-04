package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerCollect;
import cn.wolfcode.wolf2w.business.query.TaAnswerCollectQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerCollectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问答-回答收藏关系 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("taAnswerCollects")
public class TaAnswerCollectController {
    @Autowired
    private ITaAnswerCollectService taAnswerCollectService;
    /**
     * 问答-回答收藏关系详情
     */
    @GetMapping("/detail/{id}")
    public R<TaAnswerCollect> detail(@PathVariable Long id) {
        TaAnswerCollect taAnswerCollect = taAnswerCollectService.getById(id);
        return R.ok(taAnswerCollect);
    }
    /**
     * 问答-回答收藏关系 列表
     */
    @GetMapping("/query")
    public R<IPage<TaAnswerCollect>> query(TaAnswerCollectQuery qo) {
        IPage<TaAnswerCollect> page = taAnswerCollectService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<TaAnswerCollect>> feignList() {
        return R.ok(taAnswerCollectService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<TaAnswerCollect> feignGet(@PathVariable Long id) {
        return R.ok(taAnswerCollectService.getById(id));
    }
}
