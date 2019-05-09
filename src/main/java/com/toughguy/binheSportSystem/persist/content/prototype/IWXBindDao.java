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
	 * 绑定成功数据库添加openid和用户信息绑定
	 */
	//public void save(WXBind wx);
	
	/**
	 * 查询用户是否绑定过卡
	 * @param openid
	 * @return
	 */
	//public WXBind findOne(String openid);
	
	/**
	 * 通过卡号手机号查询是否存在用户
	 * @param map
	 * @return
	 */
	public List<WXBind> findBindInfo(Map<String,Object> map);
	
	
	/**
	 * 通过卡号 取卡时间 手机号等查询是否存在该用户
	 * @param map
	 * @return
	 */
	public List<WXBind> findUsedBindInfo(Map<String,Object> map);
}
