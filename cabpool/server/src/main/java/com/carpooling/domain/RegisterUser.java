package com.carpooling.domain;

public class RegisterUser {
	private int emp_id;
	private String pwd;
	private String emp_name;
	private long cont_no;
	private long alt_cont_no;
	private String email_id;
	private String address;
	private String user_role;
	private String vehicle_no;
	private String vehicle_type;
	private int seat_count;
	private String created_at; 
	private String update_at;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public long getCont_no() {
		return cont_no;
	}
	public void setCont_no(long cont_no) {
		this.cont_no = cont_no;
	}
	public long getAlt_cont_no() {
		return alt_cont_no;
	}
	public void setAlt_cont_no(long alt_cont_no) {
		this.alt_cont_no = alt_cont_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public int getSeat_count() {
		return seat_count;
	}
	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}
	@Override
	public String toString() {
		return "RegisterUser [emp_id=" + emp_id + ", emp_name=" + emp_name
				+ ", cont_no=" + cont_no + ", alt_cont_no=" + alt_cont_no
				+ ", email_id=" + email_id + ", created_at=" + created_at
				+ ", update_at=" + update_at + "]";
	}
}
