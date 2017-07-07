package com.carpooling.domain;

public class ProviderDetail {
	private int pid;
	private String empId;
	private String route;
	private String from;
	private String to;
	private String date;
	private String contact;
	private String altContact;
	private String email;
	private String vehicleNo;
	private String vehType;
	private String noOfSeats;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAltContact() {
		return altContact;
	}
	public void setAltContact(String altContact) {
		this.altContact = altContact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehType() {
		return vehType;
	}
	public void setVehType(String vehType) {
		this.vehType = vehType;
	}
	public String getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	@Override
	public String toString() {
		return "ProviderDetail [pid=" + pid + ", empId=" + empId + ", route="
				+ route + ", from=" + from + ", to=" + to + ", date=" + date
				+ ", contact=" + contact + ", altContact=" + altContact
				+ ", email=" + email + ", vehicleNo=" + vehicleNo
				+ ", vehType=" + vehType + ", noOfSeats=" + noOfSeats + "]";
	}
}
