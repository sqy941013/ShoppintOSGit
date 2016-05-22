package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.mapper.IRowMapper;
import shopping.model.Goods;;

/**
 * 
 * @see [商品类型的数据库和对象映射关系的实现类]
 * @class GoodsMapper.java
 * @package shopping.mapper.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:35:49
 * @description [主要将商品类型的数据记录还原成商品对象]
 */
public class GoodsMapper implements IRowMapper<Goods>{
	
	@Override
	public Goods mapper(Connection conn,ResultSet rs) throws SQLException{
		Goods goods=new Goods();
		goods.setGoodId(rs.getInt("GOODSID"));
		goods.setGoodName(rs.getString("GOODSNAME"));
		goods.setSubPrice(rs.getDouble("SUBPRICE"));
		goods.setStockCount(rs.getInt("STOCKCOUNT"));
		goods.setIsValible(rs.getBoolean("ISVALIBLE"));
		goods.setGoodDesc(rs.getString("GOODSDESC"));
		goods.setGoodsTypeId(rs.getInt("GOODSTYPEID"));
		return goods;
	}

}
