package com.example.softlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.softlearning.applicationcore.entity.book.appservices.BookServicesImpl;
import com.example.softlearning.applicationcore.entity.client.appservices.ClientServicesImpl;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@SpringBootApplication
public class SoftlearningApplication {

	public static void main(String[] args)throws BuildException {
		ApplicationContext context = SpringApplication.run(SoftlearningApplication.class, args);
		// var clientServices = context.getBean(ClientServicesImpl.class);

        System.out.println("\n*****   A P P L I C A T I O N    S T A R T E D   *****\n");
		// try {
		// 	clientServices.deleteByIdent(22);
		// 	System.out.println("correcte");
		// } catch (ServiceException e) {
		// 	System.out.println(e.getMessage());
		// }
	}

}
