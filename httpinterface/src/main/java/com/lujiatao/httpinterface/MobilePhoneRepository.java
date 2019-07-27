package com.lujiatao.httpinterface;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lujiatao.httpinterface.mobilephones.MobilePhone;
import com.lujiatao.httpinterface.mobilephones.Os;

/***
 * 用HashMap模拟数据库存储数据
 * 
 * @author lujiatao
 *
 */
@Component
public class MobilePhoneRepository {

	private static final Map<String, MobilePhone> mobilePhones = new HashMap<>();

	@PostConstruct
	public void init() {
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

	public MobilePhone getMobilePhone(String model) {
		return mobilePhones.get(model);
	}

}
