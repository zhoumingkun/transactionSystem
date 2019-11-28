package com.toughguy.transactionSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionActivity;
import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IActivitySignupInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionActivityService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionSignupService;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.UploadUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 活动发布的控制类
 * 
 * @author liDongSheng
 *
 */
@RestController
@RequestMapping("/activity")
@Slf4j
@Api(tags="ActivityController")
public class TransactionActivityController {
	//活动
	@Autowired
	private ITransactionActivityService transactionActivityService;
	//活动报名
	@Autowired
	private IActivitySignupInfoService activitySignupInfoService;
	//报名
	@Autowired
	private ITransactionSignupService transactionSignupService;
	@Autowired
	private ITransactionLogService logService;
	
	//处理图片上传
	@ApiOperation(value = "图片上传",notes = "上传的图片在upload/picture/文件夹下")
	@RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
	public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String name = UploadUtil.uploadPicture(file);
			String filename="upload/picture/"+name;
			map.put("code", "200");
			map.put("msg", "上传成功");
			map.put("filename", filename);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "上传失败");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 发布活动
	@ApiOperation(value = "活动发布",notes = "发布活动的具体内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityName", value = "活动的名称",required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "activityPerson", value = "活动发起企业（人）",required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "activityContent", value = "活动内容",required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "activityImg", value = "活动图片",required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "activitySignupStart", value = "活动报名开始时间",required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "activitySignupEnd", value = "活动报名结束时间",required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "activityStart", value = "活动开始时间",required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "activityEnd", value = "活动结束时间",required = true, dataType = "Date", paramType = "query"),
		@ApiImplicitParam(name = "activityInbusiness", value = "与会企业",required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "activityAddress", value = "活动地址",required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "activityTel", value = "活动电话",required = true, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addActivity(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JSONObject json = requestJSONUtil.request(request, response);
			int rootId =  json.getInteger("rootId");
			String activityName = json.getString("activityName");
			String activityPerson = json.getString("activityPerson");
			String activityContent = json.getString("activityContent");
			String activityImg = json.getString("activityImg");
			Date activitySignupStart = json.getDate("activitySignupStart");
			Date activitySignupEnd = json.getDate("activitySignupEnd");
			Date activityStart =json.getDate("activityStart");
			Date activityEnd = json.getDate("activityEnd");
			String activityInbusiness = json.getString("activityInbusiness");
			String activityAddress = json.getString("activityAddress");
			String activityTel = json.getString("activityTel");
			System.out.println(activitySignupStart);
			TransactionActivity activity = new TransactionActivity(activityName, activityPerson, activityContent,activityImg, activitySignupStart,activitySignupEnd,activityStart,activityEnd,activityInbusiness,activityAddress,activityTel);
			transactionActivityService.save(activity);
			logService.insert("发布 "+activityName+"活动", rootId);
			map.put("code", "200");
			map.put("msg", "发布活动成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 活动:查看没有结束的活动
	@ApiOperation(value = "未开始的活动",notes = "默认查全部未完成活动，可以传参page和rows进行分页查找，activityName进行关键字模糊查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityName", value = "活动名称",required = false, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/lookNoEnd", method = RequestMethod.GET)
	public String lookNoEnd(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String activityName = request.getParameter("activityName");
		params1.put("activityName", activityName);
		PagerModel<TransactionActivity> findPaginated = transactionActivityService.findPaginated(params1);
		List<TransactionActivity> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "200");
		params.put("msg", "查找成功");
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}
	
	
	// 活动:查看结束的活动到场情况
	@ApiOperation(value = "结束的活动",notes = "默认查全部已结束的活动，可以传参page和rows进行分页查找，activityName进行关键字模糊查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityName", value = "活动名称",required = false, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	public String lookEnd(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String activityName = request.getParameter("activityName");
		params1.put("activityName", activityName);
		PagerModel<ActivitySignupInfo> findEndActivityPage = activitySignupInfoService.findEndActivityPage(params1);
		List<ActivitySignupInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		param.put("code", "200");
		param.put("msg", "查找成功");
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 删除活动
	@ApiOperation(value = "删除活动",notes = "通过活动id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rootId", value = "管理员id",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityId", value = "活动编号",required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delActivity(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int rootId = Integer.parseInt(request.getParameter("rootId"));
		int activityId = Integer.parseInt(request.getParameter("activityId"));
		try {
			transactionActivityService.delete(activityId);
			transactionSignupService.delete(activityId);
			TransactionActivity find = transactionActivityService.find(activityId);
			logService.insert("删除了"+find.getActivityName()+"活动", rootId);
			map.put("code", "200");
			map.put("msg", "删除成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// pc:查看某一个活动
	@ApiOperation(value = "查看具体某一个的活动",notes = "通过活动id来查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "activityId", value = "活动编号",required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/lookActivity", method = RequestMethod.GET)
	public String lookActivity(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int activityId = Integer.parseInt(request.getParameter("activityId"));
		try {
			TransactionActivity find = transactionActivityService.find(activityId);
			map.put("code", "200");
			map.put("msg", "查找成功");
			map.put("data", find);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	

}
