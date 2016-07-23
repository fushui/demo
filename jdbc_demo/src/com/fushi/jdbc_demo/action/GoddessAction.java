package com.fushi.jdbc_demo.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fushui.jdbc_demo.dao.Dao;
import com.fushui.jdbc_demo.model.Goddess;

public class GoddessAction {

	
	public void delete(int i) throws SQLException {
		// TODO Auto-generated method stub
		Dao d = new Dao();
		d.deleteGoddess(i);
	}

	public void update(Goddess g) throws SQLException {

		Dao d = new Dao();
		d.updateGoddess(g);
	}

	public void add(Goddess g) throws SQLException {

		// g.setSex(0);
		// g.setAge(22);
		// g.setBirthday(new Date());
		// g.setEmail("xiao@163.com");
		// g.setUser_name("一一呵呵");
		// g.setMobile("13046114785");
		//
		// g.setCreate_user("root");
		// g.setUpdate_user("root");
		// g.setIsDel(1);

		Dao d = new Dao();
		d.addGoddess(g);

	}

	public List<Goddess> queryAll() throws SQLException {

		Dao dao = new Dao();
		return dao.queryAllGoddess();
	}

	public List<Goddess> query(List<Map<String, Object>> params)
			throws SQLException {
		Dao dao = new Dao();
		return dao.query(params);
	}

	public Goddess get(Integer i) throws SQLException {

		Dao dao = new Dao();
		return dao.get(i);
	}

	public void queryByName(String name) throws SQLException {

		Dao dao = new Dao();
		Goddess g = null;
		List<Goddess> list = new ArrayList<Goddess>();

		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = null;
		map = new HashMap<String, Object>();

		map.put("name", "user_name ");
		map.put("rela", "like");
		map.put("value", "'%x%'"); // 注意里面的引号
		maps.add(map);

		map = new HashMap<String, Object>();

		map.put("name", "age");
		map.put("rela", "=");
		map.put("value", "22");
		maps.add(map);
		list = dao.query(maps);

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
