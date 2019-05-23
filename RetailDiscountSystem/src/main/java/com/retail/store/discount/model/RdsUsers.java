package com.retail.store.discount.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Entity

@Table(name = "RDS_USERS")

@SequenceGenerator(name = "RDS_USERS_SEQ_Gen", sequenceName = "RDS_USERS_SEQ", allocationSize = 1)

@NamedQueries({ @NamedQuery(name = "findAllRdsUsers1", query = "SELECT rUsrs FROM RdsUsers rUsrs "),
		@NamedQuery(name = "findUniqueRdsUsersBYUsername2", query = "SELECT rUsrs FROM RdsUsers rUsrs WHERE   rUsrs.username = :username "),
		@NamedQuery(name = "findUniqueRdsUsersBYEmail4", query = "SELECT rUsrs FROM RdsUsers rUsrs WHERE   rUsrs.email = :email ") })
@Proxy(lazy=false)
public class RdsUsers implements Serializable

{

	private static final long serialVersionUID = 1447845814186660052L;

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

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RDS_USERS_SEQ_Gen")

	@Column(name = "ID")

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	@Column(name = "FIRST_NAME")

	public String getFirstName()

	{

		return this.firstName;

	}

	public void setFirstName(String firstName)

	{

		this.firstName = firstName;

	}

	@Column(name = "LAST_NAME")

	public String getLastName()

	{

		return this.lastName;

	}

	public void setLastName(String lastName)

	{

		this.lastName = lastName;

	}

	@Column(name = "USERNAME", nullable = false, unique = true)

	public String getUsername()

	{

		return this.username;

	}

	public void setUsername(String username)

	{

		this.username = username;

	}

	@Column(name = "PASSWORD", nullable = false)

	public String getPassword()

	{

		return this.password;

	}

	public void setPassword(String password)

	{

		this.password = password;

	}

	@Column(name = "EMAIL", unique = true, nullable = false)

	public String getEmail()

	{

		return this.email;

	}

	public void setEmail(String email)

	{

		this.email = email;

	}

	@Column(name = "ADDRESS")

	public String getAddress()

	{

		return this.address;

	}

	public void setAddress(String address)

	{

		this.address = address;

	}

	@Column(name = "USER_TYPE")

	public String getUserType()

	{

		return this.userType;

	}

	public void setUserType(String userType)

	{

		this.userType = userType;

	}

	@Column(name = "PHONE")

	public String getPhone()

	{

		return this.phone;

	}

	public void setPhone(String phone)

	{

		this.phone = phone;

	}

	@Column(name = "CITY")

	public String getCity()

	{

		return this.city;

	}

	public void setCity(String city)

	{

		this.city = city;

	}

	@Column(name = "COUNTRY")

	public String getCountry()

	{

		return this.country;

	}

	public void setCountry(String country)

	{

		this.country = country;

	}

	@Column(name = "IS_ACTIVE")

	public int getIsActive()

	{

		return this.isActive;

	}

	public void setIsActive(int isActive)

	{

		this.isActive = isActive;

	}

	@Column(name = "ACTIVE_DATE")

	@Temporal(TemporalType.TIMESTAMP)

	public Date getActiveDate()

	{

		return this.activeDate;

	}

	public void setActiveDate(Date activeDate)

	{

		this.activeDate = activeDate;

	}

	@Column(name = "ENT_DATE")

	@Temporal(TemporalType.TIMESTAMP)

	public Date getEntDate()

	{

		return this.entDate;

	}

	public void setEntDate(Date entDate)

	{

		this.entDate = entDate;

	}
}
