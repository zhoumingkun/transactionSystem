package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAddress;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseAddressDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAddressService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseAddressServiceImpl
extends GenericServiceImpl<TransactionEnterpriseAddress, Integer>
implements IEnterpriseAddressService {
	@Autowired
	private IEnterpriseAddressDao dao;
	@Override
	public List<TransactionEnterpriseAddress> findStatusAll() {
		// TODO Auto-generated method stub
		return dao.findStatusAll();
	}

}
