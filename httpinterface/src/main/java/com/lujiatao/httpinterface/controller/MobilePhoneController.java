package com.lujiatao.httpinterface.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lujiatao.httpinterface.domain.MobilePhone;
import com.lujiatao.httpinterface.domain.Os;
import com.lujiatao.httpinterface.repository.MobilePhoneRepository;

@RestController
public class MobilePhoneController {

	private MobilePhoneRepository mobilePhoneRepository = new MobilePhoneRepository();

	@GetMapping("/mobilePhone")
	public MobilePhone getMobilePhone(@RequestParam(value = "model") String model) {
		return mobilePhoneRepository.getMobilePhone(model);
	}

	@ResponseBody
	@PostMapping("/mobilePhone")
	public String saveMobilePhone(@RequestBody String body) {
		JSONObject json = new JSONObject(body);
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setBrand(json.getString("brand"));
		mobilePhone.setModel(json.getString("model"));
		mobilePhone.setOs(Os.valueOf(json.getString("os")));
		String template = "{\"code\":%d,\"message\":\"保存%s！\"}";
		return mobilePhoneRepository.setMobilePhone(mobilePhone.getModel(), mobilePhone) == 0
				? String.format(template, 0, "成功")
				: String.format(template, 1, "失败");
	}

}
