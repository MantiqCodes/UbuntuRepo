package com.retail.store.discount;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.repo.RdsUsersRepo;
import com.retail.store.discount.util.RdsUsersDataEntryHelper;
import com.retail.store.discount.util.UserTypes;

@Component
public class SampleDataLoader1_UsersDATA implements CommandLineRunner
{
	@Autowired
	Environment				env;
	@Autowired
	private RdsUsersRepo	rdsUsersRepository;
	int						oldCustomerCount	= 0;
	int						employeeCount		= 0;
	int						affiliateCount		= 0;
	int						totalCustomerCount	= 100;

	@Override
	public void run(String... args) throws Exception
	{
		long totalData = 0;
		
		this.loadUserData();
	}

	void loadUserData()
	{

		System.out.println("*********************Loading USERS DATA*******");

		RdsUsersDataEntryHelper dataEntryHelper = new RdsUsersDataEntryHelper();

		LocalDate initDate = LocalDate.of(2017, 01, 01);
		for (int i = 0; i < totalCustomerCount; i++)
		{
			RdsUsers p = new RdsUsers();
			int cntryIndex = ThreadLocalRandom.current().nextInt(0, dataEntryHelper.cityList.length);
			String firstName = dataEntryHelper.getNextFirstName();
			String lastName = dataEntryHelper.getNextLastName();
			String cityName = dataEntryHelper.getNextCityName(cntryIndex);
			String countryName = dataEntryHelper.getNextCountryName(cntryIndex);
			String email = dataEntryHelper.getNextEmail(firstName);
			String userName = firstName + dataEntryHelper.getNewUuId();
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setCity(cityName);
			p.setCountry(countryName);
			// Max 50% customers are over 2 years old

			int oldCustomerRandom = ThreadLocalRandom.current().nextInt(0, totalCustomerCount);
			int employeeRandom = ThreadLocalRandom.current().nextInt(0, totalCustomerCount);
			int affiliateRandom = ThreadLocalRandom.current().nextInt(0, totalCustomerCount);

			if (oldCustomerRandom < (totalCustomerCount / 100) * 20
					&& oldCustomerCount < (totalCustomerCount / 100) * 20)
			{
				initDate = LocalDate.of(2017, 01, 01);
				oldCustomerCount++;
			} else
				initDate = LocalDate.of(2018, 06, 06);

			p.setActiveDate(java.sql.Date.valueOf(initDate));
			// Max 20% of the users are staff

			if (employeeRandom < (totalCustomerCount / 100) * 20 && employeeCount < (totalCustomerCount / 100) * 20)
			{
				p.setUserType(UserTypes.EMPLOYEE.value());
				employeeCount++;

			}
			// Max 20% of the users are affiliate members
			else if (affiliateRandom < (totalCustomerCount / 100) * 20
					&& affiliateCount < (totalCustomerCount / 100) * 20)
			{
				p.setUserType(UserTypes.AFFILIATE.value());
				affiliateCount++;

			} else
				p.setUserType(UserTypes.CUSTOMER.value());

			p.setEmail(email);
			p.setIsActive(1);
			p.setUsername(userName);
			p.setPassword(lastName);
			p.setAddress(firstName + " " + lastName + " \t " + cityName + " , " + countryName);
			p.setEntDate(new Date());
			p.setPhone(dataEntryHelper.getNewUuId());
			rdsUsersRepository.save(p);

		}

		System.out.println("...Finished loading " + totalCustomerCount + " entities");

	}

}
