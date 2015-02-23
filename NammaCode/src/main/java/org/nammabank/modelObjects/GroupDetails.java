package org.nammabank.modelObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;




@Entity 
@Component
@JsonAutoDetect
@NamedQuery(name="GetAllGroups", query="from GroupDetails")
@Table(name = "GROUP_DETAIL")
public class GroupDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_ID")
	private int groupId;
	@Column(name="SHORT_NAME")
	private String groupShortName;
	private String groupName;
	@ManyToOne
	@JoinColumn(name="ADMIN_ID")
	private UserInfo admin;
	@ManyToOne
	@JoinColumn(name="FIRST_REPRESENTATIVE")
	private UserInfo firstRepresentative;
	@ManyToOne
	@JoinColumn(name="SECOND_REPRESENTATIVE")
	private UserInfo secondRepresentative;

	/**
	 * Many groups can be registered under one single bank for transaction
	 * 15 hibernate 
	 */
	
	@ManyToOne
	@JoinColumn(name="BANK_ID")
	private BankDetail bank;
	private String street;
	
	@Column(name = "BANK_ACC_NUM")
	private String bankAccNumber;
	
	private String city;
	private String state;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date terminationDate;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public BankDetail getBank() {
		return bank;
	}
	public void setBank(BankDetail bank) {
		this.bank = bank;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	public String getBankAccNumber() {
		return bankAccNumber;
	}
	public void setBankAccNumber(String bankAccNumber) {
		this.bankAccNumber = bankAccNumber;
	}
	public String getGroupShortName() {
		return groupShortName;
	}
	public void setGroupShortName(String groupShortName) {
		this.groupShortName = groupShortName;
	}
	public UserInfo getAdmin() {
		return admin;
	}
	public void setAdmin(UserInfo admin) {
		this.admin = admin;
	}
	public UserInfo getFirstRepresentative() {
		return firstRepresentative;
	}
	public void setFirstRepresentative(UserInfo firstRepresentative) {
		this.firstRepresentative = firstRepresentative;
	}
	public UserInfo getSecondRepresentative() {
		return secondRepresentative;
	}
	public void setSecondRepresentative(UserInfo secondRepresentative) {
		this.secondRepresentative = secondRepresentative;
	}
	
	
}
