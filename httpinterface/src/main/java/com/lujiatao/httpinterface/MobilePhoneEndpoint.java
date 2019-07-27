package com.lujiatao.httpinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lujiatao.httpinterface.mobilephones.GetMobilePhoneRequest;
import com.lujiatao.httpinterface.mobilephones.GetMobilePhoneResponse;

/***
 * SOAP接口的服务端
 * 
 * @author lujiatao
 *
 */
@Endpoint
public class MobilePhoneEndpoint {

	private MobilePhoneRepository mobilePhoneRepository;

	@Autowired
	public MobilePhoneEndpoint(MobilePhoneRepository mobilePhoneRepository) {
		this.mobilePhoneRepository = mobilePhoneRepository;
	}

	@PayloadRoot(namespace = "http://www.lujiatao.com/httpinterface/MobilePhones", localPart = "getMobilePhoneRequest")
	@ResponsePayload
	public GetMobilePhoneResponse getMobilePhone(@RequestPayload GetMobilePhoneRequest request) {
		GetMobilePhoneResponse response = new GetMobilePhoneResponse();
		response.setMobilePhone(mobilePhoneRepository.getMobilePhone(request.getModel()));
		return response;
	}

}
