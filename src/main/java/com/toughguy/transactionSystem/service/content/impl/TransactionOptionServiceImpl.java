package com.toughguy.transactionSystem.service.content.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionOption;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionOptionDao;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionOptionService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
/**
 * 	TransactionOption类service层的实现类
 * @author LENOVO
 *
 */
@Service
public class TransactionOptionServiceImpl 
						extends GenericServiceImpl<TransactionOption,Integer>
						implements ITransactionOptionService{
	@Autowired
	private ITransactionOptionDao optionDao;
	
	@Override
	public List<TransactionOption> findOption(TransactionOption option) {
		return optionDao.findOption(option);
	}

	@Override
	public void insertOption(TransactionOption option) {
		optionDao.insertOption(option);
	}

	@Override
	public void updateCount(TransactionOption option) {
		optionDao.updateCount(option);
	}

}
