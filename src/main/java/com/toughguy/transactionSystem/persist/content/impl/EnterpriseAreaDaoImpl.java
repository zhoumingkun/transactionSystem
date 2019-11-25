package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseArea;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseAreaDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseAreaDaoImpl 
extends GenericDaoImpl<TransactionEnterpriseArea, Integer>
implements IEnterpriseAreaDao{

	@Override
	public List<TransactionEnterpriseArea> findStatusAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findStatusAll");
	}

}
