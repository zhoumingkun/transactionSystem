package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseTypeDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseTypeService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseTypeServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseType, Integer>
implements IEnterpriseTypeService{

	@Autowired
	private IEnterpriseTypeDao dao;

	@Override
	public List<TransactionEnterpriseType> findStatusAll() {
		// TODO Auto-generated method stub
		return dao.findStatusAll();
	}
}
