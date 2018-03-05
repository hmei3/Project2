package com.hmei.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Specification {

	
	private String ramSize;
	private String processorSeries;
	private String processorManufacturer;
	private String processorCount;
	private String processorSpeed;
	private String displayResolutionMaximum;
	private String screenSize;
	private String graphicsCoprocessor;
	private String graphicsDescription;
	private String hardDiskDescription;
	private String hardDiskSize;
	private String itemDimensions;
	private String itemWeight;
	private String operatingSystem;
	private String wirelessCompatibility;
	
	
	
	
	public Specification() {
		this.ramSize = "—";
		this.processorSeries = "—";
		this.processorManufacturer = "—";
		this.processorCount = "—";
		this.processorSpeed = "—";
		this.displayResolutionMaximum = "—";
		this.screenSize = "—";
		this.graphicsCoprocessor = "—";
		this.graphicsDescription = "—";
		this.hardDiskDescription = "—";
		this.hardDiskSize = "—";
		this.itemDimensions = "—";
		this.itemWeight = "—";
		this.operatingSystem = "—";
		this.wirelessCompatibility = "—";
	}

	public Specification(
			String ramSize, 
			String processorSeries, 
			String processorManufacturer, 
			String processorCount,
			String processorSpeed, 
			String displayResolutionMaximum, 
			String screenSize, 
			String graphicsCoprocessor,
			String graphicsDescription, 
			String hardDiskDescription, 
			String hardDiskSize, 
			String itemDimensions,
			String itemWeight, 
			String operatingSystem, 
			String wirelessCompatibility) {
		this.ramSize = ramSize;
		this.processorSeries = processorSeries;
		this.processorManufacturer = processorManufacturer;
		this.processorCount = processorCount;
		this.processorSpeed = processorSpeed;
		this.displayResolutionMaximum = displayResolutionMaximum;
		this.screenSize = screenSize;
		this.graphicsCoprocessor = graphicsCoprocessor;
		this.graphicsDescription = graphicsDescription;
		this.hardDiskDescription = hardDiskDescription;
		this.hardDiskSize = hardDiskSize;
		this.itemDimensions = itemDimensions;
		this.itemWeight = itemWeight;
		this.operatingSystem = operatingSystem;
		this.wirelessCompatibility = wirelessCompatibility;
	}
	
	public String getRamSize() {
		return ramSize;
	}
	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}
	public String getProcessorSeries() {
		return processorSeries;
	}
	public void setProcessorSeries(String processorSeries) {
		this.processorSeries = processorSeries;
	}
	public String getProcessorManufacturer() {
		return processorManufacturer;
	}
	public void setProcessorManufacturer(String processorManufacturer) {
		this.processorManufacturer = processorManufacturer;
	}
	public String getProcessorCount() {
		return processorCount;
	}
	public void setProcessorCount(String processorCount) {
		this.processorCount = processorCount;
	}
	public String getProcessorSpeed() {
		return processorSpeed;
	}
	public void setProcessorSpeed(String processorSpeed) {
		this.processorSpeed = processorSpeed;
	}
	public String getDisplayResolutionMaximum() {
		return displayResolutionMaximum;
	}
	public void setDisplayResolutionMaximum(String displayResolutionMaximum) {
		this.displayResolutionMaximum = displayResolutionMaximum;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getGraphicsCoprocessor() {
		return graphicsCoprocessor;
	}
	public void setGraphicsCoprocessor(String graphicsCoprocessor) {
		this.graphicsCoprocessor = graphicsCoprocessor;
	}
	public String getGraphicsDescription() {
		return graphicsDescription;
	}
	public void setGraphicsDescription(String graphicsDescription) {
		this.graphicsDescription = graphicsDescription;
	}
	public String getHardDiskDescription() {
		return hardDiskDescription;
	}
	public void setHardDiskDescription(String hardDiskDescription) {
		this.hardDiskDescription = hardDiskDescription;
	}
	public String getHardDiskSize() {
		return hardDiskSize;
	}
	public void setHardDiskSize(String hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}
	public String getItemDimensions() {
		return itemDimensions;
	}
	public void setItemDimensions(String itemDimensions) {
		this.itemDimensions = itemDimensions;
	}
	public String getItemWeight() {
		return itemWeight;
	}
	public void setItemWeight(String itemWeight) {
		this.itemWeight = itemWeight;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getWirelessCompatibility() {
		return wirelessCompatibility;
	}
	public void setWirelessCompatibility(String wirelessCompatibility) {
		this.wirelessCompatibility = wirelessCompatibility;
	}
	
	
}
