package com.toughguy.transactionSystem.service.content.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Service;

import com.toughguy.transactionSystem.model.content.WXBind;
import com.toughguy.transactionSystem.persist.content.prototype.IWXBindDao;
import com.toughguy.transactionSystem.service.content.prototype.IWXBindService;
import com.toughguy.transactionSystem.service.impl.GenericServiceImpl;


/**
 * 用户信息查询绑定service实现类
 * @author 
 *
 */
@Service
public class WXBindServiceImpl extends GenericServiceImpl<WXBind,Integer> implements IWXBindService{

	@Override
	public Map<String,String> insertBind(WXBind bind) {
		Map<String,String> map = new HashMap<>();
		try {
			Map<String,String> mapbind = new HashMap<>();
			mapbind.put("cardnumber", bind.getCardno());
			mapbind.put("tel", bind.getUsermobile());
			List<WXBind> list = ((IWXBindDao)dao).findBindInfo(mapbind);
			if(list.size()<=0){
				map.put("state", "400");
				return map;
			}else {
				((IWXBindDao)dao).insertBind(bind);		//根据时间戳与用户的卡号手机号绑定
				map.put("state", "200");
				return map;
			}
		} catch (Exception e) {
			map.put("state", "400");
			return map;
		}
		
	}
	
	
	@Override
	public Map<String,String> deleteTime(WXBind wx) {
		Map<String,String> map = new HashMap<>();
		try {
			((IWXBindDao)dao).deleteTime(wx);		//根据时间戳与用户的卡号手机号绑定
		} catch (Exception e) {
			map.put("state", "400");
			return map;
		}
		map.put("state", "200");
		return map;
	}
	
	
	@Override
	public Map<String,String> selectOpenid(WXBind wx) {
		Map<String,String> map = new HashMap<>();
		WXBind bind=((IWXBindDao)dao).selectOpenid(wx);
		if(bind!=null) {
			if((bind.getCardno()!="" && bind.getUsermobile()!="") ||(bind.getCardno()!=null && bind.getUsermobile()!=null)) {
				map.put("state", "200");
				map.put("openid", bind.getOpenid());
				map.put("cardnumber", bind.getCardno());
				map.put("tel", bind.getUsermobile());
				List<WXBind> list = ((IWXBindDao)dao).findBindInfo(map);
				if(list.size()<=0) {
					map.put("Cashleft",null);
					return map;
				}else {
					map.put("Cashleft", list.get(0).getCashleft());
					return map;
				}
				
			}else {
				map.put("state", "400");
				return map;
			}
		}else {
			map.put("state", "400");
			return map;
		}
		
	}
	
	
	@Override
	public Map<String,String> selecUserBind(WXBind bind) {
		WXBind wxBind = ((IWXBindDao)dao).selecUserBind(bind);		//直接通过卡号和用户手机号查询
		Map<String,String> map = new HashMap<>();
		Map<String,String> cashleft = new HashMap<>();
		if(wxBind!=null) {
			cashleft.put("cardnumber", wxBind.getCardno());
			cashleft.put("tel", wxBind.getUsermobile());
			List<WXBind> list = ((IWXBindDao)dao).findBindInfo(cashleft);
			if(list.size()<=0) {
				map.put("state","400");
				return map;
			}else {
				map.put("state", "200");
				map.put("Cashleft", list.get(0).getCashleft());
				return map;
			}
		}else {
			map.put("state", "400");
			return map;
		}
		
	}
}
