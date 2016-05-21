package shopping.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * @see [会员数据类型]
 * @class Member.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:44:10
 * @description [封装项目中会员数据类型]
 */
public class Member {
	private int memberId;//会员编号
	private String username;//用户名
	private String password;//密码
	private String realName;//真实姓名
	private String phone;//联系方式
	private String headerimg;//会员头像
	private String regNo;//身份证号
	private String gender;//性别
	private int age;//年龄
	private Date registTime;//注册时间
	private List<Address> addressList;//收货地址 可多个
	
	
	public Member(int memberId, String username, String password, String realName, String phone, String headerimg,
			String regNo, String gender, int age, Date registTime, List<Address> addressList) {
		super();
		this.memberId = memberId;
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.phone = phone;
		this.headerimg = headerimg;
		this.regNo = regNo;
		this.gender = gender;
		this.age = age;
		this.registTime = registTime;
		this.addressList = addressList;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	public void setHeaderimg(String headerimg)
	{
		this.headerimg=headerimg;
	}
	
	public String getHeaderimg()
	{
		return this.headerimg;
	}
	

	
	
}
