package com.toughguy.transactionSystem.controller.content;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toughguy.transactionSystem.model.content.po.TransactionRichText;
import com.toughguy.transactionSystem.service.content.prototype.ITransactionRichTextSerive;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/richtextueditor")
@Slf4j
public class RichTextUeditorController {
	
	@Autowired
	private  ITransactionRichTextSerive service;
	
	@RequestMapping("/save")
	public Map<String, String> save(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int titleStatus = Integer.parseInt(request.getParameter("titleStatus"));
		try {
			service.saveInfo(new TransactionRichText(title, content, new Date(), new Date(), titleStatus));
			map.put("code", "200");
		}catch (Exception e) {
			map.put("code", "404");
			return map;
		}
		return map;
	}
	
	
}
