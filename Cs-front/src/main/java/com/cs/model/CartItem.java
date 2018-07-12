package com.cs.model;


/**
 * 购物项对象
 * 
 *
 */
public class CartItem {
	private Commodity commodity;	// 购物项中商品信息
	private int count;			// 购买某种商品数量
	@SuppressWarnings("unused")
	private double subtotal;	// 购买某种商品小计
	
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// 小计自动计算的.
	public double getSubtotal() {
		return count * commodity.getCommodityPrice();
	}
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	*/
	
}
