package com.fushui.jdbc_demo.test;

import java.sql.SQLException;
import java.util.List;

import com.fushi.jdbc_demo.action.GoddessAction;
import com.fushui.jdbc_demo.model.Goddess;

public class Test {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		GoddessAction action = new GoddessAction();
		
		
		
		action.delete(7);
		action.delete(10);
		
		List<Goddess> list  = action.queryAll();
		System.out.println("list_size: "+list.size() + '\n');
		for(int i = 0; i < list.size(); i ++){
			Goddess g = list.get(i);
			System.out.println(g.getId() + ": " + g.getUser_name() + '\n');
		}
		
		Goddess goddess = action.get(2);
		
		System.out.println(goddess.toString());
	}

}
