package com.toughguy.transactionSystem.controller.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionSignup;
import com.toughguy.transactionSystem.model.content.vo.ActivitySignupInfo;
import com.toughguy.transactionSystem.model.content.vo.EnterpriseSignupInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IActivitySignupInfoService;
import com.toughguy.transactionSystem.service.content.prototype.IEnterpriseSignupInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionSignupService;
import com.toughguy.transactionSystem.util.ExcelUtil;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * 报名的控制类
 * @author liDongSheng
 *
 */

@RestController
@RequestMapping("/signup")
@Slf4j
@Api(tags="SignupController")
public class TransactionSignupController {
	//报名表service
	@Autowired
	private ITransactionSignupService transactionSignupService;
	//活动表和报名表联系的service
	@Autowired
	private IActivitySignupInfoService acttivitySignupInfoService;
	//企业表和报名表联系的service
	@Autowired
	private IEnterpriseSignupInfoService enterpriseSignupInfoService;
	
	//会员查看某一个活动的详情
	@ApiOperation(value = "会员查看某一个活动的详情",notes = "通过活动id和会员id进行查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "activityId", value = "活动的id",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "memberId", value = "会员的id",required = true, dataType = "int", paramType = "query"),
	})
	@RequestMapping(value="/definiteSignupDetails",method=RequestMethod.GET)
	public String definiteSignupDetails(HttpServletRequest request,HttpServletResponse response) {
		int activityId = Integer.parseInt(request.getParameter("activityId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		ActivitySignupInfo activitySignupInfo = new ActivitySignupInfo();
		activitySignupInfo.setActivityId(activityId);
		activitySignupInfo.setMemberId(memberId);
		Map<String, Object> map = new HashMap<String, Object>();
		ActivitySignupInfo findDefiniteSignupDetails = acttivitySignupInfoService.findDefiniteSignupDetails(activitySignupInfo);
		map.put("code", "200");
	    map.put("msg", "查找成功");
	    map.put("data", findDefiniteSignupDetails);
	    return JsonUtil.objectToJson(map);
	}
	
	
	//新增报名
	@ApiOperation(value = "新增报名",notes = "先通过活动id和会员id进行判断是否报名，没有的话进行报名")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "activityId", value = "活动的id",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "memberId", value = "会员的id",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "signupCode", value = "二维码",required = true, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addSignup(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = requestJSONUtil.request(request, response);
		int activityId = json.getInteger("activityId");
		int memberId = json.getInteger("memberId");
		TransactionSignup signup = new TransactionSignup();
		signup.setActivityId(activityId);
		signup.setMemberId(memberId);
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionSignup judgeSignup = transactionSignupService.judgeSignup(signup);
		if(judgeSignup!=null) {
			map.put("code", "500");
	        map.put("msg", "已报名");
		}else {
			String signupCode = json.getString("signupCode");
			signup.setSignupCode(signupCode);
			try {
				transactionSignupService.save(signup);
				map.put("code", "200");
		        map.put("msg", "报名成功");
			}catch (Exception e) {
				map.put("code", "500");
		        map.put("msg", "服务器错误");
			}
		}
		return JsonUtil.objectToJson(map);
	}
	
	//查看未结束的活动报名情况
	@ApiOperation(value = "报名管理:未结束活动",notes = "默认查全部未结束的活动，可以传参page和rows进行分页查找，activityName进行关键字模糊查找")
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
		PagerModel<ActivitySignupInfo> findPaginated = acttivitySignupInfoService.findPaginated(params1);
		List<ActivitySignupInfo> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}
	// 查看结束的活动报名情况
	@ApiOperation(value = "报名管理:结束活动",notes = "默认查全部结束的活动，可以传参page和rows进行分页查找，activityName进行关键字模糊查找")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityName", value = "活动名称",required = false, dataType = "String", paramType = "query"),
	})
	@RequestMapping(value = "/lookEnd", method = RequestMethod.GET)
	public String lookEnd(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String activityName = request.getParameter("activityName");
		params1.put("activityName", activityName);
		PagerModel<ActivitySignupInfo> findEndActivityPage = acttivitySignupInfoService.findEndActivityPageSignup(params1);
		List<ActivitySignupInfo> data = findEndActivityPage.getData();
		int total = findEndActivityPage.getTotal();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", data);
		param.put("total", total);
		return JsonUtil.objectToJson(param);
	}

	//修改入场人的状态
	@ApiOperation(value = "修改参加会议人的状态",notes = "默认没来为0或者false，来了是1或者true")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "activityId", value = "活动的id",required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "memberId", value = "会员的id",required = true, dataType = "int", paramType = "query"),
	})
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifySignup(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int activityId = Integer.parseInt(request.getParameter("activityId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		try {
			TransactionSignup signup = new TransactionSignup();
			signup.setActivityId(activityId);
			signup.setMemberId(memberId);
			transactionSignupService.update(signup);
			map.put("code", "200");
	        map.put("msg", "欢迎入场");
		} catch (Exception e) {
			map.put("code", "500");
	        map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 用户查看待参加的活动
	@ApiOperation(value = "会员查看待参加的活动", notes = "默认查全部待参加的活动，可以传参page和rows进行分页查找,需要会员id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "memberId", value = "会员的id", required = true, dataType = "int", paramType = "query")
		})
	@RequestMapping(value = "/lookStayJoinActivity", method = RequestMethod.GET)
	public String lookStayJoinActivity(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String memberId = request.getParameter("memberId");
		param.put("memberId",memberId);
		PagerModel<ActivitySignupInfo> findStayAttendActivityList = acttivitySignupInfoService.findStayAttendActivityList(param);
		map.put("code", "200");
		map.put("msg", "查找成功");
		map.put("data", findStayAttendActivityList.getData());
		map.put("total", findStayAttendActivityList.getTotal());
		return JsonUtil.objectToJson(map);
	}
	
	// 用户查看已参加的活动
	@ApiOperation(value = "会员查看已参加的活动", notes = "默认查全部已参加的活动，可以传参page和rows进行分页查找,需要会员id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "memberId", value = "会员的id", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/lookEndJoinActivity", method = RequestMethod.GET)
	public String lookEndJoinActivity(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String memberId = request.getParameter("memberId");
		param.put("memberId", memberId);
		PagerModel<ActivitySignupInfo> findEndAttendActivityList = acttivitySignupInfoService.findEndAttendActivityList(param);
		map.put("code", "200");
		map.put("msg", "查找成功");
		map.put("data", findEndAttendActivityList.getData());
		map.put("total", findEndAttendActivityList.getTotal());
		return JsonUtil.objectToJson(map);
	}
	
	// pc:查看某一项活动的具体报名公司
	@ApiOperation(value = "查看某一项活动具体的报名公司", notes = "需要活动id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "页数",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "页大小",required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "activityId", value = "活动的id", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/lookSpecificSignupEnterprise", method = RequestMethod.GET)
	public String lookSpecificSignupEnterprise(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		String activityId = request.getParameter("activityId");
		param.put("activityId",activityId );
		PagerModel<EnterpriseSignupInfo> findPaginated = enterpriseSignupInfoService.findPaginated(param);
		map.put("code", "200");
		map.put("msg", "查找成功");
		map.put("data", findPaginated.getData());
		map.put("total", findPaginated.getTotal());
		return JsonUtil.objectToJson(map);
	}
	
	// pc:导出某项活动的报名企业
	@ApiOperation(value = "导出某项活动的报名企业", notes = "直接导出全部数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "primaryTitle", value = "标题也是文件名", required = true, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "query"),
	})
	@RequestMapping(value = "/exportSignupEnterprise", method = RequestMethod.POST)
	public String exportSignupEnterprise(HttpServletResponse resp,HttpServletRequest request) {
		JSONObject json = requestJSONUtil.request(request, resp);
		String primaryTitle = json.getString("primaryTitle");
		int activityId = json.getInteger("activityId");
		List<String> titles=new ArrayList<String>();
		titles.add("企业名称");
		titles.add("报名时间");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("activityId", activityId);
		PagerModel<EnterpriseSignupInfo> findPaginated = enterpriseSignupInfoService.findPaginated(param);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ExcelUtil.exportExcel(resp, primaryTitle, findPaginated.getData(), titles, primaryTitle);
			map.put("code", "200");
			map.put("msg", "导出成功");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
}
