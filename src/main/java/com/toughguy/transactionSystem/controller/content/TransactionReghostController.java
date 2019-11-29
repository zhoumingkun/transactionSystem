package com.toughguy.transactionSystem.controller.content;

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
import com.toughguy.transactionSystem.model.content.po.TransactionReghost;
import com.toughguy.transactionSystem.model.content.po.TransactionService;
import com.toughguy.transactionSystem.model.content.vo.ReghostServiceMemberEnterpriseInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IReghostServiceMemberEnterpriseInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionReghostService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionServiceService;
import com.toughguy.transactionSystem.util.DownFileUtil;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 登记托管的controller
 * 
 * @author liDongSheng
 *
 */
@RestController
@RequestMapping("/reghost")
@Slf4j
@Api(tags = "ReghostController")
public class TransactionReghostController {

	@Autowired
	private ITransactionReghostService transactionReghostService;

	@Autowired
	private IReghostServiceMemberEnterpriseInfoService reghostServiceMemberEnterpriseInfo;
	
	@Autowired
	private ITransactionServiceService transactionServiceService; 
	
	//下载模板表
	@ApiOperation(value = "下载模板表", notes = "选择哪个模板下载,目录是根目录的down/文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "filename", value = "文件名字 路径是（文件名.后缀）", required = false, dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/downFile", method = RequestMethod.GET)
	public String downFile(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String filename = request.getParameter("filename");
		try {
			DownFileUtil.download(response,filename,"UTF-8");
			map.put("code", "200");
			map.put("msg", "下载成功");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "500");
			map.put("msg", "下载出错");
		}
		return JsonUtil.objectToJson(map);
	}
	
	//查看所有的服务类型
	@ApiOperation(value = "查看所有的服务类型")
	@RequestMapping(value = "/service/lookAll", method = RequestMethod.GET)
	public String serviceLookAll(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<TransactionService> findAll = transactionServiceService.findAll();
		params.put("code", "200");
		params.put("msg", "查找成功");
		params.put("data", findAll);
		return JsonUtil.objectToJson(params);
	}
	
	//查看是否申请登记
	@ApiOperation(value = "查看是否申请登记")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "memberId", value = "会员id", required = true, dataType = "int", paramType = "query")
	})
	@RequestMapping(value = "/judgeReghost", method = RequestMethod.GET)
	public String judgeReghost(HttpServletRequest request,HttpServletResponse response) {
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionReghost find = transactionReghostService.find(memberId);
		if(find!=null) {
			map.put("code", "500");
			map.put("msg", "已经登记");
		}else {
			map.put("code", "200");
			map.put("msg", "未进行登记");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 申请登记
	@ApiOperation(value = "申请登记", notes = "填写登记的内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "memberId", value = "会员id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "serviceId", value = "服务的类型", required = true, dataType = "int", paramType = "query"),
			/*@ApiImplicitParam(name = "reghostName", value = "企业名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "enterpriseTypeId", value = "企业类型", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "reghostPerson", value = "姓名", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "reghostTel", value = "手机号", required = true, dataType = "string", paramType = "query"),*/ 
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addReghost(HttpServletRequest request,HttpServletResponse response) {
		JSONObject json = requestJSONUtil.request(request, response);
		TransactionReghost transactionReghost = new TransactionReghost();
		transactionReghost.setServiceId(json.getInteger("serviceId"));
		transactionReghost.setMemberId(json.getInteger("memberId"));
//		transactionReghost.setReghostName(json.getString("reghostName"));
//		transactionReghost.setEnterpriseTypeId(json.getInteger("enterpriseTypeId"));
//		transactionReghost.setReghostPerson(json.getString("reghostPerson"));
//		transactionReghost.setReghostTel(json.getString("reghostTel"));
		Map<String, Object> map = new HashMap<String, Object>();
		TransactionReghost find = transactionReghostService.find(transactionReghost.getMemberId());
		if(find!=null) {
			map.put("code", "500");
			map.put("msg", "已经登记");
		}else {
			try {
				transactionReghostService.save(transactionReghost);
				map.put("code", "200");
				map.put("msg", "登记成功");
			} catch (Exception e) {
				// TODO: handle exception
				map.put("code", "500");
				map.put("msg", "服务器错误");
			}
		}
		return JsonUtil.objectToJson(map);
	}

	// 查看所有登记托管的企业
	@ApiOperation(value = "查看所有登记托管的企业", notes = "默认查全部，可以传参page和rows进行分页查找，reghostName进行关键字模糊查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页数", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "rows", value = "页大小", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "enterpriseName", value = "企业名称", required = false, dataType = "String", paramType = "query"), })
	@RequestMapping(value = "/look", method = RequestMethod.GET)
	public String look(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params1 = new HashMap<String, Object>();
		String enterpriseName = request.getParameter("enterpriseName");
		params1.put("enterpriseName", enterpriseName);
		PagerModel<ReghostServiceMemberEnterpriseInfo> findPaginated = reghostServiceMemberEnterpriseInfo.findPaginated(params1);
		List<ReghostServiceMemberEnterpriseInfo> data = findPaginated.getData();
		int total = findPaginated.getTotal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "200");
		params.put("msg", "查找成功");
		params.put("data", data);
		params.put("total", total);
		return JsonUtil.objectToJson(params);
	}

	// 查看某一个托管内容
	@ApiOperation(value = "查看某一个托管内容", notes = "通过托管id来查找")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reghostId", value = "托管编号", required = true, dataType = "int", paramType = "query")})
	@RequestMapping(value = "/lookOneReghost", method = RequestMethod.GET)
	public String lookOneReghost(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int reghostId = Integer.parseInt(request.getParameter("reghostId"));
			ReghostServiceMemberEnterpriseInfo find = reghostServiceMemberEnterpriseInfo.find(reghostId);
			map.put("code", "200");
			map.put("msg", "查找成功");
			map.put("data", find);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}
	
	// 删除登记托管
	@ApiOperation(value = "删除托管", notes = "通过托管id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reghostId", value = "托管编号", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delReghost(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int reghostId = Integer.parseInt(request.getParameter("reghostId"));
			transactionReghostService.delete(reghostId);
			map.put("code", "200");
			map.put("msg", "删除成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器错误");
		}
		return JsonUtil.objectToJson(map);
	}

}
