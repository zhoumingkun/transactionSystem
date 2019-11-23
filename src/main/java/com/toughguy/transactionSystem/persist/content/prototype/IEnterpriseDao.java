package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterprise;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;
/**
 * 企业dao
 * @author 张泽
 */
public interface IEnterpriseDao extends IGenericDao<TransactionEnterprise, Integer> {
	/**
	 * 所有的企业信息
	 * @return
	 */
	public List<TransactionEnterprise> enterpriseInfo();
}
