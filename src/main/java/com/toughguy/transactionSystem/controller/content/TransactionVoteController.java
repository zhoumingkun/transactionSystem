package com.toughguy.transactionSystem.controller.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.po.TransactionVoteContent;
import com.toughguy.transactionSystem.model.content.po.TransactionVoteOption;
import com.toughguy.transactionSystem.service.content.prototype.IVoteContentService;
import com.toughguy.transactionSystem.service.content.prototype.IVoteOptionService;

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
	private IVoteOptionService optionService;
	
	/**
	 * 查投票内容的所有信息【分页实现】
	 * @return
	 */
	@ApiOperation(value = "所有投票内容的信息",notes = "查投票内容的所有信息")
	@RequestMapping(value = "/voteContenMsg", method = RequestMethod.GET)
	public Map<String,Object> voteContenMsg() {
		Map<String,Object> map = new HashMap<>();
		try {
			List<TransactionVoteContent> all = contentService.findAll();
			map.put("code", "200");
			map.put("data", all);
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
	/**
	 * 根据投票内容的ID 查看对应的选项信息
	 * @return
	 */
	
	@ApiOperation(value = "选项信息",notes = "查投票选项信息")
    @ApiImplicitParam(name = "voteContentId", value = "投票内容ID",
    required = true, dataType = "int", paramType = "query")
	@RequestMapping(value = "/voteOptionMsg", method = RequestMethod.POST)
	public Map<String,Object> voteOptionMsg(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int voteContentId = Integer.parseInt(request.getParameter("voteContentId"));
			List<TransactionVoteOption> all = optionService.findVoteId(new TransactionVoteContent(voteContentId));
			map.put("code", "200");
			map.put("data", all);
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
    		@ApiImplicitParam(name = "voteContent", value = "投票内容",
            required = true, dataType = "String", paramType = "query"),
    		@ApiImplicitParam(name = "voteOption", value = "选项信息",
            required = true, dataType = "String", paramType = "query")
    		})
            
	@RequestMapping(value = "/voteOptionAdd", method = RequestMethod.POST)
	public Map<String,Object> voteOptionAdd(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			String voteContent = request.getParameter("voteContent");
			//插入投票内容返回id
			TransactionVoteContent content = contentService.insertVoteContent(
					new TransactionVoteContent(voteContent));
			//循环插入选项
			String voteOption = request.getParameter("voteOption");
			optionService.save(new TransactionVoteOption(content.getVoteContentId(), voteOption));
			
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	/**
	 * 投票接口 更新投票信息
	 */
	@ApiOperation(value = "投票接口",notes = "更新投票信息")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "voteOptionId", value = "选项ID",
            required = true, dataType = "int", paramType = "query"),
    		@ApiImplicitParam(name = "voteCount", value = "投票次数",
            required = true, dataType = "int", paramType = "query")
    		})
            
	@RequestMapping(value = "/voteOptionUpdate", method = RequestMethod.POST)
	public Map<String,Object> voteOptionUpdate(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<>();
		try {
			int voteOptionId = Integer.parseInt(request.getParameter("voteOptionId"));
			int voteCount = Integer.parseInt(request.getParameter("voteCount"));
			
			optionService.updateVoteOptionCount(new TransactionVoteOption(voteOptionId, voteCount));
			map.put("code", "200");
		}catch(Exception e) {
			map.put("code", "404");
		}
		return map;
	}
	
}
