package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseStatus;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseStatusDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseStatusDaoImpl 
extends GenericDaoImpl<TransactionEnterpriseStatus, Integer>
implements IEnterpriseStatusDao{

}
