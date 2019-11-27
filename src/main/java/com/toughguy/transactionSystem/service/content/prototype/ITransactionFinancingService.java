package com.toughguy.transactionSystem.service.content.prototype;

import java.util.Map;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 融资信息的service
 * @author liDongSheng
 *
 */
public interface ITransactionFinancingService extends IGenericService<TransactionFinancing, Integer> {
	/**
	 * 查询融资活动结束
	 * @param params
	 * @return
	 */
	public PagerModel<TransactionFinancing> findEndFinancingPage(Map<String, Object> params);
	/**
	 * 查询热门的融资活动
	 * @param params
	 * @return
	 */
	public PagerModel<TransactionFinancing> findHostFinancingPage(Map<String, Object> params);
}
