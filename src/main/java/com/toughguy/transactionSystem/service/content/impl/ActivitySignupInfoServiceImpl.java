package com.toughguy.transactionSystem.service.content.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.content.prototype.IActivitySignupInfoDao;
import com.toughguy.transactionSystem.service.content.prototype.IActivitySignupInfoService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;
@Service
public class ActivitySignupInfoServiceImpl extends GenericServiceImpl<ActivitySignupInfo, Integer>implements IActivitySignupInfoService{
	@Autowired
	private IActivitySignupInfoDao ActivitySignupInfoDao;
	
	@Override
	public PagerModel<ActivitySignupInfo> findEndActivityPage(Map<String, Object> params) {
		return ActivitySignupInfoDao.findEndActivity(params);
	}

	@Override
	public PagerModel<ActivitySignupInfo> findEndActivityPageSignup(Map<String, Object> params) {
		return ActivitySignupInfoDao.findEndActivitySignup(params);
	}

	@Override
	public ActivitySignupInfo findDefiniteSignupDetails(ActivitySignupInfo activitySignupInfo) {
		return ActivitySignupInfoDao.findSignup(activitySignupInfo);
	}

	@Override
	public PagerModel<ActivitySignupInfo> findStayAttendActivityList(Map<String, Object> params) {
		return ActivitySignupInfoDao.findStayAttendActivityList(params);
	}

	@Override
	public PagerModel<ActivitySignupInfo> findEndAttendActivityList(Map<String, Object> params) {
		return ActivitySignupInfoDao.findEndAttendActivityList(params);
	}
}
