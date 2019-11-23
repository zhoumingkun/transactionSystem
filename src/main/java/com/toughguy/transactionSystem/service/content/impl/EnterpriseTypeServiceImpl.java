package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseType;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseTypeService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseTypeServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseType, Integer>
implements IEnterpriseTypeService{

}
