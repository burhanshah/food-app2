package com.foodapp.model;

public class Order {
	private Menu orderItems;
	private Float totalPrice;
	private int orderId;
	private String resName;
	private String user;
	private String address;
	private String contact;
	private String comments;
	
	
	
	

	public Order(Menu orderItems, Float totalPrice, int orderId, String resName, String user, String address,
			String contact, String comments) {
		super();
		this.orderItems = orderItems;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.resName = resName;
		this.user = user;
		this.address = address;
		this.contact = contact;
		this.comments = comments;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public String getResName() {
		return resName;
	}
	
	public void setResName(String resName) {
		this.resName = resName;
	}

	public Order(Menu orderItems, Float totalPrice, int orderId, String resName) {
		super();
		this.orderItems = orderItems;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.resName = resName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Order() {
		super();

	}

	public Order(Menu orderItems, Float totalPrice) {
		super();
		this.orderItems = orderItems;
		this.totalPrice = totalPrice;
	}

	public Menu getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Menu orderItems) {
		this.orderItems = orderItems;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
