package com.unicom.sale.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;

import com.unicom.sale.mapper.CustomerMapper;
import com.unicom.sale.mapper.OrderBriefMapper;
import com.unicom.sale.mapper.OrderdetailMapper;
import com.unicom.sale.mapper.Service_numMapper;
import com.unicom.sale.model.Customer;
import com.unicom.sale.model.Orderdetail;
import com.unicom.sale.model.Service_num;
import com.unicom.sale.vo.OrderBrief;
import com.unicom.sale.vo.OrderVo;


@Service
public class AppService {
	
	@Autowired
	private Service_numMapper smap;
	@Autowired
	private CustomerMapper  cmap;
	@Autowired
	private OrderdetailMapper  omap;
	
	public List<Service_num> showList(String province,String city) {
		//System.out.println("Service"+province);
		return smap.showList(province, city);
	}
	
	@Transactional(rollbackFor={Exception.class})
	public int insertOrders(OrderVo orderVo){
		int code =0 ;
		try {
			//用户表插入
			Customer customer = new Customer();
			customer.setCertNum(orderVo.getCertNum());
			customer.setContactPhone(orderVo.getContactPhone());
			customer.setCustomerName(orderVo.getCustomerName());
			System.out.println(customer);
			//使用insertSelective插入值不为null的对象
			cmap.insertOne(customer);
			//获取返回的自增用户id 
			int customer_id=customer.getCustomerId();
			//号码状态修改
			smap.updateStatus(1,orderVo.getSvcId());
			//订单表插入
			orderVo.setCustomerId(customer_id);
			orderVo.setCreateTime(new Date());
			orderVo.setStatus(0);
			orderVo.setProductName("王卡套餐");
			System.out.println(orderVo);
			omap.insertSelective((Orderdetail)orderVo);
			code=1;
		} catch (Exception e) {
			code=0;
			System.out.println(e);
			//手工回滚事务
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return code;
	}
	@Autowired
	private OrderBriefMapper obmap;
	public OrderBrief getOrderBrief(String value){
		List<OrderBrief>  listorder= obmap.selectBrief(value);
		return listorder.get(0);
	}

}
