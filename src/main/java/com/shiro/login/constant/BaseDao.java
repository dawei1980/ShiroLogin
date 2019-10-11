package com.shiro.login.constant;

import com.shiro.login.entity.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 数据对象基础操作类
 * @author yong
 *
 */
public interface BaseDao<T,PK extends Serializable> {

	/**
	 * 增加对象
	 * @param obj
	 */
	void add(T obj);

	/**
	 * 修改对象
	 * @param obj
	 */
	int update(T obj);

	/**
	 * 根据主键删除对象
	 * @param pk
	 */
	int delete(PK pk);
	/**
	 * 根据列名条件删除对象
	 * @param pk
	 */
	int deleteByCommonWhere(Query q);

	/**
	 * 根据主键得到某个对象
	 * @param pk
	 */
	T get(PK pk);

	/**
	 * 根据一组主键（数组），得到多个对象，以列表形式返回
	 * @param pks
	 * @return
	 */
	List<T> getByIds(PK[] pks);

	/**
	 * 根据条件查询数据条件
	 * @param q
	 * @return
	 */
	Long count(Query q);

	/**
	 * 根据条件查询数据
	 * @param q
	 * @return
	 */
	List<T> queryAll(Query q);

	/**
	 * 根据条件查询分页数据
	 * @param q
	 * @return
	 */
	List<T> pageList(Query q);
	/**
	 * 只查询需要的列名的list
	 *
	 * @param query
	 * @return list key为数据库中带有下划线的key,需要转驼峰结构
	 */
	List<Map<String, Object>> queryColumnList(Query q);
}
