package com.unicom.sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/web/")
public class WebController {
	@Autowired
	private WebController webController;
	
	//返回代办列表  creatime时间，省，邮寄地址,号段
	
	//更新代办信息，涉及:号码状态变更、订单信息更改、用户信息更改
	
	//返回已办列表 订单状态 createtime时间 省
	
	
	

}
