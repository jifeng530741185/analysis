package com.unicom.sale.mapper;

import com.unicom.sale.model.Service_num;

public interface Service_numMapper {
    int deleteByPrimaryKey(Integer svcId);

    int insert(Service_num record);

    int insertSelective(Service_num record);

    Service_num selectByPrimaryKey(Integer svcId);

    int updateByPrimaryKeySelective(Service_num record);

    int updateByPrimaryKey(Service_num record);
}