package com.unicom.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.unicom.sale.vo.OrderBrief;

public interface OrderBriefMapper {
	
	@Select(" SELECT o.order_id ,c.customer_name, s.svc_num,o.create_time ,o.status  "
	+" FROM orderdetail o , customer c , service_num s WHERE o.svc_id = s.svc_id  AND o.customer_id=c.customer_id AND "
	+"( c.contact_phone=#{value}  OR  s.svc_num =#{value}  OR o.order_id =#{value})ORDER BY order_id DESC LIMIT 1 ")
	public List<OrderBrief> selectBrief(@Param("value") String value);
}
