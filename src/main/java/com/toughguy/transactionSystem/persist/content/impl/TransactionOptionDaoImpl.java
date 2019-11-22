package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionOption;
import com.toughguy.transactionSystem.persist.content.prototype.ITransactionOptionDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;

/**
 * TransactionOptionDao的实现类	
 * @author LENOVO
 *
 */
@Repository
public class TransactionOptionDaoImpl 
					extends GenericDaoImpl<TransactionOption, Integer> 
						implements ITransactionOptionDao{

	@Override
	public List<TransactionOption> findOption(TransactionOption option) {
		return sqlSessionTemplate.selectList(typeNameSpace + ".findOption", option);
	}

	@Override
	public void insertOption(TransactionOption option) {
		sqlSessionTemplate.insert(typeNameSpace + ".insertOption", option);
	}

	@Override
	public void updateCount(TransactionOption option) {
		sqlSessionTemplate.update(typeNameSpace + ".updateCount", option);
	}
	
	
	
}
