package shopping.model;

import java.util.Date;
import java.util.List;
/**
 * 
 * @see [订单数据类型]
 * @class Order.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:56:19
 * @description [封装项目中订单数据类型]
 */
public class Order {
	private int orderId;//订单编号
	private List<OrderItem> orderItemList;//订单项 一个或多个多个订单项
	private Date orderTime;//下单时间
	private double totalPrice;//总计价格
	
	public Order(int orderId, List<OrderItem> orderItemList, Date orderTime, double totalPrice) {
		super();
		this.orderId = orderId;
		this.orderItemList = orderItemList;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public Date getOrderTime() {
		return this.orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
