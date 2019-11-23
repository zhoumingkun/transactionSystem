package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.toughguy.transactionSystem.model.content.po.TransactionActivity;
import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IActivitySignupInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionActivityService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.UploadUtil;

/**
 * 活动发布的控制类
 * 
 * @author liDongSheng
 *
 */
@Controller
@RequestMapping("/activity")
public class TransactionActivityController {
	@Autowired
	private ITransactionActivityService transactionActivityService;
	@Autowired
	private IActivitySignupInfoService acttivitySignupInfoService;
	//处理文件上传
	@RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
	@ResponseBody
	public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String name = UploadUtil.uploadPicture(file);
			String filename="upload/picture/"+name;
			map.put("code", "200");
			map.put("msg", "上传成功");
			map.put("filename", filename);
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "上传失败");
			return JsonUtil.objectToJson(map);
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	// 发布活动
	public String addActivity(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String activityName = request.getParameter("activityName");
			String activityPerson = request.getParameter("activityPerson");
			String activityContent = request.getParameter("activityContent");
			String activityImg = request.getParameter("activityImg");
			String activitySignupStart = request.getParameter("activitySignupStart");
			String activitySignupEnd = request.getParameter("activitySignupEnd");
			String activityStart = request.getParameter("activityStart");
			String activityEnd = request.getParameter("activityEnd");
			String activityInbusiness = request.getParameter("activityInbusiness");
			String activityAddress = request.getParameter("activityAddress");
			String activityTel = request.getParameter("activityTel");
			TransactionActivity activity = new TransactionActivity(activityName, activityPerson, activityContent,
					activityImg, DateUtil.getDate(activitySignupStart, "yyyy-MM-dd HH:mm:ss"),
					DateUtil.getDate(activitySignupEnd, "yyyy-MM-dd HH:mm:ss"),
					DateUtil.getDate(activityStart, "yyyy-MM-dd HH:mm:ss"),
					DateUtil.getDate(activityEnd, "yyyy-MM-dd HH:mm:ss"),
					activityInbusiness,activityAddress,activityTel);
			transactionActivityService.save(activity);
			map.put("code", "200");
			map.put("msg", "发布活动成功");
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}

	// 查看没有结束的活动
	@RequestMapping(value = "/lookNoEnd", method = RequestMethod.GET)
	@ResponseBody
	public String lookNoEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("activityName", request.getParameter("activityName"));
		PagerModel<TransactionActivity> findPaginated = transactionActivityService.findPaginated(params1);
		List<TransactionActivity> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}
	
	
	// 查看结束的活动到场情况
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	@ResponseBody
	public String lookEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("activityName", request.getParameter("activityName"));
		PagerModel<ActivitySignupInfo> findEndActivityPage = acttivitySignupInfoService.findEndActivityPage(params1);
		List<ActivitySignupInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	// 编辑活动
	public String editActivity(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String activityId = request.getParameter("activityId");
			String activityName = request.getParameter("activityName");
			String activityPerson = request.getParameter("activityPerson");
			String activityContent = request.getParameter("activityContent");
			String activityImg = request.getParameter("activityImg");
			String activitySignupStart = request.getParameter("activitySignupStart");
			String activitySignupEnd = request.getParameter("activitySignupEnd");
			String activityStart = request.getParameter("activityStart");
			String activityEnd = request.getParameter("activityEnd");
			String activityInbusiness = request.getParameter("activityInbusiness");
			String activityAddress = request.getParameter("activityAddress");
			String activityTel = request.getParameter("activityTel");
			TransactionActivity activity = new TransactionActivity(Integer.parseInt(activityId),activityName, activityPerson, activityContent,
					activityImg, DateUtil.getDate(activitySignupStart, "yyyy-MM-dd HH:mm:ss"),
					DateUtil.getDate(activitySignupEnd, "yyyy-MM-dd HH:mm:ss"),
					DateUtil.getDate(activityStart, "yyyy-MM-dd HH:mm:ss"),
					DateUtil.getDate(activityEnd, "yyyy-MM-dd HH:mm:ss"),
					activityInbusiness,activityAddress,activityTel);
			transactionActivityService.update(activity);
			map.put("code", "200");
			map.put("msg", "修改成功");
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	@RequestMapping(value = "/lookActivity", method = RequestMethod.GET)
	@ResponseBody
	// 查看活动
	public String lookActivity(int activityId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			TransactionActivity find = transactionActivityService.find(activityId);
			map.put("code", "200");
			map.put("msg", "查找成功");
			map.put("date", find);
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	
	
}
