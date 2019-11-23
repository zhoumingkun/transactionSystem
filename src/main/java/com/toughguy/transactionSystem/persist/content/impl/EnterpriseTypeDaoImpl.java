package com.toughguy.transactionSystem.persist.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.persist.content.prototype.IEnterpriseTypeDao;
import com.toughguy.transactionSystem.persist.impl.GenericDaoImpl;
@Service
public class EnterpriseTypeDaoImpl 
extends GenericDaoImpl<TransactionEnterpriseType, Integer>
implements IEnterpriseTypeDao{

}
