package com.fushui.jdbc_demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import java.util.List;

import com.fushui.jdbc_demo.model.Goddess;
import com.fushui.jdbc_demo.utils.DBUtils;

public class Dao {
	public void addGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtils.getConn();
		String sql = "INSERT imooc_goddess"
				+ "(user_name,sex,age,birthday,email,mobile,"
				+ "create_user,create_date,update_user,update_date," + "isDel)"
				+ "VALUES(?,?,?,?,?,"
				+ "?,?,current_date(),?,current_date(),?) ";

		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, 1);
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());

		ptmt.setString(7, g.getCreate_user());
		// ptmt.setDate(8, new Date(g.getCreate_date().getTime()));

		ptmt.setString(8, g.getUpdate_user());
		// ptmt.setDate(10, new Date(g.getUpdate_date().getTime()));

		ptmt.setInt(9, 1);

		ptmt.execute();
	}

	public void updateGoddess(Goddess g) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql = "UPDATE imooc_goddess "
				+ "SET user_name = ?,sex = ?,age = ?,birthday = ? ,email = ?,mobile = ?,"
				+ "update_user = ?,update_date = current_date(), "
				+ "isDel = ? " + "WHERE id = ?";

		// 注意where与前面的？之间要加空格，否则会报错

		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, 1);
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());

		// ptmt.setString(7, g.getCreate_user());
		// ptmt.setDate(8, new Date(g.getCreate_date().getTime()));

		ptmt.setString(7, g.getUpdate_user());
		// ptmt.setDate(10, new Date(g.getUpdate_date().getTime()));

		ptmt.setInt(8, 0);
		ptmt.setInt(9, g.getId());

		ptmt.execute();
	}

	public void deleteGoddess(Integer p_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql = "DELETE FROM imooc_goddess " + "WHERE id = ?";

		// 注意where与前面的？之间要加空格，否则会报错

		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, p_id);

		ptmt.execute();
	}

	public Goddess get(Integer p_id) throws SQLException {
		Goddess g = null;

		Connection conn = DBUtils.getConn();

		String sql = "SELECT * FROM imooc_goddess " + "WHERE id = ? ";

		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, p_id);

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {

			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));

			// sql.date为sql.date的子集,这里就不用转换
			g.setBirthday(rs.getDate("birthday"));

			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));

			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));

			g.setIsDel(rs.getInt("isDel"));

		}

		return g;
	}

	public List<Goddess> query(List<Map<String, Object>> params)
			throws SQLException {
		List<Goddess> goddess_list = new ArrayList<Goddess>();
		Goddess g = null;

		Connection conn = DBUtils.getConn();

		StringBuilder sb = new StringBuilder();
		
		//常用技巧
		sb.append("SELECT * FROM imooc_goddess WHERE 1 = 1 ");

		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> param = params.get(i);

				sb.append(" and " + param.get("name") + param.get("rela")
						+ param.get("value"));

			}
		}

		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {

			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));

			// sql.date为sql.date的子集,这里就不用转换
			g.setBirthday(rs.getDate("birthday"));

			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));

			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));

			g.setIsDel(rs.getInt("isDel"));

			goddess_list.add(g);
		}

		return goddess_list;
	}

	public List<Goddess> queryAllGoddess() throws SQLException {

		List<Goddess> goddess_list = new ArrayList<Goddess>();

		Connection conn = DBUtils.getConn();
		// 3.通过数据库的连接操作数据库，实现增删改查
		Statement statement = conn.createStatement();

		ResultSet rs= statement
				.executeQuery("SELECT * FROM imooc_goddess");
		while (rs.next()) {
			Goddess g = new Goddess();

			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));

			// sql.date为sql.date的子集,这里就不用转换
			g.setBirthday(rs.getDate("birthday"));

			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));

			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("update_date"));

			g.setIsDel(rs.getInt("isDel"));

			goddess_list.add(g);
		}
		return goddess_list;
	}

}
