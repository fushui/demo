package com.fushui.jdbc_demo.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fushi.jdbc_demo.action.GoddessAction;
import com.fushui.jdbc_demo.model.Goddess;

public class View {
	private static final String CONTEXT = "欢迎来到女神禁区：\n" + "下面是女神禁区的功能列表：\n"
			+ "[MAIN/M]:主菜单\n" + "[QUERY/Q]:查看全部女神的信息\n"
			+ "[GET/G]:查看某位女神的详细信息\n" + "[ADD/A]:添加女神信息\n"
			+ "[UPDATE/U]:更新女神信息\n" + "[DELETE/D]:删除女神信息\n"
			+ "[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" + "[EXIT/E]:退出女神禁区\n"
			+ "[BREAK/B]:退出当前功能，返回主菜单";

	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args) {
		System.out.println(CONTEXT);
		Scanner scanner = new Scanner(System.in);
		GoddessAction action = new GoddessAction();
		Goddess goddess = new Goddess();
		String previou = null;
		Integer step = 1;
		Integer get_step = 1;
		Integer update_step = 0;
		Integer delete_step = 1;
		Integer search_step = 1;

		while (scanner.hasNext()) {
			String in = scanner.next().toString();

			// 退出模块
			if (OPERATION_EXIT.equals(in.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("你已经成功退出!");
				break;
			} else if (OPERATION_SEARCH.equals(in.toUpperCase())
					|| OPERATION_SEARCH.substring(0, 1)
							.equals(in.toUpperCase())
					|| OPERATION_SEARCH.equals(previou)) {
				
				previou = OPERATION_SEARCH;
				if (search_step == 1) {
					// System.out.println("输入你要查看的女神信息的[id]");
				} else {
					List<Goddess> list = new ArrayList<Goddess>();

					List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

					Map<String, Object> map = new HashMap<String, Object>();

					Goddess g = null;
					map.put("name", "user_name ");
					map.put("rela", "like");
					map.put("value", "'"+in+"'"); // 注意里面的引号
					maps.add(map);
					try {

						list = action.query(maps);

						System.out.println(list.size() + '\n');

						for (int i = 0; i < list.size(); i++) {
							g = list.get(i);
							if (g != null) {
								System.out.println("id: " + g.getId() + '\n'
										+ "user_name: " + g.getUser_name()
										+ '\n' + "age: " + g.getAge() + '\n'
										+ "birthday: " + g.getBirthday() + '\n'
										+ "email: " + g.getEmail() + '\n'
										+ "mobile: " + g.getMobile() + '\n');
							} else {
								System.out.println("不存在该女神信息，请重新输入");
							}
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("不存在该女神信息，请重新输入");
					}
				}
				if (OPERATION_SEARCH.equals(previou)) {
					search_step++;
					System.out.println("输入你要查看的女神信息的[姓名]");

				}
			} else if (OPERATION_BREAK.equals(in.toUpperCase())
					|| OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("你已经成功退出当前功能!");
				continue;
			} else if (OPERATION_ADD.equals(in.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(previou)) {
				previou = OPERATION_ADD;

				if (1 == step) {
					System.out.println("请输入女神的［姓名］");
				} else if (2 == step) {
					goddess.setUser_name(in);
					System.out.println("请输入女神的［年龄］");
				} else if (3 == step) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("请输入女神的［生日］，格式如：yyyy-MM-dd");
				} else if (4 == step) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					Date birthday = null;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("请输入女神的［邮箱］");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("您输入的格式有误，请重新输入");
						step = 3;
					}
				} else if (5 == step) {
					goddess.setEmail(in);
					System.out.println("请输入女神的［手机号］");
				} else if (6 == step) {
					goddess.setMobile(in);

					try {
						action.add(goddess);
						System.out.println("新增女神成功");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("新增女神失败");
					}
				}
				if (OPERATION_ADD.equals(previou)) {
					step++;
				}
			} else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_QUERY.equals(previou)) {

				previou = OPERATION_QUERY;

				System.out.println("查看所有女神信息\n");

				List<Goddess> list = new ArrayList<Goddess>();
				try {
					list = action.queryAll();
					System.out.println("list_size: " + list.size() + '\n');
					for (int i = 0; i < list.size(); i++) {
						Goddess g = list.get(i);
						System.out.println(g.getId() + ": " + g.getUser_name()
								+ '\n');
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (OPERATION_GET.equals(in.toUpperCase())
					|| OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_GET.equals(previou)) {
				previou = OPERATION_GET;
				if (get_step == 1) {
					// System.out.println("输入你要查看的女神信息的[id]");
				} else {

					Integer id = Integer.valueOf(in.toString());
					try {
						Goddess g = action.get(id);
						if (g != null) {
							System.out.println("id: " + g.getId() + '\n'
									+ "user_name: " + g.getUser_name() + '\n'
									+ "age: " + g.getAge() + '\n'
									+ "birthday: " + g.getBirthday() + '\n'
									+ "email: " + g.getEmail() + '\n'
									+ "mobile: " + g.getMobile() + '\n');
						} else {
							System.out.println("不存在该女神信息，请重新输入");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("不存在该女神信息，请重新输入");
					}
				}
				if (OPERATION_GET.equals(previou)) {
					get_step++;
					System.out.println("输入你要查看的女神信息的[id]");

				}
			} else if (OPERATION_UPDATE.equals(in.toUpperCase())
					|| OPERATION_UPDATE.substring(0, 1)
							.equals(in.toUpperCase())
					|| OPERATION_UPDATE.equals(previou)) {
				previou = OPERATION_UPDATE;
				if (0 == update_step) {
					System.out.println("请输入女神的［id］");
				} else if (1 == update_step) {
					goddess.setId(Integer.valueOf(in));
					System.out.println("请输入女神的［姓名］");
				} else if (2 == update_step) {
					goddess.setUser_name(in);
					System.out.println("请输入女神的［年龄］");
				} else if (3 == update_step) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("请输入女神的［生日］，格式如：yyyy-MM-dd");
				} else if (4 == update_step) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					Date birthday = null;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("请输入女神的［邮箱］");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("您输入的格式有误，请重新输入");
						update_step = 3;
					}
				} else if (5 == update_step) {
					goddess.setEmail(in);
					System.out.println("请输入女神的［手机号］");
				} else if (6 == update_step) {
					goddess.setMobile(in);

					try {
						action.update(goddess);
						System.out.println("新增女神成功");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("新增女神失败");
					}
				}
				if (OPERATION_UPDATE.equals(previou)) {
					update_step++;
				}
			} else if (OPERATION_DELETE.equals(in.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1)
							.equals(in.toUpperCase())
					|| OPERATION_DELETE.equals(previou)) {
				previou = OPERATION_DELETE;

				if (delete_step == 1) {

				} else {

					Integer id = Integer.valueOf(in.toString());

					try {
						action.delete(id);
						System.out.println("删除成功！");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("删除失败!\n");

					}

				}
				if (OPERATION_DELETE.equals(previou)) {
					System.out.println("请输入要删除的女神[id] : \n");
					delete_step++;
				}
			} else {

				// 输出输入的值
				System.out.println("你输入的值为: " + in);
			}

		}
	}
}
