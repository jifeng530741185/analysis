package com.unicom.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.unicom.sale.model.Service_num;

@Mapper
public interface Service_numMapper {
    int deleteByPrimaryKey(Integer svcId);
    
    int insert(Service_num record);
    
    int insertSelective(Service_num record);
    
    Service_num selectByPrimaryKey(Integer svcId);

    int updateByPrimaryKeySelective(Service_num record);

    int updateByPrimaryKey(Service_num record);
    
    //更加省市的值输出号码列表
    @Select("select * from service_num where status=0 and province=#{province} and city=#{city} ORDER BY RAND() LIMIT 90")
    List<Service_num> showList(@Param("province") String province, @Param("city")  String city);
    
    @Update("update service_num set status=#{status} where svc_id=#{svcId}")
    int updateStatus(@Param("status") int status, @Param("svcId") int svc_id);
    
    @Select("select * from service_num where status=1 and svc_num=#{svcNum}")
    Service_num selectBySvcNum(@Param("svcNum") String svcNum);
    
}