package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import shopping.dao.impl.GoodsTypeDAO;
import shopping.dbhelper.ConnectionManager;
import shopping.model.GoodsType;
import shopping.utils.FindType;

public class GoodsTypeService {
	private GoodsTypeDAO goodsTypeDAO=new GoodsTypeDAO();
	private List<GoodsType> goodsTypeList;
	private GoodsType goodsType;
	private Connection conn;
	public List<GoodsType> getTypes(){
		//获取数据库连接
		//查询商品类型数据
		try {
			conn=ConnectionManager.getConnection();
			goodsTypeList=goodsTypeDAO.findAll(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			//关闭数据库连接释放资源
			ConnectionManager.free(conn);
		}
		//返货查询到的数据
		return goodsTypeList;
		
	}
	
	public GoodsType getTypeByName(String typeName){
		try {
			//goodstype的名称不能重复！不能重复！要不会出问题
			conn=ConnectionManager.getConnection();
			goodsTypeList=goodsTypeDAO.findByCondition(conn, FindType.TYPENAME, typeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			//关闭数据库连接释放资源
			ConnectionManager.free(conn);
		}
		
		return goodsTypeList.get(0);
	}
}
