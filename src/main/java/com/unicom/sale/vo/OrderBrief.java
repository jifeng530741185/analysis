package com.unicom.sale.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderBrief {
	private int orderId;
	private String customerName;
	private String svcNum;
	private Date createTime; 
	private String status;
	public int getOrderId() {
		return orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getSvcNum() {
		return svcNum;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	public Date getCreateTime() {
		return createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setSvcNum(String svcNum) {
		this.svcNum = svcNum;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderQuery [orderId=" + orderId + ", customerName="
				+ customerName + ", svcNum=" + svcNum + ", createTime="
				+ createTime + ", status=" + status + "]";
	}
	
}
