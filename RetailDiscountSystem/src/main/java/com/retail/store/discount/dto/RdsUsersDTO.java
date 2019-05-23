package com.retail.store.discount.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RdsUsersDTO

{
	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private String email;

	private String address;

	private String userType;

	private String phone;

	private String city;

	private String country;

	private int isActive;

	private Date activeDate;

	private Date entDate;

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	public String getFirstName()

	{

		return this.firstName;

	}

	public void setFirstName(String firstName)

	{

		this.firstName = firstName;

	}

	public String getLastName()

	{

		return this.lastName;

	}

	public void setLastName(String lastName)

	{

		this.lastName = lastName;

	}

	public String getUsername()

	{

		return this.username;

	}

	public void setUsername(String username)

	{

		this.username = username;

	}

	public String getPassword()

	{

		return this.password;

	}

	public void setPassword(String password)

	{

		this.password = password;

	}

	public String getEmail()

	{

		return this.email;

	}

	public void setEmail(String email)

	{

		this.email = email;

	}

	public String getAddress()

	{

		return this.address;

	}

	public void setAddress(String address)

	{

		this.address = address;

	}

	public String getUserType()

	{

		return this.userType;

	}

	public void setUserType(String userType)

	{

		this.userType = userType;

	}

	public String getPhone()

	{

		return this.phone;

	}

	public void setPhone(String phone)

	{

		this.phone = phone;

	}

	public String getCity()

	{

		return this.city;

	}

	public void setCity(String city)

	{

		this.city = city;

	}

	public String getCountry()

	{

		return this.country;

	}

	public void setCountry(String country)

	{

		this.country = country;

	}

	public int getIsActive()

	{

		return this.isActive;

	}

	public void setIsActive(int isActive)

	{

		this.isActive = isActive;

	}

	public Date getActiveDate()

	{

		return this.activeDate;

	}

	public void setActiveDate(Date activeDate)

	{

		this.activeDate = activeDate;

	}

	public Date getEntDate()

	{

		return this.entDate;

	}

	public void setEntDate(Date entDate)

	{

		this.entDate = entDate;

	}
}
