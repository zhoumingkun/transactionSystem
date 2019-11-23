package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IActivitySignupInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionSignupService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.JsonUtil;
/**
 * 报名的控制类
 * @author liDongSheng
 *
 */

@Controller
@RequestMapping("/signup")
public class TransactionSignupController {
	@Autowired
	private ITransactionSignupService transactionSignupService;
	@Autowired
	private IActivitySignupInfoService acttivitySignupInfoService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	//新增报名
	public String addSignup(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String activityId = request.getParameter("activityId");
			String memberId = request.getParameter("memberId");
			String signupDate = request.getParameter("signupDate");
			String signupCode = request.getParameter("signupCode");
			TransactionSignup signup = new TransactionSignup(Integer.parseInt(activityId),Integer.parseInt(memberId),DateUtil.getDate(signupDate),signupCode);
			transactionSignupService.save(signup);
			map.put("code", "200");
	        map.put("msg", "报名成功");
			return JsonUtil.objectToJson(map);
		}catch (Exception e) {
			map.put("code", "500");
	        map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	//查看未结束的活动报名情况
	@RequestMapping(value = "/lookNoEnd", method = RequestMethod.GET)
	@ResponseBody
	public String lookNoEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("activityName", request.getParameter("activityName"));
		PagerModel<ActivitySignupInfo> findPaginated = acttivitySignupInfoService.findPaginated(params1);
		List<ActivitySignupInfo> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}
	// 查看结束的活动报名情况
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	@ResponseBody
	public String lookEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("activityName", request.getParameter("activityName"));
		PagerModel<ActivitySignupInfo> findEndActivityPage = acttivitySignupInfoService.findEndActivityPageSignup(params1);
		List<ActivitySignupInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	//查看所有报名人和人数
	/*@RequestMapping(value="/looksignup",method=RequestMethod.GET)
	@ResponseBody
	public String lookSignup(HttpServletRequest request) {
		Map<String, Object> params=new HashMap<String, Object>();
		boolean signupStatus = Boolean.parseBoolean(request.getParameter("signupStatus"));
		params.put("signupStatus",signupStatus); 
		PagerModel<TransactionSignup> findPaginated = transactionSignupService.findPaginated(params);
		List<TransactionSignup> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params1=new HashMap<String, Object>();
		params1.put("data", data);
		params1.put("total", total);
		return JsonUtil.objectToJson(params1);
	}*/
	
	//修改入场人的状态
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	@ResponseBody
	public String modifySignup(int signupId,Boolean signupStatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			TransactionSignup signup = new TransactionSignup();
			signup.setSignupId(signupId);
			signup.setSignupStatus(signupStatus);
			transactionSignupService.update(signup);
			map.put("code", "200");
	        map.put("msg", "欢迎入场");
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
	        map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	

	

}
