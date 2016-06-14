package com.mybatis.entity;

public class User {
@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", phone=" + phone + ", type=" + type + ", ma=" + ma
				+ ", id=" + id + "]";
	}
private String name;
private String password;
private String phone;
private String type;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private int ma;
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getMa() {
	return ma;
}
public void setMa(int ma) {
	this.ma = ma;
}

}
