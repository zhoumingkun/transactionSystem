package com.toughguy.binheSportSystem.controller.content;

import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.toughguy.binheSportSystem.model.content.Bill;
import com.toughguy.binheSportSystem.model.content.BillRequest;
import com.toughguy.binheSportSystem.model.content.ConsumeBill;
import com.toughguy.binheSportSystem.service.content.prototype.IMemberBillService;
import com.toughguy.binheSportSystem.service.content.prototype.IReserveTimeService;

/**
 * 查询用户账单controller类
 * @author 
 *
 */
@RestController
@RequestMapping("/member")
public class MemberBillController {
	
	@Autowired
	private IMemberBillService memberBillservice;
	
	@Autowired
	private IReserveTimeService reserveTimeService;
	
	
	/**
	 * 传入参数卡号和手机号 查询用户全部账单
	 * @param bind
	 * @return
	 */
	@RequestMapping("/findAllbill")
	public List<Bill> findAll(@RequestParam(name = "cardnumber") String cardno, @RequestParam(name = "tel") String usermobile) {		//需要传递参数卡号 手机号 
		List<String> type = reserveTimeService.findAllType();		//查询全部的场馆名称
		List<String> Other = reserveTimeService.findAllOtherType();	//查询其他消费类型名称
		Map<String,Object> map = new HashMap<String, Object>();		
		map.put("cardno",cardno);
		map.put("mobile",usermobile);
		map.put("list", type);
		map.put("other", Other);
		List<Bill> list= new ArrayList<>();
		List<ConsumeBill> recharge = memberBillservice.findAllRecharge(map);		//查询充值记录
		for(ConsumeBill arr:recharge) {
			if(arr.getCardno().equals(cardno)) {					//判断卡号是否相等
				Bill b = new Bill();
				b.setType(1);						//充值
				b.setCardId(arr.getCardno());		//卡号
				b.setMoney(arr.getAddmoney());		//充值金额
				b.setTime(arr.getBilltime().substring(0, 10));		//充值时间  yyyy-MM-dd
				list.add(b);
			}else {
				return list;
			}
		}
		
		List<ConsumeBill> consume = memberBillservice.findAllconsume(map);
		for(ConsumeBill arr:consume) {
			if(arr.getCardno().equals(cardno)) {					//判断卡号是否相等
				Bill b = new Bill();
				b.setType(2);						//消费
				b.setCardId(arr.getCardno());		//卡号
				b.setMoney(arr.getPaid());			//消费金额
				b.setTime(arr.getBilltime().substring(0, 10));		//消费时间  yyyy-MM-dd
				b.setConsumetype(arr.getConsumetype());				//账单类型
				list.add(b);
			}else {
				return list;
			}
		}
		
		List<ConsumeBill> allOther = memberBillservice.findAllOtherBill(map);

		for(ConsumeBill arr:allOther) {
			if(arr.getCardno().equals(cardno)) {					//判断卡号是否相等
				Bill b = new Bill();
				b.setType(2);						//消费
				b.setCardId(arr.getCardno());		//卡号
				b.setMoney(arr.getPaid());			//消费金额
				b.setTime(arr.getBilltime().substring(0, 10));		//消费时间  yyyy-MM-dd
				b.setConsumetype(arr.getConsumetype());				//账单类型
				list.add(b);
			}else {
				return list;
			}
		}
		return list;
	}
	
	
	
	
	/**
	 * 通过手机号，卡号，时间区间  查询用户时间区间内的账单  
	 * @param bill
	 * @return
	 */
	@RequestMapping("/findbill")
	public List<Bill> findBill(BillRequest bill) {		//需要传递参数卡号 手机号  起始时间和结束时间
		List<String> type = reserveTimeService.findAllType();		//查询全部的场馆名称
		List<String> Other = reserveTimeService.findAllOtherType();	//查询其他消费类型名称
		Map<String,Object> map = new HashMap<String, Object>();		
		map.put("cardno",bill.getCardId());
		map.put("mobile",bill.getMobile());
		map.put("list", type);
		map.put("other", Other);
		String start  =bill.getStarttime()+" 00:00:01";		//在yyyy-MM-dd  后面加入时分秒  
		map.put("starttime",start);
		String end  =bill.getEndtime()+" 23:59:59";
		map.put("endtime",end);
		List<Bill> list= new ArrayList<>();
		List<ConsumeBill> recharge = memberBillservice.findRecharge(map);		//查询充值记录
		for(ConsumeBill arr:recharge) {
			if(arr.getCardno().equals(bill.getCardId())) {					//判断卡号是否相等
				Bill b = new Bill();
				b.setType(1);						//充值
				b.setCardId(arr.getCardno());		//卡号
				b.setMoney(arr.getAddmoney());		//充值金额
				b.setTime(arr.getBilltime().substring(0, 10));		//充值时间  yyyy-MM-dd
				list.add(b);
			}else {
				return list;
			}
		}
		
		List<ConsumeBill> consume = memberBillservice.findconsume(map);		//查询场馆的消费记录
		for(ConsumeBill arr:consume) {
			if(arr.getCardno().equals(bill.getCardId())) {					//判断卡号是否相等
				Bill b = new Bill();
				b.setType(2);						//消费
				b.setCardId(arr.getCardno());		//卡号
				b.setMoney(arr.getPaid());			//消费金额
				b.setTime(arr.getBilltime().substring(0, 10));		//消费时间  yyyy-MM-dd
				b.setConsumetype(arr.getConsumetype());				//消费类型
				list.add(b);
			}else {
				return list;
			}
		}
		
		List<ConsumeBill> otherBill = memberBillservice.findOtherBill(map);			//根据时间查询  该用户的商品和游泳账单
		for(ConsumeBill arr:otherBill) {
			if(arr.getCardno().equals(bill.getCardId())) {					//判断卡号是否相等
				Bill b = new Bill();
				b.setType(2);						//消费
				b.setCardId(arr.getCardno());		//卡号
				b.setMoney(arr.getPaid());			//充值金额
				b.setTime(arr.getBilltime());		//充值时间  yyyy-MM-dd
				b.setConsumetype(arr.getConsumetype());				//消费类型
				list.add(b);
			}else {
				return list;
			}
		}
		return list;
	}
}
