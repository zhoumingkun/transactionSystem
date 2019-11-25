package com.toughguy.transactionSystem.service.content.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.prototype.IGenericService;

public interface IActivitySignupInfoService extends IGenericService<ActivitySignupInfo, Integer> {
	/**
	 * 分页查询结束的活动
	 * @param params 查询的条件参数
	 * @param methodName mybatis配置文件中所配置的方法名程
	 * @return 所要的分页数据
	 */
	public PagerModel<ActivitySignupInfo> findEndActivityPage(Map<String, Object> params);
	/**
	 * 查询活动结束的报名
	 * @param params
	 * @return
	 */
	public PagerModel<ActivitySignupInfo> findEndActivityPageSignup(Map<String, Object> params);
	/**
	 * 查找用户具体的某一个活动详情
	 * @param activitySignupInfo
	 * @return
	 */
	public ActivitySignupInfo findDefiniteSignupDetails(ActivitySignupInfo activitySignupInfo);
	
	/**
	 * 查找待参加的活动列表
	 * @param transactionActivity
	 * @return
	 */
	public List<ActivitySignupInfo> findStayAttendActivityList(ActivitySignupInfo activitySignupInfo);
	/**
	 * 查找以参加的活动列表
	 * @param transactionActivity
	 * @return
	 */
	public List<ActivitySignupInfo> findEndAttendActivityList(ActivitySignupInfo activitySignupInfo);
}
