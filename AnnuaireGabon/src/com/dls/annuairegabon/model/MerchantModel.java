package com.dls.annuairegabon.model;

import com.dls.annuairegabon.enums.MerchantCategoryEnum;

/**
 * Merchant Model - Modele de Commercant 
 * @author Damdoum
 */
public class MerchantModel {
	private String firstName;
	private String lastName;
	private String address;
	private int telephoneNumber;
	private MerchantCategoryEnum merchantCategory;
	
	/**
	 * Public constructor
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phoneNumber
	 * @param merchantCategory
	 */
	public MerchantModel(String firstName, String lastName, String address, int phoneNumber,
			MerchantCategoryEnum merchantCategory){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephoneNumber = phoneNumber;
		this.merchantCategory = merchantCategory;
	}
	
	//---------------------------------------- Getters & Setters ----------------------------------------//
	/**
	 * Get the merchant's first name
	 * @return firstName
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * Set the merchant's first name
	 * @param newFirstName
	 */
	public void setFirstName(String newFirstName){
		this.firstName = newFirstName;
	}

	/**
	 * Get the merchant's last name
	 * @return lastName
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * Set the merchant's last name
	 * @param newLastName
	 */
	public void setLastName(String newLastName){
		this.lastName = newLastName;
	}

	/**
	 * Get the merchant's address
	 * @return address
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * Set the merchant's address
	 * @param newAddress
	 */
	public void setAddress(String newAddress){
		this.address = newAddress;
	}

	/**
	 * Get the merchant's telephone number
	 * @return telephone number
	 */
	public int getTelephoneNumber(){
		return telephoneNumber;
	}
	
	/**
	 * Set the merchant's telephone number
	 * @param newTelephoneNumber
	 */
	public void setTelephoneNumber(int newTelephoneNumber){
		this.telephoneNumber = newTelephoneNumber;
	}

	/**
	 * Get the merchant's Category
	 * @return category
	 */
	public MerchantCategoryEnum setCategory(){
		return merchantCategory;
	}
	
	/**
	 * Set the merchant's category
	 * @param newCategory
	 */
	public void setCategory(MerchantCategoryEnum newCategory){
		this.merchantCategory = newCategory;
	}
}
