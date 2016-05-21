package shopping.model;
/**
 * 
 * @see [地址数据类型]
 * @class Address.java
 * @package shopping.model
 * @project shopping
 *
 * @author jackflynn
 * @time 下午2:40:41
 * @description [封装项目中地址数据类型]
 */
public class Address {
	private  int addressId;//地址编号
	private String consignee;//收货人姓名
	private String consigneePhone;//收货人联系方式
	private String province;//收货人省地址
	private String city;//收货人城市
	private String country;//收货人区/县地址
	private String desc;//收货人详细地址
	
	
	public Address(int addressId, String consignee, String consigneePhone, String province, String city, String country,
			String desc) {
		super();
		this.addressId = addressId;
		this.consignee = consignee;
		this.consigneePhone = consigneePhone;
		this.province = province;
		this.city = city;
		this.country = country;
		this.desc = desc;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", consignee=" + consignee + ", consigneePhone=" + consigneePhone
				+ ", province=" + province + ", city=" + city + ", country=" + country + ", desc=" + desc + "]";
	}
	
}
