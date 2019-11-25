package com.toughguy.transactionSystem.controller.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.toughguy.transactionSystem.model.content.QuestOption;
import com.toughguy.transactionSystem.model.content.po.TransactionOption;
import com.toughguy.transactionSystem.model.content.po.TransactionQuest;
import com.toughguy.transactionSystem.model.content.vo.QuestOptionInfo;
import com.toughguy.transactionSystem.pagination.PagerModel;
import com.toughguy.transactionSystem.service.content.prototype.IQuestOptionInfoService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionOptionService;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionQuestService;
import com.toughguy.transactionSystem.util.JsonUtil;
import com.toughguy.transactionSystem.util.requestJSONUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 		问卷调查controller
 * @author Guozhenze
 *
 */
@RestController
@RequestMapping("/quest")
@Slf4j
@Api(value="问卷调查")
public class QuestOptionController {

	@Autowired
	private ITransactionQuestService questService;

	@Autowired
	private ITransactionOptionService optionService;

	@Autowired
	private IQuestOptionInfoService infoService;

	/**
	 * 查询某个问卷的所有的问题以及选项
	 * 
	 * @return
	 */
	@ApiOperation(value = "问卷调查",notes = "查询某个问卷的所有的问题以及选项")
    @ApiImplicitParam(name = "copiesId", value = "问卷ID",
            required = true, dataType = "int", paramType = "query")
	@RequestMapping(value = "/getQuest", method = RequestMethod.GET)
	public String getQuestOption(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			int copiesId = 0;
			try {
				copiesId = Integer.parseInt(request.getParameter("copiesId"));
			} catch (Exception e) {
				map.put("code", "404");
				map.put("msg", "请传入copiesId");
				return JSON.toJSONString(map).toString();
			}
			QuestOptionInfo t = new QuestOptionInfo();
			t.setCopiesId(copiesId);
			List<QuestOptionInfo> infos = infoService.findOne(t);
			if(infos.size()==0||infos==null) {
				map.put("code", "404");
				map.put("msg", "没有找到该问卷");
				return JSON.toJSONString(map).toString();
			}
			map.put("copiesId", infos.get(0).getCopiesId());
			map.put("copiesTitle", infos.get(0).getCopiesTitle());
			map.put("startTime", infos.get(0).getCopiesStartTime());
			map.put("endTime", infos.get(0).getCopiesEndTime());
			List<Map<String, Object>> lis = new ArrayList<>();
			for (int i = 0; i < infos.size(); i++) {
				Map<String, Object> map2 = new HashMap<>();
				map2.put("questContent", infos.get(i).getQuestContent());
				map2.put("questId", infos.get(i).getQuestId());
				map2.put("questContent", infos.get(i).getQuestContent());
				map2.put("questStatus", infos.get(i).getQuestStatus());
				lis.add(map2);
				TransactionOption option = new TransactionOption();
				option.setQuestId(infos.get(i).getQuestId());
				List<TransactionOption> ops = optionService.findOption(option);
				List<Map<String,Object>> lists  = new ArrayList<>();
				int num = 0;
				for (int j = 0; j < ops.size(); j++) {
					Map<String,Object> map3 = new HashMap<>();
					map3.put("optionId", ops.get(j).getOptionId());
					map3.put("optionContent", ops.get(j).getOptionContent());
					map3.put("optionCount", ops.get(j).getOptionCount());
					
					num += ops.get(j).getOptionCount();
					lists.add(map3);
				}
			map2.put("count", num);
			map2.put("data", lists);
			}
			map.put("datas", lis);
			map.put("code", 200);
			map.put("total", infos.size());
			return JsonUtil.objectToJson(map);
		} catch (NumberFormatException e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
			return JsonUtil.objectToJson(map);
		}
	}

	/**
	 * 投票统计
	 * 
	 * @param request
	 */
	@ApiOperation(value = "投票统计",notes = "查询某个问卷的所有的问题以及选项")
	@ApiImplicitParam(name = "json", value = "多个问题id和选项id",
            required = true, dataType = "json", paramType = "query")
	@RequestMapping(value = "/updateCount", method = RequestMethod.GET)
	public String update(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			JSONObject json =  requestJSONUtil.request(request, response);
			JSONArray array = json.getJSONArray("data");
			for (int i = 0; i < array.size(); i++) {
				TransactionOption option = 	(TransactionOption)array.get(i);
			}
			TransactionOption option = new TransactionOption();
			/*option.setOptionId(optionId);
			option.setQuestId(questId);*/
			optionService.updateCount(option);
		} catch (NumberFormatException e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
			return JsonUtil.objectToJson(map);
		}
		map.put("code", 200);
		return JsonUtil.objectToJson(map);
	}

	/**
	 * 
	 * 新建调差问卷
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			QuestOptionInfo info = new QuestOptionInfo();
			info.setCopiesTitle("关于****，你知道多少");
			info.setQuestContent("关于股票，你了解的多么");
			infoService.insertInfo(info);

			TransactionOption option = new TransactionOption();
			option.setQuestId(info.getQuestId());
			option.setOptionContent("多，不多");
			optionService.insertOption(option);
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "服务器异常");
			return JsonUtil.objectToJson(map);
		}
		map.put("code", 200);
		return JsonUtil.objectToJson(map);
	}

/*	@RequestMapping("/test")
	public String getTest(HttpServletRequest request, HttpServletResponse response) {
		JSONObject josn = requestJSONUtil.request(request, response);
		return JSON.toJSONString(josn);
	}*/

	/**
	 * 获取全部的未结束的问卷调差
	 * 
	 * @return
	 */
	@ApiOperation(value = "获取全部的未结束的问卷调差",notes = "获取全部的未结束的问卷调差")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "copiesTitle", value = "问卷调查名字",
	            required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "page", value = "页码",
            required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "行数",
        required = false, dataType = "int", paramType = "query")
	}) 
	@RequestMapping(value = "/noEnd", method = RequestMethod.GET)
	public String getEnd(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> maps = new HashMap<>();

		try {
			maps.put("copiesTitle", request.getParameter("copiesTitle"));
			// -获取全部的调差问卷
			PagerModel<QuestOptionInfo> infos = infoService.selectNoEnd(maps);
			List<QuestOption> qos = new ArrayList<>();
			for (int i = 0; i < infos.getData().size(); i++) {

				QuestOption qo = new QuestOption();
				qo.setCopiesEndTime(infos.getData().get(i).getCopiesEndTime());
				qo.setCopiesStartTime(infos.getData().get(i).getCopiesStartTime());
				qo.setCopiesId(infos.getData().get(i).getCopiesId());
				qo.setCopiesTitle(infos.getData().get(i).getCopiesTitle());

				TransactionQuest quest = new TransactionQuest();
				quest.setQuestId(infos.getData().get(i).getQuestId());
				quest.setCopiesId(infos.getData().get(i).getCopiesId());
				// -获取每个调查问卷的所有的问题
				List<TransactionQuest> lists = questService.findInfoAll(quest);
				int num = 0;
				for (int j = 0; j < lists.size(); j++) {
					System.out.println(lists.get(j));
					lists.get(j).getQuestId();
					TransactionOption option = new TransactionOption();
					option.setQuestId(lists.get(j).getQuestId());
					// -获取每个问题的所有的选项
					List<TransactionOption> ops = optionService.findOption(option);
					for (int k = 0; k < ops.size(); k++) {
						num += ops.get(k).getOptionCount();
					}
				}
				qo.setOptionCount(num);
				qos.add(qo);
			}
			map.put("date", qos);
			map.put("total",qos.size());
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg", "服务器异常");
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();

	}

	/**
     * 	获取全部的已结束的问卷调差
     * @return
     */
	@ApiOperation(value = "获取全部的已结束的问卷调差",notes = "获取全部的已结束的问卷调差")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "copiesTitle", value = "问卷调查名字",
	            required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "page", value = "页码",
            required = false, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "rows", value = "行数",
        required = false, dataType = "int", paramType = "query")
	}) 
    @RequestMapping(value ="/end",method=RequestMethod.GET)
    public String getNoEnd(HttpServletRequest request) {
    	
    	Map<String,Object> map = new HashMap<>();
    	
    	Map<String, Object> maps = new HashMap<>();
    	try {   
	    	maps.put("copiesTitle", request.getParameter("copiesTitle"));
	    	// -获取全部的调差问卷
	    	PagerModel<QuestOptionInfo> infos =infoService.findPaginated(maps);
	    	List<QuestOption> qos = new ArrayList<>();
	    	for (int i = 0; i < infos.getData().size(); i++) {
	    		
	    		QuestOption qo = new QuestOption();
	    		qo.setCopiesEndTime(infos.getData().get(i).getCopiesEndTime());
	    		qo.setCopiesStartTime(infos.getData().get(i).getCopiesStartTime());
	    		qo.setCopiesId(infos.getData().get(i).getCopiesId());
	    		qo.setCopiesTitle(infos.getData().get(i).getCopiesTitle());
	    		
				TransactionQuest quest =  new TransactionQuest();
				quest.setQuestId(infos.getData().get(i).getQuestId());
				quest.setCopiesId(infos.getData().get(i).getCopiesId());
				 // -获取每个调查问卷的所有的问题
				
				List<TransactionQuest>  lists= questService.findInfoAll(quest);
				qo.setQuestCount(lists.size());
				int num = 0;
				for (int j = 0; j < lists.size(); j++) {
					System.out.println(lists.get(j));
					lists.get(j).getQuestId();
					TransactionOption option = new TransactionOption();
					option.setQuestId(lists.get(j).getQuestId());
					// -获取每个问题的所有的选项
					List<TransactionOption> ops = optionService.findOption(option);
					for (int k = 0; k < ops.size(); k++) {
						num += ops.get(k).getOptionCount();
					}
				}
				qo.setOptionCount(num);
				qos.add( qo);			
			}  
	    	map.put("data", qos);
	    	map.put("total",qos.size());
			map.put("code", "200");
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg", "服务器异常");
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();	
    }
	
}
