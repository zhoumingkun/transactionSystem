package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseTypeDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseTypeDaoImpl 
extends GenericDaoImpl<TransactionEnterpriseType, Integer>
implements IEnterpriseTypeDao{

	@Override
	public List<TransactionEnterpriseType> findStatusAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findStatusAll");
	}

}
