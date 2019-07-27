package com.lujiatao.httpinterface.domain;

import java.io.Serializable;

public class MobilePhone implements Serializable {

	private static final long serialVersionUID = -8535943728312231699L;
	private String brand;
	private String model;
	private Os os;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setOs(Os os) {
		this.os = os;
	}

	public Os getOs() {
		return os;
	}

}
