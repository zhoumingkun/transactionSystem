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
	 * 将会员的卡号手机号与openid进行绑定(绑定前查询这个人是否真实存在)
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertTime")
	public Map<String,String> insertBind(@RequestParam(name = "cardnumber") String cardno, @RequestParam(name = "tel") String usermobile, @RequestParam(name = "openid") String openid) {
		WXBind wxBind =new WXBind();
		wxBind.setCardno(cardno);
		wxBind.setOpenid(openid);
		wxBind.setUsermobile(usermobile);
		System.out.println(openid+"  "+cardno+"  "+usermobile);
		return wxbindservice.insertBind(wxBind);			
	}
	
	/**
	 * 解除绑定(删除数据库的绑定信息)
	 * @param openid
	 * @return
	 */
	@RequestMapping("/deleteTime")
	public Map<String,String> deleteTime(@RequestParam(name = "openid") String openid) {
		WXBind bind =new WXBind();
		bind.setOpenid(openid);
		return wxbindservice.deleteTime(bind);			
	}
	
	/**
	 * 根据openid查询数据库是否绑定过,绑定过返回余额
	 * @param openid
	 * @return
	 */
	@RequestMapping("/selectOpenid")
	public Map<String,String> selectOpenid(@RequestParam(name = "openid") String openid) {
		WXBind wxBind =new WXBind();
		wxBind.setOpenid(openid);
		return wxbindservice.selectOpenid(wxBind);			
	}
	
	/**
	 * 通过卡号手机号openid查询数据库是否绑定过,绑过返回余额
	 * @param map
	 * @return
	 */
	@RequestMapping("/selecUserBind")
	public Map<String,String> selecUserBind(@RequestParam(name = "cardnumber") String cardno, @RequestParam(name = "tel") String usermobile,@RequestParam(name = "openid") String openid){
		WXBind wxBind =new WXBind();
		wxBind.setCardno(cardno);
		wxBind.setOpenid(openid);
		wxBind.setUsermobile(usermobile);
		return wxbindservice.selecUserBind(wxBind);		
	}
	
}
