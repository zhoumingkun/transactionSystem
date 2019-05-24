package com.toughguy.binheSportSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.binheSportSystem.model.content.WXBind;
import com.toughguy.binheSportSystem.service.content.prototype.IWXBindService;

/**
 * 用户信息查询绑定Controller类
 * @author 
 *
 */
@RestController
@RequestMapping("/member")
public class MemberBindController {
	
	@Autowired
	private IWXBindService wxbindservice;

	/**
	 * 会员信息的绑定 返回List<WXBind> 对象非空绑定成功  对象为null绑定失败
	 * @param
	 */
	@RequestMapping("/findinfo")
	public List<WXBind> findBindInfo(@RequestParam(name = "cardnumber") String cardno, @RequestParam(name = "tel") String usermobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cardno", cardno);
		map.put("usermobile",usermobile);
		List<WXBind> list = wxbindservice.findBindInfo(map); 	//返回数据为绑定成功 返回null 为绑定失败
		return list;
	}
	
	/**
	 * 会员卡绑定生成随机4位数字验证码
	 */
	@RequestMapping("/RandowFourNumber")
	public Map BindVerificationCode(){
		Map map = new HashMap<>();
		int four =(int)((Math.random()*9+1)*1000);
		map.put("value", four+"");
		return map;
	}
	
	/**
	 * 通过存放在session中的openid查询该用户是否绑定过会员卡
	 * @param request
	 * @return
	 */
//	@RequestMapping("/findOne")
//	public WXBind findOne(HttpServletRequest request) {
//		HttpSession session = request.getSession(true);
//		String openid = (String)session.getAttribute("openid");		//从session中获取openid
//		WXBind wxBind = wxbindservice.findOne(openid);			//查询数据库该openid是否绑定过
//		return wxBind;
//	}
}
