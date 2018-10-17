package com.unicom.sale.mapper;

import com.unicom.sale.model.Orderdetail;

public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}