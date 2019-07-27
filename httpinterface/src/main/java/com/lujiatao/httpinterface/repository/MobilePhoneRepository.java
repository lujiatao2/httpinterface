package com.lujiatao.httpinterface.repository;

import java.util.HashMap;
import java.util.Map;

import com.lujiatao.httpinterface.domain.MobilePhone;
import com.lujiatao.httpinterface.domain.Os;

public class MobilePhoneRepository {

	private static Map<String, MobilePhone> mobilePhones = new HashMap<>();

	static {
		MobilePhone iPhone6S = new MobilePhone();
		iPhone6S.setBrand("Apple");
		iPhone6S.setModel("iPhone 6S");
		iPhone6S.setOs(Os.IOS);
		mobilePhones.put(iPhone6S.getModel(), iPhone6S);
		MobilePhone motoZ = new MobilePhone();
		motoZ.setBrand("Motorola");
		motoZ.setModel("moto Z");
		motoZ.setOs(Os.ANDROID);
		mobilePhones.put(motoZ.getModel(), motoZ);
		MobilePhone p30 = new MobilePhone();
		p30.setBrand("HUAWEI");
		p30.setModel("P30");
		p30.setOs(Os.ANDROID);
		mobilePhones.put(p30.getModel(), p30);
	}

	public int setMobilePhone(String model, MobilePhone mobilePhone) {
		try {
			mobilePhones.put(model, mobilePhone);
		} catch (Exception e) {
			return 1;
		}
		return 0;
	}

	public MobilePhone getMobilePhone(String model) {
		return mobilePhones.get(model);
	}

}
