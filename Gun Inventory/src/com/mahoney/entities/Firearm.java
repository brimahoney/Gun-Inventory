package com.mahoney.entities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Firearm
{
	private String serialNumber;
	private String model;
	private String make;
	private String type;
	private String caliber;
	private Date datePurchased;
	private String notes;
	private List<Image> images;
	
	public Firearm(String serialNumber, String model, String make, String type, String caliber, Date datePurchased,
			String notes)
	{
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.make = make;
		this.type = type;
		this.caliber = caliber;
		this.datePurchased = datePurchased;
		this.notes = notes;
		this.images = new ArrayList<>();
	}
	
	public List<Image> getImages()
	{
		return images;
	}

	public void setImages(List<Image> images)
	{
		this.images = images;
	}
	
	public void addImage(Image anImage)
	{
		images.add(anImage);
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public void setMake(String make)
	{
		this.make = make;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getCaliber()
	{
		return caliber;
	}
	
	public void setCaliber(String caliber)
	{
		this.caliber = caliber;
	}
	
	public Date getDatePurchased()
	{
		return datePurchased;
	}
	
	public void setDatePurchased(Date datePurchased)
	{
		this.datePurchased = datePurchased;
	}
	
	public String getNotes()
	{
		return notes;
	}
	
	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	@Override
	public String toString()
	{
		return "Firearm [serialNumber=" + serialNumber + ", model=" + model + ", make=" + make + ", type=" + type
				+ ", caliber=" + caliber + ", datePurchased=" + datePurchased + "]";
	}
}


