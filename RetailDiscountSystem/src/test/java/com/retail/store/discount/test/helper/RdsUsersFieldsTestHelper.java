package com.retail.store.discount.test.helper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.instanceOf;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.store.discount.model.RdsUsers;

public class RdsUsersFieldsTestHelper
{
	public void testRdsUsersFields(List<RdsUsers> rdsUsersList)
	{
		for (RdsUsers rdsUsers : rdsUsersList)
		{
	rdsUsersCumulativeTest(rdsUsers);	
		}
	}

	public void rdsUsersCumulativeTest(RdsUsers rdsUsers)
	{
		rdsUsersFieldsTypeTest(rdsUsers);
		rdsUserFieldsNonEmptyTest(rdsUsers);
	}
	
	public void rdsUserFieldsNonEmptyTest(RdsUsers rdsUsers)
	{
		assertThat(rdsUsers.getId(), greaterThanOrEqualTo(0L));
		assertThat(rdsUsers.getId(), notNullValue());
		assertThat(rdsUsers.getFirstName(), notNullValue());
		assertThat(rdsUsers.getLastName(), notNullValue());
		assertThat(rdsUsers.getUsername(), notNullValue());
		assertThat(rdsUsers.getPassword(), notNullValue());
		assertThat(rdsUsers.getEmail(), notNullValue());
		assertThat(rdsUsers.getUserType(), notNullValue());
		assertThat(rdsUsers.getActiveDate(), notNullValue());
		assertThat(rdsUsers.getIsActive(), greaterThanOrEqualTo(0));

	}

	public void rdsUsersFieldsTypeTest(RdsUsers rdsUsers)
	{
		assertThat(rdsUsers.getId(), instanceOf(Long.class));
		assertThat(rdsUsers.getFirstName(), instanceOf(String.class));
		assertThat(rdsUsers.getLastName(), instanceOf(String.class));
		assertThat(rdsUsers.getUsername(), instanceOf(String.class));
		assertThat(rdsUsers.getPassword(), instanceOf(String.class));
		assertThat(rdsUsers.getEmail(), instanceOf(String.class));
		assertThat(rdsUsers.getAddress(), instanceOf(String.class));
		assertThat(rdsUsers.getUserType(), instanceOf(String.class));
		assertThat(rdsUsers.getPhone(), instanceOf(String.class));
		assertThat(rdsUsers.getCity(), instanceOf(String.class));
		assertThat(rdsUsers.getCountry(), instanceOf(String.class));
		assertThat(rdsUsers.getIsActive(), instanceOf(Integer.class));
		assertThat(rdsUsers.getActiveDate(), instanceOf(Date.class));
		assertThat(rdsUsers.getEntDate(), instanceOf(Date.class));
	}
	public void rdsUsersFieldsEqualityTest(RdsUsers dbUser,RdsUsers user)
	{
		
		assertThat(dbUser.getId()).isEqualTo(user.	getId());
		assertThat(dbUser.getFirstName()).isEqualTo(user.	getFirstName());
		assertThat(dbUser.getLastName()).isEqualTo(user.	getLastName());
		assertThat(dbUser.getUsername()).isEqualTo(user.	getUsername());
		assertThat(dbUser.getPassword()).isEqualTo(user.	getPassword());
		assertThat(dbUser.getEmail()).isEqualTo(user.		getEmail());
		assertThat(dbUser.getAddress()).isEqualTo(user.		getAddress());
		assertThat(dbUser.getUserType()).isEqualTo(user.	getUserType());
		assertThat(dbUser.getPhone()).isEqualTo(user.		getPhone());
		assertThat(dbUser.getCity()).isEqualTo(user.		getCity());
		assertThat(dbUser.getCountry()).isEqualTo(user.		getCountry());
		assertThat(dbUser.getIsActive()).isEqualTo(user.	getIsActive());
		assertThat(dbUser.getActiveDate()).isEqualTo(user.	getActiveDate());
		assertThat(dbUser.getEntDate()).isEqualTo(user.	getEntDate());
		
		
	}
	public String getJson( Object object)
	{
		String json="";
		try
		{
		json= new ObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
