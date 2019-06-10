package com.narendra.controller;

import java.rmi.RemoteException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.helper.SynchronousWebServiceClientHelper;
import com.narendra.webservices.client.StudentDetailsPortServiceStub.StudentDetailsRequest;
import com.narendra.webservices.client.StudentDetailsPortServiceStub.StudentDetailsResponse;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//@Autowired
	//SynchronousWebServiceClientHelper synchronousWebServiceClientHelper = new SynchronousWebServiceClientHelper();

	@Autowired
	SynchronousWebServiceClientHelper synchronousWebServiceClientHelper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		StudentDetailsResponse studentDetailsResponse = null;
		
		try {
			StudentDetailsRequest studentDetailsRequest = new StudentDetailsRequest();
			studentDetailsRequest.setName("Kajal");
			
			studentDetailsResponse = synchronousWebServiceClientHelper.syncRequest(studentDetailsRequest);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
		return studentDetailsResponse.getStudent().getAddress();
	}
	
}
