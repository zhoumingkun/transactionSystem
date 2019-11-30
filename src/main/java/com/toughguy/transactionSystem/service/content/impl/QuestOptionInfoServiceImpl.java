package com.toughguy.transactionSystem.service.content.impl;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.QuestOptionInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IQuestOptionInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IQuestOptionInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;

@Service
public class QuestOptionInfoServiceImpl 
						extends GenericServiceImpl<QuestOptionInfo, Integer>
						implements	IQuestOptionInfoService{

	@Autowired
	private IQuestOptionInfoDao infoDao;
	@Override
	public List<QuestOptionInfo> findOne(QuestOptionInfo info) {
		return infoDao.findOneInfo(info);
	}

	@Override
	public void insertInfo(QuestOptionInfo info) {
		infoDao.insertOneInfo(info);
	}

/*	@Override
	public List<QuestOptionInfo> selectEnd() {
		
		return infoDao.selectEnd();
	}*/

	public PagerModel<QuestOptionInfo> selectNoEnd(Map<String, Object> params) {
		return infoDao.selectNoEnd(params);
	}


	
	

}
