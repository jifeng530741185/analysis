package com.unicom.sale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unicom.sale.model.Customer;
import com.unicom.sale.model.Orderdetail;
import com.unicom.sale.model.Service_num;
import com.unicom.sale.service.AppService;
import com.unicom.sale.vo.OrderBrief;
import com.unicom.sale.vo.OrderVo;
 

@RestController
@CrossOrigin
@RequestMapping("/app")
public class AppController {

	@Autowired
	private AppService appService;
	
	//随机返回一组号码
	@GetMapping("/numlist/{province}/{city}")
	public List<Service_num> getList(@PathVariable("province") String province,@PathVariable("city") String city){
		//System.out.println("controller"+province);
		return appService.showList(province,city);
	}
	//用户提交触发 用户表、订单表新增，号码表更新
	@PostMapping(value="/insert")
	public  Map<String, Object> insert(OrderVo orderVo){
			Map<String, Object> resultMap =new HashMap<String, Object>();
			try {
				int code =  appService.insertOrders(orderVo);
				//System.out.println(orderVo);
				if(code==1){
					resultMap.put("code", code);
					resultMap.put("msg", "增加成功！");
				}else{
					resultMap.put("code", code);
					resultMap.put("msg", "增加失败！");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return resultMap;
	}
	//用户查询订单状态
	@GetMapping("/getOrder/{value}")
	public OrderBrief getOrderBrief(@PathVariable("value") String value){
		return  appService.getOrderBrief(value);
	}
	 
	
}
