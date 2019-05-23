package com.retail.store.discount;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.retail.store.discount.model.RdsInvoice;
import com.retail.store.discount.model.RdsInvoiceItems;
import com.retail.store.discount.model.RdsItems;
import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.repo.RdsInvoiceItemsRepo;
import com.retail.store.discount.repo.RdsInvoiceRepo;
import com.retail.store.discount.repo.RdsItemsRepo;
import com.retail.store.discount.repo.RdsUsersRepo;
import com.retail.store.discount.util.DISCOUNT_BASE;
import com.retail.store.discount.util.ItemTypes;
import com.retail.store.discount.util.UserTypes;

@Component

public class SapmpleDataLoader4_INVOICE_DATA implements CommandLineRunner
{

	@Autowired
	RdsInvoiceItemsRepo	rdsInvoiceItemsRepo;
	@Autowired
	RdsItemsRepo		rdsItemsRepo;
	@Autowired
	RdsUsersRepo		rdsUsersRepo;
	@Autowired
	RdsInvoiceRepo		rdsInvoieRepo;
	@Autowired
	Environment			env;

	static long batchId = 1;

	final int	EMPLOYEE_DISCOUNT_PERCENTAGE					= 30;
	final int	AFFILIATE_DISCOUNT_PERCENTAGE					= 10;
	final int	CUSTOMER_SINCE_TWO_YEARS_DISCOUNT_PERCENTAGE	= 5;

	@Override
	public void run(String... args) throws Exception
	{
		if (env.getProperty("data.load").equals("true"))
			doTest();

	}

	public void doTest()
	{

		System.out.println("*********************Loading INVOICE DATA*******");

		// For each customer , add few items in thier invoice

		List<RdsUsers> usersList = rdsUsersRepo.findAll();
		List<RdsItems> itemList = rdsItemsRepo.findAll();

		// TODO: keep 10 customers in a batch // batch is to implement in invoicePosting
		RdsInvoice rdsInvoice = null;
		for (RdsUsers customer : usersList)
		{
			rdsInvoice = new RdsInvoice();

			int totalItemCount = ThreadLocalRandom.current().nextInt(2, 20);
			rdsInvoice.setEntryCount(totalItemCount);

			rdsInvoice.setRdsUsersCustomer(customer);
			rdsInvoice.setDiscountBase(getDiscountBase(customer));

			// save invoice so that invoice-id is available
			rdsInvoice = this.rdsInvoieRepo.save(rdsInvoice);
			double docPriceTotal = 0.0;
			// for each customer there will be upto 20 items
			// for (int i = 0; i < totalItemCount; i++)
			for (int i = 0; i <totalItemCount; i++)
			{
				RdsInvoiceItems rdsInvoiceItem = new RdsInvoiceItems();
				double qty = ThreadLocalRandom.current().nextDouble(0.2, 4.7);

				int itemIndex = ThreadLocalRandom.current().nextInt(0, itemList.size() - 1);
				RdsItems item = itemList.get(itemIndex);
				rdsInvoiceItem.setRdsItemsItem(item);

				double itemQtyPrice = 0.0;
				if (item.getCategory().equals(ItemTypes.GROCERY.value()))
					rdsInvoiceItem.setQty(qty);
				else
					qty = ThreadLocalRandom.current().nextInt(1, 3);

				itemQtyPrice = item.getPrice() * qty;
				docPriceTotal += itemQtyPrice;
				rdsInvoiceItem.setQty(qty);
				rdsInvoiceItem.setRate(item.getPrice());
				rdsInvoiceItem.setItemTotal(itemQtyPrice);
				// invoice number to invoiceItem
				rdsInvoiceItem.setRdsInvoiceInvoice(rdsInvoice);
				rdsInvoiceItem = rdsInvoiceItemsRepo.save(rdsInvoiceItem);

			}
			rdsInvoice.setDocPrice(docPriceTotal);
			rdsInvoice.setDocDate(new Date());
			// calculate discount
			long daysInTwoYears = 365 * 2;
			Date now = new Date();
			long diffMillis = now.getTime() - customer.getActiveDate().getTime();
			long diffDays = diffMillis / (1000 * 60 * 60 * 24);
			if (UserTypes.EMPLOYEE.value().equals(customer.getUserType()))
			{
				double docDiscount = docPriceTotal * 30 / 100;
				rdsInvoice.setDiscountBase(getDiscountBase(customer));

				rdsInvoice.setDocDiscount(docDiscount);
				rdsInvoice.setDocPriceAfterDiscount(docPriceTotal - docDiscount);
			} else if (UserTypes.AFFILIATE.value().equals(customer.getUserType()))
			{
				double docDiscount = docPriceTotal * 10 / 100;
				rdsInvoice.setDiscountBase(getDiscountBase(customer));
				rdsInvoice.setDocDiscount(docDiscount);
				rdsInvoice.setDocPriceAfterDiscount(docPriceTotal - docDiscount);

			} else if (UserTypes.CUSTOMER.value().equals(customer.getUserType()))
			{

				if (diffDays >= daysInTwoYears || docPriceTotal > 100)
				{
					double docDiscount = docPriceTotal * 5 / 100;
					rdsInvoice.setDiscountBase(getDiscountBase(customer));
					rdsInvoice.setDocDiscount(docDiscount);
					rdsInvoice.setDocPriceAfterDiscount(docPriceTotal - docDiscount);

				}

			}
			rdsInvoice = this.rdsInvoieRepo.save(rdsInvoice);
		}

	}

	public String getDiscountBase(RdsUsers rdsUsers)
	{
		if (rdsUsers.getUserType().equals(UserTypes.CUSTOMER.value()))
			return DISCOUNT_BASE.CUSTOMER_BASED_DISCOUNT.value();
		if (rdsUsers.getUserType().equals(UserTypes.EMPLOYEE.value()))
			return DISCOUNT_BASE.EMPLOYEE_BASED_DISCOUNT.value();
		if (rdsUsers.getUserType().equals(UserTypes.AFFILIATE.value()))
			return DISCOUNT_BASE.AFFILIATE_BASED_DISCOUNT.value();
		return DISCOUNT_BASE.NO_DISCOUNT_APPLIED.value();
	}
}
