package com.toughguy.binheSportSystem.persist.content.prototype;

import java.util.List;
import java.util.Map;
import com.toughguy.binheSportSystem.model.content.WXBind;
import com.toughguy.binheSportSystem.persist.prototype.IGenericDao;


/**
 * 用户信息查询绑定Dao接口类
 * @author 
 *
 */
public interface IWXBindDao extends IGenericDao<WXBind, Integer>{
	
	/**
	 * 数据库添加用户卡号手机号openid
	 */
	public void insertBind(WXBind bind);
	
	
	/**
	 * 解除绑定(删除数据库卡号与openid的信息)
	 */
	public void deleteTime(WXBind wx);
	
	
	/**
	 * 查询用户是否绑定过
	 */
	public WXBind selectOpenid(WXBind wx);
	
	
	/**
	 * 通过卡号手机号查询用户信息
	 * @param map
	 * @return
	 */
	public List<WXBind> findBindInfo(Map<String,String> map);
	

	/**
	 * 通过卡号手机号openid查询用户信息
	 * @param map
	 * @return
	 */
	public WXBind selecUserBind(WXBind bind);
	
	
	
}
