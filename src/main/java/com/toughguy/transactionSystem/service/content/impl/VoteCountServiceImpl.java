package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.persist.content.prototype.IVoteCountDao;
import com.toughguy.transactionSystem.service.content.prototype.IVoteCountService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class VoteCountServiceImpl
extends GenericServiceImpl<TransactionVoteCount, Integer>
implements IVoteCountService {

	@Autowired
	private IVoteCountDao dao;
	
	@Override
	public String check(TransactionVoteCount transactionVoteCount) {
		// TODO Auto-generated method stub
		TransactionVoteCount info = dao.findInfo(transactionVoteCount);		//查询投票
		TransactionVoteCount findTime = dao.findTime(transactionVoteCount);			//查询投票日期区间
		
		if(info==null && findTime!=null) {		//没投票   在规定时间
			return "a";				//可以继续投票
		}
		if(info==null && findTime==null) {		//没投票   但不再规定时间
			return "b";				//不能继续投票
		}
		if(info!=null) {		//投过一次票   
			return "c";			//不以投票
		}
		return "d";
	}
	
		

}
