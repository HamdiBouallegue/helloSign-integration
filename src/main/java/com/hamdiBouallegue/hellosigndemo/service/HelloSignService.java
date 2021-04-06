package com.hamdiBouallegue.hellosigndemo.service;

import org.springframework.stereotype.Service;

import com.hellosign.sdk.HelloSignClient;
import com.hellosign.sdk.HelloSignException;
import com.hellosign.sdk.resource.SignatureRequest;
import com.hellosign.sdk.resource.TemplateSignatureRequest;

@Service
public class HelloSignService {

	/**
	 * Send a Template document to a client
	 * 
	 * @return json response
	 * @throws HelloSignException
	 */
	public String send() throws HelloSignException {
		HelloSignClient client = new HelloSignClient("ADD_YOUR_API_KEY_HERE");
		TemplateSignatureRequest request = new TemplateSignatureRequest();
		request.setSubject("The Email subject");
		request.setSigner("Client", "CLIENT_EMAIL", "NAME");
		// this is the fullName feild
		request.setCustomFieldValue("name", "hamdi");
		request.setTemplateId("ADD_YOUR_API_DOCUMENT_ID_HERE");
		request.setTestMode(true);
		SignatureRequest newRequest = client.sendTemplateSignatureRequest(request);

		return newRequest.toString();
	}
}
