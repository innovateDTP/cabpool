package com.carpooling.domain;

import java.sql.Time;
import java.sql.Date;

public class RideDetails {

	private int rid;
	private int emp_id;
	private String source_add;
	private String Destination_add;
	private Date journey_date;
	private Time journey_time;
	private String user_role;
	private String vehicle_no;
	private int available_seat_count;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getSource_add() {
		return source_add;
	}
	public void setSource_add(String source_add) {
		this.source_add = source_add;
	}
	public String getDestination_add() {
		return Destination_add;
	}
	public void setDestination_add(String destination_add) {
		Destination_add = destination_add;
	}
	public Date getJourney_date() {
		return journey_date;
	}
	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
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
	public int getAvailable_seat_count() {
		return available_seat_count;
	}
	public void setAvailable_seat_count(int available_seat_count) {
		this.available_seat_count = available_seat_count;
	}
	public Time getJourney_time() {
		return journey_time;
	}
	public void setJourney_time(Time journey_time) {
		this.journey_time = journey_time;
	}
	@Override
	public String toString() {
		return "RideDetails [rid=" + rid + ", emp_id=" + emp_id
				+ ", source_add=" + source_add + ", Destination_add="
				+ Destination_add + ", journey_date=" + journey_date
				+ ", time=" + journey_time + ", user_role=" + user_role
				+ ", vehicle_no=" + vehicle_no + ", available_seat_count="
				+ available_seat_count + "]";
	}	
}
