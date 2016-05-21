package shopping.model;
/**
 * 
 * @see [购物车数据类型]
 * @class Shopcart.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:57:22
 * @description [封装项目中购物车数据类型]
 */
public class Shopcart {
	private int shopcartId;//购物车编号
	private Goods goods;//商品
	private int buyCount;//购买的数量
	private double subTotal;//购买的小计
	
	
	public Shopcart(int shopcartId, Goods goods, int buyCount, double subTotal) {
		super();
		this.shopcartId = shopcartId;
		this.goods = goods;
		this.buyCount = buyCount;
		this.subTotal = subTotal;
	}
	public Shopcart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getShopcartId() {
		return shopcartId;
	}
	public void setShopcartId(int shopcartId) {
		this.shopcartId = shopcartId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
