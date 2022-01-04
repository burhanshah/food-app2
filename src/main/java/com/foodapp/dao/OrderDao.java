package com.foodapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.foodapp.model.Item;
import com.foodapp.model.Menu;
import com.foodapp.model.Order;
import com.foodapp.model.Restraunt;

public class OrderDao {
	private static List<Order> orders = new ArrayList<>();

	public static List<Order> getAllOrders() {
		return orders;
	}
	
	public static Order addOrder(String user, Map<String, String[]> parameterMap, String resname) {
		RestrauntUtil resUtil = new RestrauntUtil();
		Restraunt res = resUtil.getRestrauntByName(resname);

		// Create new order
		Order order = new Order();
		order.setOrderId(orders.size() + 1); // It should come from DB
		order.setResName(resname);
		order.setUser(user);

		Menu orderMenu = new Menu();

		orderMenu.setVeg(calculateMenu(res.getMenu().getVeg(), parameterMap.get("veg_item_qty")));
		orderMenu.setNonveg(calculateMenu(res.getMenu().getNonveg(), parameterMap.get("non_veg_item_qty")));
		orderMenu.setBread(calculateMenu(res.getMenu().getBread(), parameterMap.get("bread_item_qty")));
		orderMenu.setBeverage(calculateMenu(res.getMenu().getBeverage(), parameterMap.get("beverages_item_qty")));

		order.setOrderItems(orderMenu);

		order.setTotalPrice(calculatePrice(orderMenu));

		orders.add(order);

		return order;

	}

	// Method overloading
	private static Float calculatePrice(Menu orderMenu) {
		float totalPrice = calculatePrice(orderMenu.getVeg());
		totalPrice += calculatePrice(orderMenu.getNonveg());
		totalPrice += calculatePrice(orderMenu.getBread());
		totalPrice += calculatePrice(orderMenu.getBeverage());

		return totalPrice;
	}

	// Method overloading
	private static float calculatePrice(List<Item> items) {
		float p = 0.0F;
		for (Item i : items) {
			p += i.getPrice();
		}
		return p;
	}
	
	// List<Item> veg => [('dal fry', 56), ('chana dal', 67) ... ) 
	// ["1", ""]
	private static List<Item> calculateMenu(List<Item> veg, String[] qty) {
		List<Item> items = new ArrayList<>();
		if (qty == null || qty.length == 0) {
			return new ArrayList<>();
		}

		for (int i = 0; i < qty.length; i++) {
			if (qty[i] == null || qty[i].trim().isBlank()) {
				continue;
			}
			int item_qty = Integer.parseInt(qty[i]);
			String name = veg.get(i).getName();
			float price = veg.get(i).getPrice();

			items.add(new Item(name, (price * item_qty), item_qty));
		}

		return items;

	}

	public static List<Order> getOrderByUser(String username) {
		List<Order> userOrders = new ArrayList<>();
		for(Order order : orders) {
			if(order.getUser().equalsIgnoreCase(username)) {
				userOrders.add(order);
			}
		}
		return userOrders;
	}

	public void addOrderDetails(Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub
		
	}

}
