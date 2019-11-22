package com.toughguy.transactionSystem.service.content.prototype;

import java.io.Serializable;
import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionOption;
import com.toughguy.transactionSystem.service.prototype.IGenericService;
/**
 * 	  TransactionOption实体类的sevice接口
 * @author Guozhenze
 *
 */
public interface ITransactionOptionService extends IGenericService<TransactionOption, Integer> {
	
	/**
	 *	根据问题id查找所有的选项
	 * @param option
	 * @return
	 */
	List<TransactionOption> findOption(TransactionOption option);
	
	/**
	 * 	根据问题的id 插入相对应的选项
	 * @param option
	 */
	void insertOption(TransactionOption option);
	
	/**
	 * 	统计某个问题某个选项的数值
	 * @param option
	 */
	void updateCount(TransactionOption option);
	
}
