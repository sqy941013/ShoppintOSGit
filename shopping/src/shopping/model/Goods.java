package shopping.model;
/**
 * 
 * @see [商品数据类型]
 * @class Goods.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:04:08
 * @description [封装项目中的商品数据]
 */
public class Goods {
	private int goodId;//商品编号
	private String goodName;//商品名称
	private double subPrice;//商品单价
	private int stockCount;//商品库存
	private boolean isValible;//是否可以购买
	private String goodDesc;//商品描述
	
	public Goods(int goodId, String goodName, double subPrice, int stockCount, boolean isValible, String goodDesc) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.subPrice = subPrice;
		this.stockCount = stockCount;
		this.isValible = isValible;
		this.goodDesc = goodDesc;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public double getSubPrice() {
		return subPrice;
	}
	public void setSubPrice(double subPrice) {
		this.subPrice = subPrice;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public boolean getIsValible() {
		return isValible;
	}
	public void setIsValible(boolean isValible) {
		this.isValible = isValible;
	}
	public String getGoodDesc() {
		return goodDesc;
	}
	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
	
	
}
