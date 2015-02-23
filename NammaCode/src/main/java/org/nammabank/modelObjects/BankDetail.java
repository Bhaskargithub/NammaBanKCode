package org.nammabank.modelObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author bhaskar
 *	- Bank registered for every group
 */

@Entity 
@Component
@JsonAutoDetect
@Table(name = "BANK_DETAIL")
public class BankDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BANK_ID")
	private int bankId;
	// @SequenceGenerator(name = "SequenceIdGenerator", sequenceName =
	// "HIBERNATE_SEQUENCE")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "SequenceIdGenerator")

	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;
	
	/**
	 * One Bank can have many registered groups
	 */
	
	/*@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "BANK_GROUP", joinColumns = @JoinColumn(name = "BANK_ID"), inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
	private Collection<GroupDetails> groups = new ArrayList<GroupDetails>();*/

	/*@OneToMany(mappedBy="bank")
	private Collection<GroupDetails> groups = new ArrayList<GroupDetails>();*/
	
	@Column(name = "STATE")
	private String state;

	@Column(name = "REGISTERED_YN")
	private Boolean registeredYn;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	/*
	 * public List<String> getRegisteredGroups() { return registeredGroups; }
	 * 
	 * public void setRegisteredGroups(List<String> registeredGroups) {
	 * this.registeredGroups = registeredGroups; }
	 */

	public Boolean getRegisteredYn() {
		return registeredYn;
	}

	public void setRegisteredYn(Boolean registeredYn) {
		this.registeredYn = registeredYn;
	}

	/*public Collection<GroupDetails> getGroups() {
		return groups;
	}

	public void setGroups(Collection<GroupDetails> groups) {
		this.groups = groups;
	}*/

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
