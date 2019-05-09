package com.toughguy.binheSportSystem.service.content.prototype;

import java.util.List;
import java.util.Map;
import com.toughguy.binheSportSystem.model.content.WXBind;
import com.toughguy.binheSportSystem.service.prototype.IGenericService;

/**
 * 用户信息查询绑定service接口类
 * @author 
 *
 */
public interface IWXBindService extends IGenericService<WXBind, Integer> {
	/**
	 * 查询用户是否绑定过卡
	 * @param openid
	 * @return
	 */
	//public WXBind findOne(String openid);
	
	/**
	 * 根据卡号手机号查询绑定
	 * @param map
	 * @return
	 */
	public List<WXBind> findBindInfo(Map<String,Object> map);
}
