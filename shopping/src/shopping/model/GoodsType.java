package shopping.model;
/**
 * 
 * @see [商品类型的数据类型]
 * @class GoodsType.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午7:33:31
 * @description [封装项目中的商品类型的数据类型]
 */
public class GoodsType {
	private int goodsTypeId;//商品类型编号
	private String goodsType;//商品类型
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	
	
	public GoodsType(int goodsTypeId, String goodsType) {
		super();
		this.goodsTypeId = goodsTypeId;
		this.goodsType = goodsType;
	}


	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	
	
}
