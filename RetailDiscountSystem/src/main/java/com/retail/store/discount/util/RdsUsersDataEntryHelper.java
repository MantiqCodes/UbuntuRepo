package com.retail.store.discount.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RdsUsersDataEntryHelper
{
	public String uuid;

	public RdsUsersDataEntryHelper()
	{
		this.uuid = UUID.randomUUID().toString();
	}

	public String[]	firstNameList	= { "Tom", "Max", "Anna", "Hanna", "Mike", "Duke", "Fred", "Tim", "Paul", "Luke",
			"Tobias", "Timi", "Michelle", "Thomas", "Andrew" };
	public String[]	lastNameList	= { "Smith", "Taylor", "Williams", "Hammer", "Lewis", "Jones", "Evans", "Harris",
			"Mayer", "Schildt" };
	public String[]	cityList		= { "Tirana", "Andorra la Vella", "Yerevan", "Vienna", "Baku", "Minsk", "Brussels",
			"Sarajevo", "Sofia", "Zagreb", "Nicosia", "Prague", "Copenhagen", "Tallinn", "Helsinki", "Paris", "Tbilisi",
			"Berlin", "Athens", "Budapest", "Reykjavík", "Dublin", "Rome", "Astana", "Riga", "Vaduz", "Vilnius",
			"Luxembourg", "kopje", "Valletta", "Chi?inau", "Monaco", "Podgorica", "Amsterdam", "Oslo", "Warsaw",
			"Lisbon", "Bucharest", "Moscow", "San Marino", "Belgrade", "Bratislava", "Ljubljana", "Madrid", "Stockholm",
			"Bern", "Ankara", "Kiev", "London", "Vatican City" };

	public String[]	countryList		= {

			"Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium", "Bosnia and Herzegovina",
			"Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Georgia",
			"Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Latvia", "Liechtenstein",
			"Lithuania", "Luxembourg", "Macedonia", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "Norway",
			"Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain",
			"Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom", "Vatican City"

	};
	public String[]	emailDomainList	= { "@gmail.com", "@yahoo.com", "@hotmail.com", "@live.come",
			"@retailDiscount.com" };

	public String getNextFirstName()
	{
		int findex = ThreadLocalRandom.current().nextInt(0, firstNameList.length);

		return firstNameList[findex];
	}

	public String getNextLastName()
	{
		int lindex = ThreadLocalRandom.current().nextInt(0, lastNameList.length);

		return lastNameList[lindex];
	}

	public String getNextCityName(int cntryIndex)
	{

		return cityList[cntryIndex];
	}

	public String getNextCountryName(int cntryIndex)
	{

		return countryList[cntryIndex];
	}

	public String getNextEmail(String firstName)
	{
		String email = firstName + "." + uuid
				+ emailDomainList[ThreadLocalRandom.current().nextInt(0, emailDomainList.length)];
		return email;
	}

	public String getNewUuId()
	{
		return this.uuid = UUID.randomUUID().toString();
	}
}
