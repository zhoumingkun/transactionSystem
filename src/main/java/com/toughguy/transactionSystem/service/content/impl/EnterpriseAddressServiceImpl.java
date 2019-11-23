package com.toughguy.transactionSystem.service.content.impl;

import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.po.TransactionEnterpriseAddress;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseAddressService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class EnterpriseAddressServiceImpl
extends GenericServiceImpl<TransactionEnterpriseAddress, Integer>
implements IEnterpriseAddressService {

}
