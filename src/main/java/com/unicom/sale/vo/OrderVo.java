package com.unicom.sale.vo;

import com.unicom.sale.model.Orderdetail;

public class OrderVo extends Orderdetail{
	//订单 包含对象 号码、用户信息
	
	private String customerName;

    private String certNum;

    private String contactPhone;
    
    private String svcNum;
    
    private String nprovince;

    private String ncity;

    private Integer nstatus;

	public String getCustomerName() {
		return customerName;
	}

	public String getCertNum() {
		return certNum;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getSvcNum() {
		return svcNum;
	}

	public String getNprovince() {
		return nprovince;
	}

	public String getNcity() {
		return ncity;
	}

	public Integer getNstatus() {
		return nstatus;
	}

	public void setSvcNum(String svcNum) {
		this.svcNum = svcNum;
	}

	public void setNprovince(String nprovince) {
		this.nprovince = nprovince;
	}

	public void setNcity(String ncity) {
		this.ncity = ncity;
	}

	public void setNstatus(Integer nstatus) {
		this.nstatus = nstatus;
	}

	@Override
	public String toString() {
		return "OrderVo [customerName=" + customerName + ", certNum=" + certNum
				+ ", contactPhone=" + contactPhone + ", svcNum=" + svcNum
				+ ", nprovince=" + nprovince + ", ncity=" + ncity
				+ ", nstatus=" + nstatus + "]";
	}
	
}
