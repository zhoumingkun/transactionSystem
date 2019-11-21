package com.toughguy.transactionSystem.controller.content;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toughguy.transactionSystem.service.content.prototype.ITransactionMemberService;
import com.toughguy.transactionSystem.util.ExcelUtil;

@Controller
public class TransactionMemberController {
	@Autowired
	private ITransactionMemberService ts;
	/*
	 * 登录
	@RequestMapping("/aa")
	@ResponseBody
	public String aa(String tel,String pwd) {
		TransactionMember transactionMember = new TransactionMember();
		transactionMember.setMemberPwd(pwd);
		transactionMember.setMemberTel(tel);
		 Map<String, Object> map = new HashMap<String, Object>();
		 try {
			 transactionMember=ts.findmeber(transactionMember);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
			return  JsonUtil.objectToJson(map);
		}
		if(transactionMember==null) {
	        map.put("code", "404");
	        map.put("msg", "用户名或密码错误");
		}else {
			 map.put("code", "200");
			 map.put("msg", "登录成功");
		}
		return JsonUtil.objectToJson(map);
	}*/
	//导出excel
	@RequestMapping("/bb")
	 public void downloadAllClassmate1(HttpServletResponse response){
		 List<String> titles =new ArrayList<String>();
		 titles.add("会员id");
		 titles.add("电话");
		 titles.add("密码");
		 titles.add("时间");
		 titles.add("姓名");
		 titles.add("身份证号");
      try {
		ExcelUtil.exportExcel(response, "123", ts.findMeberAll(), titles,"123");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	
	
	
}
