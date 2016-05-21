package shopping.model;
/**
 * 
 * @see [订单项数据类型]
 * @class OrderItem.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:56:46
 * @description [封装项目中订单项数据类型]
 */
public class OrderItem {
	private int orderitemId;//订单项编号
	private Goods goods;//订单项中的商品
	private int buyCount;//订单项中商品购买的数目
	private double subTotal;//订单项中商品小计
	private double dealPrice;//成交价格
	
	
	public OrderItem(int orderitemId, Goods goods, int buyCount, double subTotal, double dealPrice) {
		super();
		this.orderitemId = orderitemId;
		this.goods = goods;
		this.buyCount = buyCount;
		this.subTotal = subTotal;
		this.dealPrice = dealPrice;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public int getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
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
