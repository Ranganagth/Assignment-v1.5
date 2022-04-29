package com.example.microservices.MicroService_2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
//	//@GeneratedValue
//	private int id;
	private String deviceId ;
	private String device_name;
	private String device_serial_no;
	private String device_type_id ;
	private String status;
	private String prototype_id;
	private String location_Id;
	private String created_by;
	private String created_timestamp;
	private String udated_timestamp;
	private String account_id;
	private String device_state;
	private String user_device_type;
	private String tcu_serial_number; 
	private String imei;
	private String iccid;
	@Override
	public String toString() {
		return "User [device_id=" + deviceId + ", device_name=" + device_name + ", device_serial_no="
				+ device_serial_no + ", device_type_id=" + device_type_id + ", status=" + status + ", prototype_id="
				+ prototype_id + ", location_Id=" + location_Id + ", created_by=" + created_by + ", created_timestamp="
				+ created_timestamp + ", udated_timestamp=" + udated_timestamp + ", account_id=" + account_id
				+ ", device_state=" + device_state + ", user_device_type=" + user_device_type + ", tcu_serial_number="
				+ tcu_serial_number + ", imei=" + imei + ", iccid=" + iccid + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String device_id, String device_name, String device_serial_no, String device_type_id, String status,
                String prototype_id, String location_Id, String created_by, String created_timestamp,
                String udated_timestamp, String account_id, String device_state, String user_device_type,
                String tcu_serial_number, String imei, String iccid) {
		super();
		this.deviceId = device_id;
		this.device_name = device_name;
		this.device_serial_no = device_serial_no;
		this.device_type_id = device_type_id;
		this.status = status;
		this.prototype_id = prototype_id;
		this.location_Id = location_Id;
		this.created_by = created_by;
		this.created_timestamp = created_timestamp;
		this.udated_timestamp = udated_timestamp;
		this.account_id = account_id;
		this.device_state = device_state;
		this.user_device_type = user_device_type;
		this.tcu_serial_number = tcu_serial_number;
		this.imei = imei;
		this.iccid = iccid;
	}
	public String getDevice_id() {
		return deviceId;
	}
	public void setDevice_id(String device_id) {
		this.deviceId = device_id;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_serial_no() {
		return device_serial_no;
	}
	public void setDevice_serial_no(String device_serial_no) {
		this.device_serial_no = device_serial_no;
	}
	public String getDevice_type_id() {
		return device_type_id;
	}
	public void setDevice_type_id(String device_type_id) {
		this.device_type_id = device_type_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrototype_id() {
		return prototype_id;
	}
	public void setPrototype_id(String prototype_id) {
		this.prototype_id = prototype_id;
	}
	public String getLocation_Id() {
		return location_Id;
	}
	public void setLocation_Id(String location_Id) {
		this.location_Id = location_Id;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_timestamp() {
		return created_timestamp;
	}
	public void setCreated_timestamp(String created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	public String getUdated_timestamp() {
		return udated_timestamp;
	}
	public void setUdated_timestamp(String udated_timestamp) {
		this.udated_timestamp = udated_timestamp;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getDevice_state() {
		return device_state;
	}
	public void setDevice_state(String device_state) {
		this.device_state = device_state;
	}
	public String getUser_device_type() {
		return user_device_type;
	}
	public void setUser_device_type(String user_device_type) {
		this.user_device_type = user_device_type;
	}
	public String getTcu_serial_number() {
		return tcu_serial_number;
	}
	public void setTcu_serial_number(String tcu_serial_number) {
		this.tcu_serial_number = tcu_serial_number;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	
	
	
	}
	
