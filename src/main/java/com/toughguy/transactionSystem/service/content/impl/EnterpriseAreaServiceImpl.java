package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseArea;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseAreaDao;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAreaService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseAreaServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseArea, Integer>
implements IEnterpriseAreaService{
	@Autowired
	private IEnterpriseAreaDao dao;

	@Override
	public List<TransactionEnterpriseArea> findStatusAll() {
		// TODO Auto-generated method stub
		return dao.findStatusAll();
	}
}
