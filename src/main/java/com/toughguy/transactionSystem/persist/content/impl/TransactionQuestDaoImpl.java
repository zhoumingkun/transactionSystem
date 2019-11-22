package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.transactionSystem.model.content.po.TransactionQuest;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionQuestDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
/**
 * 
 * 		IQuestOptionInfoDao的实现类
 * @author Guozhenze
 *
 */
@Repository
public class TransactionQuestDaoImpl 
						extends GenericDaoImpl<TransactionQuest, Integer> 
						implements ITransactionQuestDao{

	@Override
	public List<TransactionQuest> findInfoAll(TransactionQuest quest) {
		
		return sqlSessionTemplate.selectList(typeNameSpace + ".findInfoAll",quest);
	}

	@Override
	public void insertQuest(TransactionQuest oqInfo) {
		sqlSessionTemplate.insert(typeNameSpace + ".insertQuest", oqInfo);
	}
	
}
