package shopping.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.mapper.IRowMapper;
import shopping.model.GoodsType;

/**
 * 
 * @see [商品类型的数据库和对象映射关系的实现类]
 * @class GoodsTypeMapper.java
 * @package shopping.mapper.impl
 * @project shopping
 *
 * @author jackflynn
 * @time 下午7:36:53
 * @description [主要将商品类型的数据记录还原成商品对象]
 */
public class GoodsTypeMapper implements IRowMapper<GoodsType>{

	@Override
	public GoodsType mapper(Connection conn, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		GoodsType goodsType=new GoodsType();
		goodsType.setGoodsType(rs.getString("GOODSTYPE"));
		goodsType.setGoodsTypeId(rs.getInt("GOODSTYPEID"));
		
		return goodsType;
	}
	
}
