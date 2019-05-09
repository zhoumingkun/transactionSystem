package com.toughguy.binheSportSystem.service.content.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Service;
import com.toughguy.binheSportSystem.model.content.WXBind;
import com.toughguy.binheSportSystem.persist.content.prototype.IWXBindDao;
import com.toughguy.binheSportSystem.service.content.prototype.IWXBindService;
import com.toughguy.binheSportSystem.service.impl.GenericServiceImpl;


/**
 * 用户信息查询绑定service实现类
 * @author 
 *
 */
@Service
public class WXBindServiceImpl extends GenericServiceImpl<WXBind,Integer> implements IWXBindService{

//	@Override
//	public WXBind findOne(String openid) {
//		// TODO Auto-generated method stub
//		WXBind bind = ((IWXBindDao)dao).findOne(openid);	//根据该用户openid查询该用户是否绑定过会员卡
//		WXBind b = new WXBind();		
//		if(bind.getOpenid().equals(openid) && bind.getCardno() !=null  && !bind.getCardno().equals(" ") ) {	
//			return bind;
//		}else {
//			return b;
//		}
//		
//	}
	
	@Override
	public List<WXBind> findBindInfo(Map<String,Object> map) {
		List<WXBind> info = ((IWXBindDao)dao).findBindInfo(map);		//直接通过卡号和用户手机号查询
		if(info.size()>0 && info.get(0).getCardno()!=null &&info.get(0).getCardno()!=" ") {
			info.get(0).setState("200");
			return info;
		}else{
			List<WXBind> listInfo = ((IWXBindDao)dao).findUsedBindInfo(map);					//通过卡号 取卡时间 手机号等查询
			if(listInfo.size()>0 && listInfo.get(0).getUsermobile().length() < 7 ) {			//判断手机号是否是旧卡号的位数	
				listInfo.get(0).setState("200");
				return listInfo;
			}else {
				List<WXBind> list = new ArrayList<>();			//如果未查找到则返回一个空对象
				WXBind mi = new WXBind();
				mi.setState("400");
				list.add(mi);
				return list;
			}
		}
	}
}
