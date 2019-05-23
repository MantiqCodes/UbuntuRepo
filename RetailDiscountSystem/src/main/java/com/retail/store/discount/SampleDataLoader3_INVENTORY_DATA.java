package com.retail.store.discount;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.retail.store.discount.model.RdsInventory;
import com.retail.store.discount.model.RdsItems;
import com.retail.store.discount.repo.RdsInventoryRepo;
import com.retail.store.discount.repo.RdsItemsRepo;

@Component
public class SampleDataLoader3_INVENTORY_DATA implements CommandLineRunner
{
	@Autowired
	RdsInventoryRepo	rdsInventroyRepo;
	@Autowired
	RdsItemsRepo		rdsItemsRepo;
	@Autowired
	Environment			env;

	@Override
	public void run(String... args) throws Exception
	{
		if (env.getProperty("data.load").equals("true"))
			doTest();

	}

	public void doTest()
	{

		System.out.println("*********************Loading INVENTORY DATA*******");
		List<RdsItems> rdsItemsList = rdsItemsRepo.findAll();

		for (RdsItems item : rdsItemsList)
		{
			RdsInventory inv = new RdsInventory();
			inv.setRdsItemsItem(item);
			long qty = ThreadLocalRandom.current().nextLong(30, 258);
			inv.setQtyOnHand(qty);
			inv.setQtyTotal(qty);
			inv.setQtySold(0);
			rdsInventroyRepo.save(inv);
		}

		System.out.println("*************FINISHED********Loading INVENTORY DATA*******");

	}
}
