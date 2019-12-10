package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.Map;

import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 	政策Dao
 * @author Guozhenze
 *
 */
public interface ITransactionPolicyDao extends IGenericDao<TransactionPolicy, Integer>{
	/**
	 * 	根据行业或者区域进行查找
	 * @param policy
	 * @return
	 */
	PagerModel<TransactionPolicy> selectOrId(Map<String, Object> params);
	
	/**
	 * 	模糊查找
	 * @param params
	 * @return
	 */
	PagerModel<TransactionPolicy> selectLike(Map<String, Object> params);
	/**
	 * 	根据政策名字 和行业id或者领域id进行筛选或企业类型id进行筛选
	 * @param params
	 * @return
	 */
	PagerModel<TransactionPolicy>  findLike(Map<String, Object> params);

	/**
	 * 根据政策名称模糊查询政策PC
	 * @param params
	 * @return
	 */
	PagerModel<TransactionPolicy> findLikePolicyName(Map<String, Object> params);
	
	
	
}
