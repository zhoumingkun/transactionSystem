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
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.po.TransactionVoteCount;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionLogService;
import com.toughguy.transactionSystem.service.content.prototype.IVoteContentService;
import com.toughguy.transactionSystem.service.content.prototype.IVoteCountService;
import com.toughguy.transactionSystem.util.DateUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 投票模块
 * @author 张泽
 *
 */
@RestController
@RequestMapping("/vote")
@Slf4j
public class TransactionVoteController {

	@Autowired
	private IVoteContentService contentService;

	@Autowired
	private IVoteCountService countService;
	
	@Autowired
	private ITransactionLogService logService;
	
	/**
	 * 查投票内容的所有信息【分页实现】:已结束
	 * @return
	 */
	@ApiOperation(value = "所有投票内容的信息:已结束",notes = "查投票内容的所有信息")
	@RequestMapping(value = "/votecontenendmsg", method = RequestMethod.GET)
	public Map<String,Object> voteContenEndMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			PagerModel<TransactionVoteContent> all = contentService.findEndInfo(null);
			List<TransactionVoteContent> data = all.getData();
			map.put("code", "200");
			map.put("msg", "成功");
			map.put("data", data);
			map.put("total", all.getTotal());
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	/**
	 * 查投票内容的所有信息【分页实现】:未结束
	 * @return
	 */
	@ApiOperation(value = "所有投票内容的信息:未结束",notes = "查投票内容的所有信息")
	@RequestMapping(value = "/votecontenmsg", method = RequestMethod.GET)
	public Map<String,Object> voteContenNoMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			PagerModel<TransactionVoteContent> all = contentService.findInfo(null);
			//List<TransactionVoteContent> data = all.getData();
			map.put("code", "200");
			map.put("msg", "成功");
			map.put("data", all.getData());
			map.put("total", all.getTotal());
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 根据投票内容的ID 查看对应的信息
	 * @return
	 */
	
	@ApiOperation(value = "所有投票信息",notes = "查信息")
    @ApiImplicitParam(name = "voteContentId", value = "投票内容ID",
    required = true, dataType = "int", paramType = "query")
	@RequestMapping(value = "/voteoptionmsg", method = RequestMethod.POST)
	public Map<String,Object> voteOptionMsg(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int voteContentId = json.getInteger("voteContentId");
			TransactionVoteContent voteContent = contentService.find(voteContentId);
			map.put("code", "200");
			map.put("data", voteContent);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 添加投票内容及选项信息
	 * 
	 */
	@ApiOperation(value = "添加投票内容及选项信息",notes = "添加投票内容及选项信息")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "rootId", value = "管理员id",
    	    required = true, dataType = "int", paramType = "query"),
    		@ApiImplicitParam(name = "voteContent", value = "投票内容",
            required = true, dataType = "String", paramType = "query"),
    		@ApiImplicitParam(name = "voteOptionOne", value = "选项一",
            required = true, dataType = "String", paramType = "query"),
    		@ApiImplicitParam(name = "voteOptionTwo", value = "选项二",
            required = true, dataType = "String", paramType = "query"),
    		@ApiImplicitParam(name = "startTime", value = "开始时间",
            required = true, dataType = "Date", paramType = "query"),
    		@ApiImplicitParam(name = "endTime", value = "结束时间",
            required = true, dataType = "Date", paramType = "query")
    })
            
	@RequestMapping(value = "/voteoptionadd", method = RequestMethod.POST)
	public Map<String,Object> voteOptionAdd(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			String voteContent = json.getString("voteContent");
			String voteOptionOne = json.getString("voteOptionOne");
			String voteOptionTwo = json.getString("voteOptionTwo");
			Date startTime = json.getDate("startTime"); 
			Date endTime = json.getDate("endTime");
			//插入投票内容
			contentService.save(
					new TransactionVoteContent(voteContent,voteOptionOne,voteOptionTwo,startTime,endTime));

			map.put("msg", "添加成功");
			map.put("code", "200");
			
			int rootId =  json.getInteger("rootId");
			logService.insert("添加投票内容: "
					+ voteContent
					, rootId);
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	/**
	 * 投票接口 更新投票统计
	 */
	@ApiOperation(value = "投票接口",notes = "更新投票信息")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "memberId", value = "会员ID",
            required = true, dataType = "int", paramType = "query"),
    		@ApiImplicitParam(name = "voteContentId", value = "投票内容ID",
            required = true, dataType = "int", paramType = "query"),
    		@ApiImplicitParam(name = "optionValue", value = "选项的值",
            required = true, dataType = "int", paramType = "query")
    		})
            
	@RequestMapping(value = "/voteoptionupdate", method = RequestMethod.POST)
	public Map<String,Object> voteOptionUpdate(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int memberId = json.getInteger("memberId");
			int voteContentId = json.getInteger("voteContentId");
			
			
			int optionValue = json.getInteger("optionValue");
			if(optionValue == 1) {
				//sql语句+1
				contentService.updateVoteOptionOne(new TransactionVoteContent(voteContentId));
			}else {
				contentService.updateVoteOptionTwo(new TransactionVoteContent(voteContentId));
			}
			countService.save(new TransactionVoteCount(memberId, voteContentId));
			
			map.put("code", "200");
			map.put("msg", "成功");
			
			
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 投票检查
	 */
	@ApiOperation(value = "投票检查接口",notes = "投票检查接口")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "memberId", value = "会员ID",
        required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "voteContentId", value = "投票内容ID",
        required = true, dataType = "int", paramType = "query")
	})
            
	@RequestMapping(value = "/votecheck", method = RequestMethod.POST)
	public Map<String,Object> voteCheck(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		JSONObject json = requestJSONUtil.request(request, response);
		try {
			int memberId = json.getInteger("memberId");
			int voteContentId = json.getInteger("voteContentId");
			
			boolean check = countService.check(new TransactionVoteCount(memberId, voteContentId));
			if(check) {
				map.put("code", "200");
				map.put("msg", "可以投票");
			}else{
				map.put("code", "404");
				map.put("msg", "已经投过票了");
			}
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	/**
	 * 删除投票
	 */
	@ApiOperation(value = "删除投票",notes = "删除投票")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "rootId", value = "管理员id",
        required = true, dataType = "int", paramType = "query"),	
    	@ApiImplicitParam(name = "voteContentId", value = "投票内容ID",
	    required = true, dataType = "int", paramType = "query")
    })
	@RequestMapping(value = "/votedel", method = RequestMethod.GET)
	public Map<String,Object> voteDelete(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int voteContentId = Integer.parseInt(request.getParameter("voteContentId"));
			
			int rootId =  Integer.parseInt
					(request.getParameter("rootId"));
			logService.insert("删除投票内容: "
					+ contentService.find(voteContentId).getVoteContent()
					, rootId);
			
			contentService.delete(voteContentId);
			
			map.put("code", "200");
			map.put("msg", "成功");
			
		}catch(Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
		}
		return map;
	}
	
	
	/**
	 * 会员的 投票查看
	 */
//	@ApiOperation(value = "会员的 投票查看",notes = "会员的 投票查看")
//    @ApiImplicitParams({
//    	@ApiImplicitParam(name = "memberId", value = "会员ID",
//        required = true, dataType = "int", paramType = "query"),
//		@ApiImplicitParam(name = "voteContentId", value = "投票内容ID",
//        required = true, dataType = "int", paramType = "query")
//	})
//            
//	@RequestMapping(value = "/votecmemberview", method = RequestMethod.POST)
//	public Map<String,Object> voteMemberView(HttpServletRequest request, HttpServletResponse response) {
//		Map<String,Object> map = new HashMap<>();
//		JSONObject json = requestJSONUtil.request(request, response);
//		try {
//			int memberId = json.getInteger("memberId");
//			int voteContentId = json.getInteger("voteContentId");
//			
//			boolean check = countService.memberView(new TransactionVoteCount(memberId, voteContentId));
//			if(check) {
//				map.put("code", "200");
//				map.put("msg", "可以投票");
//			}else{
//				map.put("code", "404");
//				map.put("msg", "已经投过票了");
//			}
//			
//		}catch(Exception e) {
//			map.put("code", "500");
//			map.put("msg", "服务器异常");
//		}
//		return map;
//	}
//	
	
	
}
