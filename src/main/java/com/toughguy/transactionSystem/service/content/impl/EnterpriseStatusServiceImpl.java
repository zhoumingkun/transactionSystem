package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseStatus;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseStatusService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseStatusServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseStatus, Integer>
implements IEnterpriseStatusService{

}
