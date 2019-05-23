package com.retail.store.discount;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.retail.store.discount.model.RdsItems;
import com.retail.store.discount.repo.RdsItemsRepo;
import com.retail.store.discount.util.ItemTypes;
@Component
public class SampleDataLoader2_ITEMS_DATA implements CommandLineRunner
{

	@Autowired
	RdsItemsRepo rdsItemsRepo;

	String	groceryItemNames[]		= { "Beans", "Chinese cabbage", "Broccoli", "Carrots", "Celery",
			"Collard greens", "Corn", "Cucumber", "Kale", "Lettuce", "Onions", "Peppers", "Potatoes", "Spinach",
			"Beef lean", "Chicken lean whole, parts or ground", "Eggs", "Fish - salmon ","Fish - tuna", "Nuts",
			 "Tofu ","Turkey lean whole", "Turkey parts", "soy hot dogs", "Veggie burgers", "Brown rice",
			"English muffins enriched", "Popcorn no added fat or salt", "Oatmeal", "Whole grain bread",
			"Whole-grain cereals ready to eat", "Whole-grain pasta", "Whole-wheat tortillas", "Whole-wheat pitas",
			" Apples", "Bananas", "Cherries", "Grapes", "Mangoes", "Melons", "Oranges", "Peaches", "Pears",
			"Pineapples", "Strawberries", "Tomatoes", "American cheese", "Butter or margarine", "Cheddar cheese",
			"Cottage cheese", "Cream cheese", "Milk", "Ricotta cheese", "Soy drink", "String cheese", "Yogurt", };
	String	nonGroceryItemNames[]	= { "Evaporative cooler", "Air conditioner", "Air ioniser", "Air purifier",
			"Appliance plug", "Aroma lamp", "Attic fan", "Bachelor griller", "Bed side lamp", "Back boiler",
			"Beverage opener", "Blender", "Box mangle", "Can opener", "Ceiling fan", "Central vacuum cleaner",
			"Clothes dryer", "Clothes iron", "Cold-pressed juicer", "Combo washer dryer",
			"Comparison of domestic robots", "Dish draining closet", "Dishwasher", "Drawer dishwasher",
			"Electric water boiler", "Exhaust hood", "Fan heater", "Flame supervision device", "Forced-air",
			"Futon dryer", "Garbage disposal unit", "Gas appliance", "Go-to-bed matchbox", "Hair dryer", "Hair iron",
			"Hob (hearth)", "Home server", "Humidifier", "HVAC", "Icebox", "Kimchi refrigerator", "Light fixture",
			"Light", "Mangle (machine)", "Micathermic heater", "Microwave oven", "Mobile charger", "Mousetrap",
			"Nightlight", "Oil heater", "Oven", "Patio heater", "Paper shredder", "Radiator (heating)", "Refrigerator",
			"Internet refrigerator", "Thermal mass refrigerator", "Sewing machine", "Space heater", "Steam mop",
			"Stove", "Sump pump", "Television", "Tie press", "Toaster and toaster ovens", "Trouser press",
			"Vacuum cleaner", "Manual vacuum cleaner", "Robotic vacuum cleaner", "Washing machine", "Water cooker",
			"Water purifier", "Water heater", "Solar water heater", "Window fan", "Waffle iron", };

	
	@Autowired
	Environment env;
	@Override
	public void run(String... args) throws Exception
	{
		if(env.getProperty("data.load").equals("true"))
			doTest();
		
	}
public void doTest()
{

	System.out.println("*********************Loading ITEMS DATA*******");

	RdsItems rdsItems 		;
	
	for (int i = 0; i < groceryItemNames.length; i++)

	{
		 rdsItems = new RdsItems();
		 
			rdsItems.setName(groceryItemNames[i]);
			rdsItems.setDescription(groceryItemNames[i]);
			rdsItems.setPrice(ThreadLocalRandom.current().nextDouble(2.0, 25.75));
			rdsItems.setCategory(ItemTypes.GROCERY.value());
			rdsItems.setUnitOfMeasure("Kg");
			rdsItemsRepo.save(rdsItems);
		} 
	for (int i = 0; i < nonGroceryItemNames.length; i++)

		{
		 rdsItems 		= new RdsItems();
		
			rdsItems.setName(nonGroceryItemNames[i]);
			rdsItems.setDescription(nonGroceryItemNames[i]);
			rdsItems.setPrice(ThreadLocalRandom.current().nextDouble(900.0, 3000.00));
			rdsItems.setCategory(ItemTypes.NON_GROCERY.value());
			rdsItems.setUnitOfMeasure("pc");

			rdsItemsRepo.save(rdsItems);
		}

	
	
}
}
