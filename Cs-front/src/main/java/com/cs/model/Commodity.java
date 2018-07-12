package com.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品实体类
 * 
 * @author fan 创建时间：2018年7月9日
 */
@Entity
@Table(name = "cs_commodity")
public class Commodity {

	@Id
	@Column(name = "commodity_id")
	private Integer commodityId;
	@Column(name = "commodity_name")
	private String commodityName;
	@Column(name = "commodity_price")
	private Double commodityPrice;
	@Column(name = "commodity_description")
	private String commodityDescription;
	@Column(name = "commodity_state")
	private Integer commodityState;
	@Column(name = "commodity_image")
	private String commodityImage;
	@Column(name = "class2_id")
	private int class2Id;

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityDescription() {
		return commodityDescription;
	}

	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
	}

	public Integer getCommodityState() {
		return commodityState;
	}

	public void setCommodityState(Integer commodityState) {
		this.commodityState = commodityState;
	}

	public String getCommodityImage() {
		return commodityImage;
	}

	public void setCommodityImage(String commodityImage) {
		this.commodityImage = commodityImage;
	}

	public Integer getClass2Id() {
		return class2Id;
	}

	public void setClass2Id(Integer class2Id) {
		this.class2Id = class2Id;
	}

	@Override
	public String toString() {
		return "Commodity [commodityId=" + commodityId + ", commodityName=" + commodityName + ", commodityPrice="
				+ commodityPrice + ", commodityDescription=" + commodityDescription + ", commodityState="
				+ commodityState + ", commodityImage=" + commodityImage + ", class2Id=" + class2Id + "]";
	}

}
