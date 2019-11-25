package com.toughguy.transactionSystem.service.content.prototype;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionPolicyDao;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 	
 * @author Guozhenze
 *
 */
public interface ITransactionPolicyService extends IGenericService<TransactionPolicy, Integer>{
	/**
	 * 
	 *  根据行业id和区域id进行筛选
	 * @param params
	 * @return
	 */
	PagerModel<TransactionPolicy> selectOrId(Map<String, Object> params);
	
	
}
