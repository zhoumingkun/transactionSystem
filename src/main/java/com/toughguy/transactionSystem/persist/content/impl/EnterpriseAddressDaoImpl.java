package com.toughguy.transactionSystem.persist.content.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAddress;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseAddressDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseAddressDaoImpl
extends GenericDaoImpl<TransactionEnterpriseAddress, Integer>
implements IEnterpriseAddressDao {

	@Override
	public List<TransactionEnterpriseAddress> findStatusAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findStatusAll");
	}

}
