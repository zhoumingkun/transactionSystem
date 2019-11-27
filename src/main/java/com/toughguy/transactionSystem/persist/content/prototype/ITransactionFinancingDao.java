package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.Map;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 融资信息的dao
 * @author liDongSheng
 *
 */
public interface ITransactionFinancingDao extends IGenericDao<TransactionFinancing, Integer>{
	/**
	 * 分页查询融资活动结束
	 * @param params 查询的条件参数
	 * @param methodName mybatis配置文件中所配置的方法名程
	 * @return 所要的分页数据
	 */
	public PagerModel<TransactionFinancing> findEndFinancing(Map<String, Object> params);
	/**
	 * 查询热门的融资产品
	 * @param params 查询的条件参数
	 * @param methodName mybatis配置文件中所配置的方法名程
	 * @return 所要的分页数据
	 */
	public PagerModel<TransactionFinancing> findHostFinancing(Map<String, Object> params);
}
