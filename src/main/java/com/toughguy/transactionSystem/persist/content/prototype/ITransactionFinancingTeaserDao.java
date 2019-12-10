package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.model.content.po.TransactionFinancingTeaser;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 融资信息的dao新版
 * @author zmk
 *
 */
public interface ITransactionFinancingTeaserDao extends IGenericDao<TransactionFinancingTeaser, Integer>{
	
	/**
	 * 查询所有融资人基本信息
	 * @return
	 */
	public List<TransactionFinancingTeaser> findAll();
	
	/**
	 * 查询所有所有融资人基本信息【分页】
	 * @param params
	 * @return
	 */
	public PagerModel<TransactionFinancingTeaser> findPaginated(Map<String, Object> params);
}
