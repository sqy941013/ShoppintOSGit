package shopping.service;
/**
 * 
 * @see [商品对象的业务处理]
 * @class GoodsService.java
 * @package shopping.service
 * @project shopping
 *
 * @author jackflynn
 * @time 上午11:48:44
 * @description [主要针对商品相关的业务处理的java类]
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.impl.GoodsDAO;
import shopping.dbhelper.ConnectionManager;
import shopping.model.Goods;
import shopping.utils.FindType;

public class GoodsService {
	private GoodsDAO goodsDAO=new GoodsDAO();
	private List<Goods> goodsList;
	private Connection conn;
	
	public List<Goods> findGoodsByTypeId(int typeId){
		try {
			conn=ConnectionManager.getConnection();
			goodsList=goodsDAO.findByCondition(conn,FindType.GOODSTYPE, typeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			//关闭数据库连接释放资源
			ConnectionManager.free(conn);
		}
		return goodsList;
	}
}
