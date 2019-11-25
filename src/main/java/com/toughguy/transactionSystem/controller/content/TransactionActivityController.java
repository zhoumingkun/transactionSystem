package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.toughguy.transactionSystem.model.content.po.TransactionActivity;
import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IActivitySignupInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionActivityService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionSignupService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.UploadUtil;

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
	@Autowired
	private ITransactionActivityService transactionActivityService;
	@Autowired
	private IActivitySignupInfoService activitySignupInfoService;
	@Autowired
	private ITransactionSignupService transactionSignupService;
	
	
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
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "上传失败");
			return JsonUtil.objectToJson(map);
		}
	}
	
	// 发布活动
	@ApiOperation(value = "活动发布",notes = "发布活动的具体内容")
	@ApiImplicitParams({
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
	
	// 活动:查看没有结束的活动
	@ApiOperation(value = "未开始的活动",notes = "默认查全部未完成活动，可以传参page和rows进行分页查找，activityName进行关键字模糊查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityName", value = "活动名称",required = false, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/lookNoEnd", method = RequestMethod.GET)
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
	
	
	// 活动:查看结束的活动到场情况
	@ApiOperation(value = "结束的活动",notes = "默认查全部已结束的活动，可以传参page和rows进行分页查找，activityName进行关键字模糊查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityName", value = "活动名称",required = false, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	public String lookEnd(HttpServletRequest request) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("activityName", request.getParameter("activityName"));
		PagerModel<ActivitySignupInfo> findEndActivityPage = activitySignupInfoService.findEndActivityPage(params1);
		List<ActivitySignupInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}
	
	// 删除活动
	@ApiOperation(value = "删除活动",notes = "通过活动id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "activityId", value = "活动编号",required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delActivity(int activityId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			transactionActivityService.delete(activityId);
			transactionSignupService.delete(activityId);
			map.put("code", "200");
			map.put("msg", "删除成功");
			return JsonUtil.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
			return JsonUtil.objectToJson(map);
		}
	}
	
	// 查看某一个活动
	@ApiOperation(value = "查看具体某一个的活动",notes = "通过活动id来查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "activityId", value = "活动编号",required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/lookActivity", method = RequestMethod.GET)
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
