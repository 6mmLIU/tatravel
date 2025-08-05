package cn.wolfcode.wolf2w.business.service;

public interface IDestinationEsService {
    /**
     * 初始化目的地数据到ES
     *
     * @return 成功返回true, 失败返回false
     */
    boolean initData();
}
