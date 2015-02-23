package org.nammabank.modelObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NaturalId;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//@XmlRootElement
@Entity
@Component
@JsonAutoDetect
@Table(name="USER_INFO" )
public class UserInfo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="GENDER")
	private String sex;
	
	/**
	 * considering the user has only one address as of now
	 */
	
	@Embedded
	private Address address;
	
	@Column(name="JOINING_DATE")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@Column(name="TERMINATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date terminationDate;
	
	@NaturalId(mutable = false)
	private String eMail;
	
	@Column(name="ACTIVE_USER")
	private String activeYN;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getActiveYN() {
		return activeYN;
	}
	public void setActiveYN(String activeYN) {
		this.activeYN = activeYN;
	}
	
	
}
