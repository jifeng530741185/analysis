package com.unicom.sale.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.unicom.sale.model.Customer;
@Mapper
public interface CustomerMapper {
    
	int deleteByPrimaryKey(Integer customerId);
    
    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    //useGeneratedKeys="true"  keyProperty="customer_id" keyColumn="customer_id"
    @Insert("insert into customer (customer_name, cert_num,contact_phone) values (#{customerName}, #{certNum},#{contactPhone})")
    @Options(useGeneratedKeys=true, keyProperty="customerId", keyColumn="customer_id")
    int insertOne(Customer record);
    
    @Select("select * from customer where contact_phone=#{contactPhone}")
    Customer selectByContactPhone(@Param("contactPhone") String contactPhone);
}