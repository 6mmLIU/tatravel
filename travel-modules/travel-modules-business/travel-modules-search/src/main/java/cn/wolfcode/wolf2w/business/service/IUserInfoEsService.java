package cn.wolfcode.wolf2w.business.service;

public interface IUserInfoEsService {
    /**
     * 初始化用户信息数据到ES
     *
     * @return 成功返回true, 失败返回false
     */
    boolean initData();
}
