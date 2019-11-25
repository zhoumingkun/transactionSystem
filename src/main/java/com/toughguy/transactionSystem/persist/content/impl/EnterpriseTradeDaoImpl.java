package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseTrade;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseTradeDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseTradeDaoImpl 
extends GenericDaoImpl<TransactionEnterpriseTrade, Integer>
implements IEnterpriseTradeDao{

	@Override
	public List<TransactionEnterpriseTrade> findStatusAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findStatusAll");
	}

}
