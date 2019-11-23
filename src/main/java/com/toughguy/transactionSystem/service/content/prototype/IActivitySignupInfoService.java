package com.toughguy.transactionSystem.service.content.prototype;

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
	public PagerModel<ActivitySignupInfo> findEndActivityPageSignup(Map<String, Object> params);
}
