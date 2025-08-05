package cn.wolfcode.wolf2w.business.service;

public interface INoteEsService {
    /**
     * 初始化游记数据到ES
     *
     * @return 成功返回true, 失败返回false
     */
    boolean initData();
}
