package com.toughguy.educationSystem.service.content.prototype;

import com.toughguy.educationSystem.model.content.Activity;
import com.toughguy.educationSystem.service.prototype.IGenericService;

/**
 * 校园活动Service层接口类
 * @author zmk
 *
 */
public interface IActivityService extends IGenericService<Activity, Integer>{
	/**
	 * 查询最新的活动动态消息
	 * */
	public Activity findNew();
}
