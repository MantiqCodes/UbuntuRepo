package com.retail.store.discount.dto;

import com.retail.store.discount.model.RdsInvoice;
import com.retail.store.discount.dto.RdsItemsDTO;
import com.retail.store.discount.model.RdsInvoiceItems;
import com.retail.store.discount.util.EntityWrapper;
import com.retail.store.discount.dto.RdsInvoiceDTO;
import java.util.ArrayList;
import com.retail.store.discount.model.RdsItems;
import java.util.List;
import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.dto.RdsUsersDTO;
import com.retail.store.discount.dto.RdsInvoiceItemsDTO;
import com.retail.store.discount.dto.RdsInventoryDTO;
import java.util.Iterator;
import com.retail.store.discount.model.RdsInventory;

public class DTOConverter

{

	public RdsUsersDTO getRdsUsersDTO(RdsUsers rdsUsers)

	{

		RdsUsersDTO rdsUsersDTO = null;
		if (rdsUsers != null)
		{
			rdsUsersDTO = new RdsUsersDTO();

			rdsUsersDTO.setId(rdsUsers.getId());

			rdsUsersDTO.setFirstName(rdsUsers.getFirstName());

			rdsUsersDTO.setLastName(rdsUsers.getLastName());

			rdsUsersDTO.setUsername(rdsUsers.getUsername());

			rdsUsersDTO.setPassword(rdsUsers.getPassword());

			rdsUsersDTO.setEmail(rdsUsers.getEmail());

			rdsUsersDTO.setAddress(rdsUsers.getAddress());

			rdsUsersDTO.setUserType(rdsUsers.getUserType());

			rdsUsersDTO.setPhone(rdsUsers.getPhone());

			rdsUsersDTO.setCity(rdsUsers.getCity());

			rdsUsersDTO.setCountry(rdsUsers.getCountry());

			rdsUsersDTO.setIsActive(rdsUsers.getIsActive());

			rdsUsersDTO.setActiveDate(rdsUsers.getActiveDate());

			rdsUsersDTO.setEntDate(rdsUsers.getEntDate());

		}
		return rdsUsersDTO;

	}

	public RdsUsers getRdsUsers(RdsUsersDTO rdsUsersDTO)

	{

		RdsUsers rdsUsers = null;
		if (rdsUsersDTO != null)
		{
			rdsUsers = new RdsUsers();

			rdsUsers.setId(rdsUsersDTO.getId());

			rdsUsers.setFirstName(rdsUsersDTO.getFirstName());

			rdsUsers.setLastName(rdsUsersDTO.getLastName());

			rdsUsers.setUsername(rdsUsersDTO.getUsername());

			rdsUsers.setPassword(rdsUsersDTO.getPassword());

			rdsUsers.setEmail(rdsUsersDTO.getEmail());

			rdsUsers.setAddress(rdsUsersDTO.getAddress());

			rdsUsers.setUserType(rdsUsersDTO.getUserType());

			rdsUsers.setPhone(rdsUsersDTO.getPhone());

			rdsUsers.setCity(rdsUsersDTO.getCity());

			rdsUsers.setCountry(rdsUsersDTO.getCountry());

			rdsUsers.setIsActive(rdsUsersDTO.getIsActive());

			rdsUsers.setActiveDate(rdsUsersDTO.getActiveDate());

			rdsUsers.setEntDate(rdsUsersDTO.getEntDate());

		}
		return rdsUsers;

	}

	public EntityWrapper<RdsUsersDTO> getRdsUsersDTOEntityWrapper(EntityWrapper<RdsUsers> rdsUsersEntityWrapper)
	{

		EntityWrapper<RdsUsersDTO> dTOEntityWrapper = new EntityWrapper<RdsUsersDTO>();
		dTOEntityWrapper.setT(this.getRdsUsersDTO(rdsUsersEntityWrapper.getT()));
		String message = rdsUsersEntityWrapper.getMessage();
		message.replace("rdsUsers.", "rdsUsersDTO.");
		dTOEntityWrapper.setMessage(message);
		dTOEntityWrapper.setHttpStatus(rdsUsersEntityWrapper.getHttpStatus());
		return dTOEntityWrapper;
	}

	public List<RdsUsersDTO> getRdsUsersDTOList(List<RdsUsers> rdsUsersList)
	{

		List<RdsUsersDTO> rdsUsersDTOList = new ArrayList<RdsUsersDTO>();
		for (RdsUsers rdsUsers : rdsUsersList)
		{
			RdsUsersDTO rdsUsersDTO = this.getRdsUsersDTO(rdsUsers);
			rdsUsersDTOList.add(rdsUsersDTO);
		}
		return rdsUsersDTOList;
	}

	public List<RdsUsers> getRdsUsersList(List<RdsUsersDTO> rdsUsersDTOList)
	{

		List<RdsUsers> rdsUsersList = new ArrayList<RdsUsers>();
		for (RdsUsersDTO rdsUsersDTO : rdsUsersDTOList)
		{
			RdsUsers rdsUsers = this.getRdsUsers(rdsUsersDTO);
			rdsUsersList.add(rdsUsers);
		}
		return rdsUsersList;
	}

	public List<Object[]> getObjectListWithRdsUsersDTO(List<Object[]> resultList)
	{

		List<Object[]> newResultList = new ArrayList<Object[]>();
		for (Iterator<Object[]> it = resultList.iterator(); it.hasNext();)
		{
			Object[] objArrayRow = it.next();
			Object[] objectDTOListRow = new Object[resultList.size()];
			int i = 0;
			for (Object obj : objArrayRow)
			{
				if (obj instanceof RdsUsers)
				{
					RdsUsers rdsUsers = (RdsUsers) obj;
					RdsUsersDTO rdsUsersDTO = this.getRdsUsersDTO(rdsUsers);
					objectDTOListRow[i] = rdsUsersDTO;
				} else

					objectDTOListRow[i] = obj;
			}
			newResultList.add(objectDTOListRow);
		}
		return newResultList;
	}

	public RdsItemsDTO getRdsItemsDTO(RdsItems rdsItems)

	{

		RdsItemsDTO rdsItemsDTO = null;
		if (rdsItems != null)
		{
			rdsItemsDTO = new RdsItemsDTO();

			rdsItemsDTO.setId(rdsItems.getId());

			rdsItemsDTO.setName(rdsItems.getName());

			rdsItemsDTO.setDescription(rdsItems.getDescription());

			rdsItemsDTO.setPrice(rdsItems.getPrice());

			rdsItemsDTO.setCategory(rdsItems.getCategory());

			rdsItemsDTO.setUnitOfMeasure(rdsItems.getUnitOfMeasure());

		}
		return rdsItemsDTO;

	}

	public RdsItems getRdsItems(RdsItemsDTO rdsItemsDTO)

	{

		RdsItems rdsItems = null;
		if (rdsItemsDTO != null)
		{
			rdsItems = new RdsItems();

			rdsItems.setId(rdsItemsDTO.getId());

			rdsItems.setName(rdsItemsDTO.getName());

			rdsItems.setDescription(rdsItemsDTO.getDescription());

			rdsItems.setPrice(rdsItemsDTO.getPrice());

			rdsItems.setCategory(rdsItemsDTO.getCategory());

			rdsItems.setUnitOfMeasure(rdsItemsDTO.getUnitOfMeasure());

		}
		return rdsItems;

	}

	public EntityWrapper<RdsItemsDTO> getRdsItemsDTOEntityWrapper(EntityWrapper<RdsItems> rdsItemsEntityWrapper)
	{

		EntityWrapper<RdsItemsDTO> dTOEntityWrapper = new EntityWrapper<RdsItemsDTO>();
		dTOEntityWrapper.setT(this.getRdsItemsDTO(rdsItemsEntityWrapper.getT()));
		String message = rdsItemsEntityWrapper.getMessage();
		message.replace("rdsItems.", "rdsItemsDTO.");
		dTOEntityWrapper.setMessage(message);
		dTOEntityWrapper.setHttpStatus(rdsItemsEntityWrapper.getHttpStatus());
		return dTOEntityWrapper;
	}

	public List<RdsItemsDTO> getRdsItemsDTOList(List<RdsItems> rdsItemsList)
	{

		List<RdsItemsDTO> rdsItemsDTOList = new ArrayList<RdsItemsDTO>();
		for (RdsItems rdsItems : rdsItemsList)
		{
			RdsItemsDTO rdsItemsDTO = this.getRdsItemsDTO(rdsItems);
			rdsItemsDTOList.add(rdsItemsDTO);
		}
		return rdsItemsDTOList;
	}

	public List<RdsItems> getRdsItemsList(List<RdsItemsDTO> rdsItemsDTOList)
	{

		List<RdsItems> rdsItemsList = new ArrayList<RdsItems>();
		for (RdsItemsDTO rdsItemsDTO : rdsItemsDTOList)
		{
			RdsItems rdsItems = this.getRdsItems(rdsItemsDTO);
			rdsItemsList.add(rdsItems);
		}
		return rdsItemsList;
	}

	public List<Object[]> getObjectListWithRdsItemsDTO(List<Object[]> resultList)
	{

		List<Object[]> newResultList = new ArrayList<Object[]>();
		for (Iterator<Object[]> it = resultList.iterator(); it.hasNext();)
		{
			Object[] objArrayRow = it.next();
			Object[] objectDTOListRow = new Object[resultList.size()];
			int i = 0;
			for (Object obj : objArrayRow)
			{
				if (obj instanceof RdsItems)
				{
					RdsItems rdsItems = (RdsItems) obj;
					RdsItemsDTO rdsItemsDTO = this.getRdsItemsDTO(rdsItems);
					objectDTOListRow[i] = rdsItemsDTO;
				} else

					objectDTOListRow[i] = obj;
			}
			newResultList.add(objectDTOListRow);
		}
		return newResultList;
	}

	public RdsInventoryDTO getRdsInventoryDTO(RdsInventory rdsInventory)

	{

		RdsInventoryDTO rdsInventoryDTO = null;
		if (rdsInventory != null)
		{
			rdsInventoryDTO = new RdsInventoryDTO();

			rdsInventoryDTO.setId(rdsInventory.getId());

			rdsInventoryDTO.setRdsItemsItemDTO(this.getRdsItemsDTO(rdsInventory.getRdsItemsItem()));

			rdsInventoryDTO.setQtyOnHand(rdsInventory.getQtyOnHand());

			rdsInventoryDTO.setQtySold(rdsInventory.getQtySold());

			rdsInventoryDTO.setQtyTotal(rdsInventory.getQtyTotal());

			rdsInventoryDTO.setEntDate(rdsInventory.getEntDate());

		}
		return rdsInventoryDTO;

	}

	public RdsInventory getRdsInventory(RdsInventoryDTO rdsInventoryDTO)

	{

		RdsInventory rdsInventory = null;
		if (rdsInventoryDTO != null)
		{
			rdsInventory = new RdsInventory();

			rdsInventory.setId(rdsInventoryDTO.getId());

			rdsInventory.setRdsItemsItem(this.getRdsItems(rdsInventoryDTO.getRdsItemsItemDTO()));

			rdsInventory.setQtyOnHand(rdsInventoryDTO.getQtyOnHand());

			rdsInventory.setQtySold(rdsInventoryDTO.getQtySold());

			rdsInventory.setQtyTotal(rdsInventoryDTO.getQtyTotal());

			rdsInventory.setEntDate(rdsInventoryDTO.getEntDate());

		}
		return rdsInventory;

	}

	public EntityWrapper<RdsInventoryDTO> getRdsInventoryDTOEntityWrapper(
			EntityWrapper<RdsInventory> rdsInventoryEntityWrapper)
	{

		EntityWrapper<RdsInventoryDTO> dTOEntityWrapper = new EntityWrapper<RdsInventoryDTO>();
		dTOEntityWrapper.setT(this.getRdsInventoryDTO(rdsInventoryEntityWrapper.getT()));
		String message = rdsInventoryEntityWrapper.getMessage();
		message.replace("rdsInventory.", "rdsInventoryDTO.");
		dTOEntityWrapper.setMessage(message);
		dTOEntityWrapper.setHttpStatus(rdsInventoryEntityWrapper.getHttpStatus());
		return dTOEntityWrapper;
	}

	public List<RdsInventoryDTO> getRdsInventoryDTOList(List<RdsInventory> rdsInventoryList)
	{

		List<RdsInventoryDTO> rdsInventoryDTOList = new ArrayList<RdsInventoryDTO>();
		for (RdsInventory rdsInventory : rdsInventoryList)
		{
			RdsInventoryDTO rdsInventoryDTO = this.getRdsInventoryDTO(rdsInventory);
			rdsInventoryDTOList.add(rdsInventoryDTO);
		}
		return rdsInventoryDTOList;
	}

	public List<RdsInventory> getRdsInventoryList(List<RdsInventoryDTO> rdsInventoryDTOList)
	{

		List<RdsInventory> rdsInventoryList = new ArrayList<RdsInventory>();
		for (RdsInventoryDTO rdsInventoryDTO : rdsInventoryDTOList)
		{
			RdsInventory rdsInventory = this.getRdsInventory(rdsInventoryDTO);
			rdsInventoryList.add(rdsInventory);
		}
		return rdsInventoryList;
	}

	public List<Object[]> getObjectListWithRdsInventoryDTO(List<Object[]> resultList)
	{

		List<Object[]> newResultList = new ArrayList<Object[]>();
		for (Iterator<Object[]> it = resultList.iterator(); it.hasNext();)
		{
			Object[] objArrayRow = it.next();
			Object[] objectDTOListRow = new Object[resultList.size()];
			int i = 0;
			for (Object obj : objArrayRow)
			{
				if (obj instanceof RdsInventory)
				{
					RdsInventory rdsInventory = (RdsInventory) obj;
					RdsInventoryDTO rdsInventoryDTO = this.getRdsInventoryDTO(rdsInventory);
					objectDTOListRow[i] = rdsInventoryDTO;
				} else

					objectDTOListRow[i] = obj;
			}
			newResultList.add(objectDTOListRow);
		}
		return newResultList;
	}

	public RdsInvoiceItemsDTO getRdsInvoiceItemsDTO(RdsInvoiceItems rdsInvoiceItems)

	{

		RdsInvoiceItemsDTO rdsInvoiceItemsDTO = null;
		if (rdsInvoiceItems != null)
		{
			rdsInvoiceItemsDTO = new RdsInvoiceItemsDTO();

			rdsInvoiceItemsDTO.setId(rdsInvoiceItems.getId());

			rdsInvoiceItemsDTO.setRdsItemsItemDTO(this.getRdsItemsDTO(rdsInvoiceItems.getRdsItemsItem()));

			rdsInvoiceItemsDTO.setRdsInvoiceInvoiceDTO(this.getRdsInvoiceDTO(rdsInvoiceItems.getRdsInvoiceInvoice()));

			rdsInvoiceItemsDTO.setQty(rdsInvoiceItems.getQty());

			rdsInvoiceItemsDTO.setRate(rdsInvoiceItems.getRate());

			rdsInvoiceItemsDTO.setItemTotal(rdsInvoiceItems.getItemTotal());

		}
		return rdsInvoiceItemsDTO;

	}

	public RdsInvoiceItems getRdsInvoiceItems(RdsInvoiceItemsDTO rdsInvoiceItemsDTO)

	{

		RdsInvoiceItems rdsInvoiceItems = null;
		if (rdsInvoiceItemsDTO != null)
		{
			rdsInvoiceItems = new RdsInvoiceItems();

			rdsInvoiceItems.setId(rdsInvoiceItemsDTO.getId());

			rdsInvoiceItems.setRdsItemsItem(this.getRdsItems(rdsInvoiceItemsDTO.getRdsItemsItemDTO()));

			rdsInvoiceItems.setRdsInvoiceInvoice(this.getRdsInvoice(rdsInvoiceItemsDTO.getRdsInvoiceInvoiceDTO()));

			rdsInvoiceItems.setQty(rdsInvoiceItemsDTO.getQty());

			rdsInvoiceItems.setRate(rdsInvoiceItemsDTO.getRate());

			rdsInvoiceItems.setItemTotal(rdsInvoiceItemsDTO.getItemTotal());

		}
		return rdsInvoiceItems;

	}

	public EntityWrapper<RdsInvoiceItemsDTO> getRdsInvoiceItemsDTOEntityWrapper(
			EntityWrapper<RdsInvoiceItems> rdsInvoiceItemsEntityWrapper)
	{

		EntityWrapper<RdsInvoiceItemsDTO> dTOEntityWrapper = new EntityWrapper<RdsInvoiceItemsDTO>();
		dTOEntityWrapper.setT(this.getRdsInvoiceItemsDTO(rdsInvoiceItemsEntityWrapper.getT()));
		String message = rdsInvoiceItemsEntityWrapper.getMessage();
		message.replace("rdsInvoiceItems.", "rdsInvoiceItemsDTO.");
		dTOEntityWrapper.setMessage(message);
		dTOEntityWrapper.setHttpStatus(rdsInvoiceItemsEntityWrapper.getHttpStatus());
		return dTOEntityWrapper;
	}

	public List<RdsInvoiceItemsDTO> getRdsInvoiceItemsDTOList(List<RdsInvoiceItems> rdsInvoiceItemsList)
	{

		List<RdsInvoiceItemsDTO> rdsInvoiceItemsDTOList = new ArrayList<RdsInvoiceItemsDTO>();
		for (RdsInvoiceItems rdsInvoiceItems : rdsInvoiceItemsList)
		{
			RdsInvoiceItemsDTO rdsInvoiceItemsDTO = this.getRdsInvoiceItemsDTO(rdsInvoiceItems);
			rdsInvoiceItemsDTOList.add(rdsInvoiceItemsDTO);
		}
		return rdsInvoiceItemsDTOList;
	}

	public List<RdsInvoiceItems> getRdsInvoiceItemsList(List<RdsInvoiceItemsDTO> rdsInvoiceItemsDTOList)
	{

		List<RdsInvoiceItems> rdsInvoiceItemsList = new ArrayList<RdsInvoiceItems>();
		for (RdsInvoiceItemsDTO rdsInvoiceItemsDTO : rdsInvoiceItemsDTOList)
		{
			RdsInvoiceItems rdsInvoiceItems = this.getRdsInvoiceItems(rdsInvoiceItemsDTO);
			rdsInvoiceItemsList.add(rdsInvoiceItems);
		}
		return rdsInvoiceItemsList;
	}

	public List<Object[]> getObjectListWithRdsInvoiceItemsDTO(List<Object[]> resultList)
	{

		List<Object[]> newResultList = new ArrayList<Object[]>();
		for (Iterator<Object[]> it = resultList.iterator(); it.hasNext();)
		{
			Object[] objArrayRow = it.next();
			Object[] objectDTOListRow = new Object[resultList.size()];
			int i = 0;
			for (Object obj : objArrayRow)
			{
				if (obj instanceof RdsInvoiceItems)
				{
					RdsInvoiceItems rdsInvoiceItems = (RdsInvoiceItems) obj;
					RdsInvoiceItemsDTO rdsInvoiceItemsDTO = this.getRdsInvoiceItemsDTO(rdsInvoiceItems);
					objectDTOListRow[i] = rdsInvoiceItemsDTO;
				} else

					objectDTOListRow[i] = obj;
			}
			newResultList.add(objectDTOListRow);
		}
		return newResultList;
	}

	public RdsInvoiceDTO getRdsInvoiceDTO(RdsInvoice rdsInvoice)

	{

		RdsInvoiceDTO rdsInvoiceDTO = null;
		if (rdsInvoice != null)
		{
			rdsInvoiceDTO = new RdsInvoiceDTO();

			rdsInvoiceDTO.setId(rdsInvoice.getId());

			rdsInvoiceDTO.setEntryCount(rdsInvoice.getEntryCount());

			rdsInvoiceDTO.setDocPrice(rdsInvoice.getDocPrice());

			rdsInvoiceDTO.setDocPriceAfterDiscount(rdsInvoice.getDocPriceAfterDiscount());

			rdsInvoiceDTO.setDocDiscount(rdsInvoice.getDocDiscount());

			rdsInvoiceDTO.setDiscountBase(rdsInvoice.getDiscountBase());

			rdsInvoiceDTO.setRdsUsersCustomerDTO(this.getRdsUsersDTO(rdsInvoice.getRdsUsersCustomer()));

			rdsInvoiceDTO.setDocDate(rdsInvoice.getDocDate());

		}
		return rdsInvoiceDTO;

	}

	public RdsInvoice getRdsInvoice(RdsInvoiceDTO rdsInvoiceDTO)

	{

		RdsInvoice rdsInvoice = null;
		if (rdsInvoiceDTO != null)
		{
			rdsInvoice = new RdsInvoice();

			rdsInvoice.setId(rdsInvoiceDTO.getId());

			rdsInvoice.setEntryCount(rdsInvoiceDTO.getEntryCount());

			rdsInvoice.setDocPrice(rdsInvoiceDTO.getDocPrice());

			rdsInvoice.setDocPriceAfterDiscount(rdsInvoiceDTO.getDocPriceAfterDiscount());

			rdsInvoice.setDocDiscount(rdsInvoiceDTO.getDocDiscount());

			rdsInvoice.setDiscountBase(rdsInvoiceDTO.getDiscountBase());

			rdsInvoice.setRdsUsersCustomer(this.getRdsUsers(rdsInvoiceDTO.getRdsUsersCustomerDTO()));

			rdsInvoice.setDocDate(rdsInvoiceDTO.getDocDate());

		}
		return rdsInvoice;

	}

	public EntityWrapper<RdsInvoiceDTO> getRdsInvoiceDTOEntityWrapper(EntityWrapper<RdsInvoice> rdsInvoiceEntityWrapper)
	{

		EntityWrapper<RdsInvoiceDTO> dTOEntityWrapper = new EntityWrapper<RdsInvoiceDTO>();
		dTOEntityWrapper.setT(this.getRdsInvoiceDTO(rdsInvoiceEntityWrapper.getT()));
		String message = rdsInvoiceEntityWrapper.getMessage();
		message.replace("rdsInvoice.", "rdsInvoiceDTO.");
		dTOEntityWrapper.setMessage(message);
		dTOEntityWrapper.setHttpStatus(rdsInvoiceEntityWrapper.getHttpStatus());
		return dTOEntityWrapper;
	}

	public List<RdsInvoiceDTO> getRdsInvoiceDTOList(List<RdsInvoice> rdsInvoiceList)
	{

		List<RdsInvoiceDTO> rdsInvoiceDTOList = new ArrayList<RdsInvoiceDTO>();
		for (RdsInvoice rdsInvoice : rdsInvoiceList)
		{
			RdsInvoiceDTO rdsInvoiceDTO = this.getRdsInvoiceDTO(rdsInvoice);
			rdsInvoiceDTOList.add(rdsInvoiceDTO);
		}
		return rdsInvoiceDTOList;
	}

	public List<RdsInvoice> getRdsInvoiceList(List<RdsInvoiceDTO> rdsInvoiceDTOList)
	{

		List<RdsInvoice> rdsInvoiceList = new ArrayList<RdsInvoice>();
		for (RdsInvoiceDTO rdsInvoiceDTO : rdsInvoiceDTOList)
		{
			RdsInvoice rdsInvoice = this.getRdsInvoice(rdsInvoiceDTO);
			rdsInvoiceList.add(rdsInvoice);
		}
		return rdsInvoiceList;
	}

	public List<Object[]> getObjectListWithRdsInvoiceDTO(List<Object[]> resultList)
	{

		List<Object[]> newResultList = new ArrayList<Object[]>();
		for (Iterator<Object[]> it = resultList.iterator(); it.hasNext();)
		{
			Object[] objArrayRow = it.next();
			Object[] objectDTOListRow = new Object[resultList.size()];
			int i = 0;
			for (Object obj : objArrayRow)
			{
				if (obj instanceof RdsInvoice)
				{
					RdsInvoice rdsInvoice = (RdsInvoice) obj;
					RdsInvoiceDTO rdsInvoiceDTO = this.getRdsInvoiceDTO(rdsInvoice);
					objectDTOListRow[i] = rdsInvoiceDTO;
				} else

					objectDTOListRow[i] = obj;
			}
			newResultList.add(objectDTOListRow);
		}
		return newResultList;
	}
}
