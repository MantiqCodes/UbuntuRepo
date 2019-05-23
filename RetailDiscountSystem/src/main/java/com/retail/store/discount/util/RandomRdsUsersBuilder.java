package com.retail.store.discount.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.retail.store.discount.model.RdsUsers;

public class RandomRdsUsersBuilder
{
	static long id = 0;

	public static RdsUsers build()
	{
		RdsUsersDataEntryHelper data = new RdsUsersDataEntryHelper();
		RdsUsers user = new RdsUsers();
		user.setId(id++);

		int cntryIndex = ThreadLocalRandom.current().nextInt(0, data.cityList.length);
		String firstName = data.getNextFirstName();
		String lastName = data.getNextLastName();
		String cityName = data.getNextCityName(cntryIndex);
		String countryName = data.getNextCountryName(cntryIndex);
		String email = data.getNextEmail(firstName);
		String userName = firstName + data.getNewUuId();
		String address = firstName + " " + lastName + " \t " + cityName + " , " + countryName;
		Date now = new Date();
		int isActive = 1;
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setCity(cityName);
		user.setCountry(countryName);

		user.setEmail(email);
		user.setUsername(userName);
		user.setPassword(lastName);
		user.setAddress(address);
		user.setPhone(data.uuid);
		user.setEntDate(now);
		user.setActiveDate(now);
		user.setIsActive(isActive);
		user.setUserType(UserTypes.CUSTOMER.value());
		return user;
	}

	public static String[] getFirstNameList(RdsUsers[] rdsUsersList)
	{
		String[] firstNameList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			firstNameList[i] = rdsUsersList[i].getFirstName();
		return firstNameList;
	}

	public static String[] getLastNameList(RdsUsers[] rdsUsersList)
	{
		String[] lastNameList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			lastNameList[i] = rdsUsersList[i].getLastName();
		return lastNameList;
	}

	public static String[] getActiveDateList(RdsUsers[] rdsUsersList)
	{
		String[] activeDateList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			activeDateList[i] = rdsUsersList[i].getActiveDate().toString();
		return activeDateList;
	}

	public static String[] getAddressList(RdsUsers[] rdsUsersList)
	{
		String[] addressList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			addressList[i] = rdsUsersList[i].getAddress();
		return addressList;
	}

	public static String[] getCityList(RdsUsers[] rdsUsersList)
	{
		String[] cityList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			cityList[i] = rdsUsersList[i].getCity();
		return cityList;
	}

	public static String[] getCountryList(RdsUsers[] rdsUsersList)
	{
		String[] countryList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			countryList[i] = rdsUsersList[i].getCountry();
		return countryList;
	}

	public static String[] getEmailList(RdsUsers[] rdsUsersList)
	{
		String[] emailList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			emailList[i] = rdsUsersList[i].getEmail();
		return emailList;
	}

	public static String[] getEntDateList(RdsUsers[] rdsUsersList)
	{
		String[] entDateList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			entDateList[i] = rdsUsersList[i].getEntDate().toString();
		return entDateList;
	}

	public static String[] getIsActiveList(RdsUsers[] rdsUsersList)
	{
		String[] isActiveList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			isActiveList[i] = rdsUsersList[i].getIsActive() + "";
		return isActiveList;
	}

	public static String[] getPasswordList(RdsUsers[] rdsUsersList)
	{
		String[] passwordList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			passwordList[i] = rdsUsersList[i].getPassword();
		return passwordList;
	}

	public static String[] getPhoneList(RdsUsers[] rdsUsersList)
	{
		String[] phoneList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			phoneList[i] = rdsUsersList[i].getPhone() + "";
		return phoneList;
	}

	public static String[] getUserTypeList(RdsUsers[] rdsUsersList)
	{
		String[] userTypeList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			userTypeList[i] = rdsUsersList[i].getUserType() + "";
		return userTypeList;
	}

	public static String[] getUserNameList(RdsUsers[] rdsUsersList)
	{
		String[] usernameList = new String[rdsUsersList.length];
		for (int i = 0; i < rdsUsersList.length; i++)
			usernameList[i] = rdsUsersList[i].getUsername() + "";
		return usernameList;
	}

}
