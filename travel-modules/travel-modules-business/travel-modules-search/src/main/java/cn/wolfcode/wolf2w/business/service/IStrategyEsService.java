package cn.wolfcode.wolf2w.business.service;

public interface IStrategyEsService {
    /**
     * 初始化攻略数据到ES
     *
     * @return 成功返回true, 失败返回false
     */
    boolean initData();
}
