package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.query.SearchQuery;

import org.springframework.data.domain.Page;

import java.lang.reflect.InvocationTargetException;

public interface ISearchService {
   /**
    * 高亮查询方法
    * 参数1: mysql 中对应的实体类的类型
    * 参数2: es中对应实体类的类型
    * 参数3: 查询对象
    * 参数4: 可变长参,表示查询哪些列
    * 返回值: mysql对应实体类类型的分页对象
    */
   <T>Page<T> searchHighLight(Class<T> clazz, Class<?> esClazz, SearchQuery qo,String... fields) throws InvocationTargetException, IllegalAccessException;
}
