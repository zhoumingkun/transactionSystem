package com.toughguy.transactionSystem.persist.content.prototype;

import java.util.Map;

import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.persist.prototype.IGenericDao;

public interface IActivitySignupInfoDao extends IGenericDao<ActivitySignupInfo, Integer>{
	/**
	 * 分页查询活动结束参与的人数
	 * @param params 查询的条件参数
	 * @param methodName mybatis配置文件中所配置的方法名程
	 * @return 所要的分页数据
	 */
	public PagerModel<ActivitySignupInfo> findEndActivity(Map<String, Object> params);
	
	
	/**
	 * 分页查询活动结束报名的人数
	 * @param params 查询的条件参数
	 * @param methodName mybatis配置文件中所配置的方法名程
	 * @return 所要的分页数据
	 */
	public PagerModel<ActivitySignupInfo> findEndActivitySignup(Map<String, Object> params);
}
