package com.toughguy.transactionSystem.service.content.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionQuest;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionQuestDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionQuestService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
/**
 * 	TransactionQuest 类service 实现
 * @author LENOVO
 *
 */
@Service
public class TransactionQuestServiceImpl
				extends GenericServiceImpl<TransactionQuest,Integer> 
				implements ITransactionQuestService{

	@Autowired
	private ITransactionQuestDao questDao;
	
	@Override
	public List<TransactionQuest> findInfoAll(TransactionQuest quest) {
		return questDao.findInfoAll(quest);
	}

	@Override
	public void insertQuest(TransactionQuest quest) {
		
		questDao.insertQuest(quest);
	}

}
