package com.narendra.helper;

import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;
import com.narendra.webservices.client.StudentDetailsPortServiceStub;
import com.narendra.webservices.client.StudentDetailsPortServiceStub.StudentDetailsRequest;
import com.narendra.webservices.client.StudentDetailsPortServiceStub.StudentDetailsResponse;

public class SynchronousWebServiceClientHelper {

	public StudentDetailsResponse syncRequest(StudentDetailsRequest studentDetailsRequest) throws RemoteException {
		
		StudentDetailsResponse studentDetailsResponse = null;
		try {
			StudentDetailsPortServiceStub servicesStub = new StudentDetailsPortServiceStub("http://localhost:9090/service/student-details/StudentDetailsPort.wsdl");
			studentDetailsResponse = servicesStub.studentDetails(studentDetailsRequest);
			
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		return studentDetailsResponse;
	}
}
