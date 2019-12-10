package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.transactionSystem.model.content.po.TransactionFinancing;
import com.toughguy.transactionSystem.model.content.po.TransactionFinancingTeaser;
import com.toughguy.transactionSystem.model.content.vo.MemberBasicInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 融资信息的service
 * @author liDongSheng
 *
 */
public interface ITransactionFinancingTeaserService extends IGenericService<TransactionFinancingTeaser, Integer> {
	
	/**
	 * 查询所有融资人员的基本信息
	 * @return List<MemberBasicInfo>
	 */
	public List<TransactionFinancingTeaser> findAll();
	
	/**
	 * 查询所有融资人员的基本信息【分页】
	 * @return List<MemberBasicInfo>
	 */
	public PagerModel<TransactionFinancingTeaser> findPaginated(Map<String, Object> params);
}
