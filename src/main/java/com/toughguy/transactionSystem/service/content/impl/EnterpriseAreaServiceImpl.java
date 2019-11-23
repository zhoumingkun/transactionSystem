package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseArea;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAreaService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseAreaServiceImpl 
extends GenericServiceImpl<TransactionEnterpriseArea, Integer>
implements IEnterpriseAreaService{

}
