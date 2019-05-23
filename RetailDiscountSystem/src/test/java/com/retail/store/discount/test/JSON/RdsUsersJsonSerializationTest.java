package com.retail.store.discount.test.JSON;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.store.discount.model.RdsUsers;

@JsonTest
@RunWith(SpringRunner.class)

public class RdsUsersJsonSerializationTest
{

	@Autowired
	private JacksonTester<RdsUsers> jacksonTester;

	RdsUsers rdsUsers = new RdsUsers();

	public Date parseDate(String dateString)
	{
		try
		{
			return sdf.parse(dateString);
		} catch (ParseException e)
		{
			return new Date();
		}
	}

	private final String RDS_USERS_JSON = "{\n" + "	\"id\":1000,\n" + "	\"firstName\": \"Tim\",\n"
			+ "	\"lastName\": \"Schildt\",\n" + "	\"username\": \"Timb0099223344\",\n"
			+ "	\"password\": \"Schildt0099223344\",\n" + "	\"email\": \"Tim.0099223344@live.come\",\n"
			+ "	\"address\": \"Tim Schildt ,Amsterdam , Netherlands\",\n" + "	\"userType\": \"Customer\",\n"
			+ "	\"phone\": \"0099223344\",\n" + "	\"city\": \"Amsterdam\",\n" + "	\"country\": \"Netherlands\",\n"
			+ "	\"isActive\":\"1\",\n" + "	\"activeDate\": \"Sat, 31 Dec 2016 20:00:00 GMT\",\n"
			+ "	\"entDate\": \"Tue, 21 May 2019 03:19:42 GMT\"\n" + "}";

	SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");

	public String getDateString(Date date)
	{
		sdf.setTimeZone(TimeZone.getTimeZone("GST"));
		return sdf.format(date);
	}

	public RdsUsers getRdsUsers()
	{
		rdsUsers = new RdsUsers();
		rdsUsers.setFirstName("Tim");
		rdsUsers.setLastName("Schildt");
		rdsUsers.setUsername("Timb0099223344");
		rdsUsers.setPassword("Schildt0099223344");
		rdsUsers.setEmail("Tim.0099223344@live.come");
		rdsUsers.setAddress("Tim Schildt ,Amsterdam , Netherlands");
		rdsUsers.setUserType("Customer");
		rdsUsers.setPhone("0099223344");
		rdsUsers.setCity("Amsterdam");
		rdsUsers.setCountry("Netherlands");
		rdsUsers.setIsActive(1);
		rdsUsers.setActiveDate(parseDate("Sat, 31 Dec 2016 20:00:00 GMT"));
		rdsUsers.setEntDate(parseDate("Tue, 21 May 2019 03:19:42 GMT"));
		return rdsUsers;
	}

//@formatter:off
	@Test
	public void shouldSerializeFirstName() throws Exception
	{
		rdsUsers = getRdsUsers();
		 assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathNumberValue("@.id", rdsUsers.getId());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.firstName",	rdsUsers.getFirstName());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.lastName", rdsUsers.getLastName());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.username",rdsUsers.getUsername());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.password",rdsUsers.getPassword());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.email", rdsUsers.getEmail());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.address",rdsUsers.getAddress());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.userType",rdsUsers.getUserType());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.phone", rdsUsers.getPhone());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.city", rdsUsers.getCity());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.country",rdsUsers.getCountry());
		 assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathNumberValue("@.isActive", rdsUsers.getIsActive());
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.activeDate",getDateString(rdsUsers.getActiveDate()));
		assertThat(this.jacksonTester.write(rdsUsers)).extractingJsonPathStringValue("@.entDate",getDateString(rdsUsers.getEntDate()));
	}

	@Test
	public void shouldDeSerializeFirstName() throws Exception
	{
		rdsUsers = getRdsUsers();
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getFirstName()).isEqualTo(rdsUsers.getFirstName());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getLastName()).isEqualTo(	rdsUsers.getLastName());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getUsername()).isEqualTo( rdsUsers.getUsername());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getPassword()).isEqualTo( rdsUsers.getPassword());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getEmail()).isEqualTo( rdsUsers.getEmail());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getAddress()).isEqualTo( rdsUsers.getAddress());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getUserType()).isEqualTo(	rdsUsers.getUserType());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getPhone()).isEqualTo( rdsUsers.getPhone());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getCity()).isEqualTo( rdsUsers.getCity());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getCountry()).isEqualTo(rdsUsers.getCountry());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getIsActive()).isEqualTo( rdsUsers.getIsActive());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getActiveDate()).isEqualTo( rdsUsers.getActiveDate());
		assertThat(this.jacksonTester.parseObject(RDS_USERS_JSON).getEntDate()).isEqualTo( rdsUsers.getEntDate());
		
		
		
		
		}
	
	
}
