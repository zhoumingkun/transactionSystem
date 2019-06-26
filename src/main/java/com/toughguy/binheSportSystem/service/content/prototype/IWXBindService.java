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
	 * 用户卡号手机号与openid绑定
	 * @param openid
	 * @return
	 */
	public Map<String,String> insertBind(WXBind bind);
	
	
	/**
	 * 解除绑定  删除数据库卡号与openid的信息
	 * @param openid
	 * @return
	 */
	public Map<String,String> deleteTime(WXBind wx);
	
	
	/**
	 * 查询该用户是否绑定(绑定就查询该用户的余额信息)
	 * @param openid
	 * @return
	 */
	public Map<String,String> selectOpenid(WXBind wx);
	
	
	/**
	 * 通过卡号手机号openid查询用户信息(查询过直接返回余额)
	 * @param openid
	 * @return
	 */
	public Map<String,String> selecUserBind(WXBind wx);
	
}
