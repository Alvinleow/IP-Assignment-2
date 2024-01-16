package com.model;

import java.io.Serializable;

public class Trainee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String name;
    private double weight;
    private double height;
    private double bmi;
	
	public Trainee() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
}
