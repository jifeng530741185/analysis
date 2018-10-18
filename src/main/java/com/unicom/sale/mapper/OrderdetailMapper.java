package com.unicom.sale.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.unicom.sale.model.Orderdetail;
@Mapper
public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}