package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionMemberCompany;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 *	 与会员信息关联的企业信息的DAO
 * @author Guozhenze
 *
 */
public interface ITransactionMemberCompanyDao 
		extends IGenericDao<TransactionMemberCompany, Integer>{
		List<TransactionMemberCompany> findAllInfo();
		
}
