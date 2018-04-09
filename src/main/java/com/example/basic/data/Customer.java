package com.example.basic.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "customer_sample")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			   name = "select_procedure", 
			   procedureName = "select_procedure"
			     ),
	@NamedStoredProcedureQuery(
			   name = "update_procedure", 
			   procedureName = "update_procedure", 
			   
			   parameters = {
				  @StoredProcedureParameter(  name = "customer_id",  type = Long.class ,mode = ParameterMode.IN ),
			      @StoredProcedureParameter( name = " customer_pts",  type = Double.class,  mode = ParameterMode.IN)
			      
			   })
})
/**
 * If you want to use serialization by annotation you have to uncomment the two annotations
 * below and can use directly without CustomSerialization class. In test cases too we 
 * can directly use ObjectMapper.
 * @author v.rama.krishnan
 *
 */
//@JsonDeserialize(using = CustomSerializationImpl.class)
//@JsonSerialize(using = BasketItemSerializer.class)
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8770902144472421458L;

	@Id
	@Column(name = "id")
	private Long customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "age")
	private Long age;

	@Column(name = "points")
	private Double customerPoints;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Double getCustomerPoints() {
		return customerPoints;
	}

	public void setCustomerPoints(Double customerPoints) {
		this.customerPoints = customerPoints;
	}

	public Customer(Long customerId, String name, String address, Long age, Double customerPoints) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.age = age;
		this.customerPoints = customerPoints;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", age=" + age
				+ ", customerPoints=" + customerPoints + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerPoints == null) ? 0 : customerPoints.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerPoints == null) {
			if (other.customerPoints != null)
				return false;
		} else if (!customerPoints.equals(other.customerPoints))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
