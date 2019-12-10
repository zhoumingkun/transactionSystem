package com.toughguy.transactionSystem.service.content.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionPolicy;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionPolicyDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionPolicyService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
/**
 * 
 * @author Guozhenze
 *
 */
@Service
public class TransactionPolicyServiceImpl 
							extends GenericServiceImpl<TransactionPolicy, Integer>
							implements ITransactionPolicyService{

	@Autowired
	private ITransactionPolicyDao policyDao;
	@Override
	public PagerModel<TransactionPolicy> selectOrId(Map<String, Object> params) {
		return policyDao.selectOrId(params);
	}
	@Override
	public PagerModel<TransactionPolicy> selectLike(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return policyDao.selectLike(params);
	}
	@Override
	public PagerModel<TransactionPolicy> findLike(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return policyDao.findLike(params);
	}
	@Override
	public PagerModel<TransactionPolicy> findLikePolicyName(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return  policyDao.findLikePolicyName(params);
	}

}
