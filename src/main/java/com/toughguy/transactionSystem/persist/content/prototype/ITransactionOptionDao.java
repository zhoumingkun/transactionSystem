package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.List;

import com.toughguy.transactionSystem.model.content.po.TransactionOption;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

/**
 * 	TransactionOption 实体类 的dao层
 * 	
 * @author LENOVO
 *
 */
public interface ITransactionOptionDao extends IGenericDao<TransactionOption, Integer>{
	
	/**
	 *  	根据问题id查找相对应的选项和选择此选项的人数
	 * @param optionId
	 * @return
	 */
	List<TransactionOption> findOption(TransactionOption option);
	/**
	 * 		根据问题的id插入相应的选项
	 * @param option
	 */
	void insertOption(TransactionOption option) ;
	
	/**
	 * 	跟据问题id和选项id对选项选择的人数进行增加
	 * @param option
	 */
	void updateCount(TransactionOption option);
	
	
}

