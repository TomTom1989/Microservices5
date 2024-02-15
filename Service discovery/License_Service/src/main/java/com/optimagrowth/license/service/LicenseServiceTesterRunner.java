/*package com.optimagrowth.license.service;

import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LicenseServiceTesterRunner {

    @Autowired
    private LicenseService licenseService;

    @Bean
    CommandLineRunner testOrganizationRetrievalUsingRestTemplate() {
        return args -> {
   
            String organizationId = "66427336-4a0a-49b0-bb63-cad96e86dfab"; 
            String clientType = "rest";

            System.out.println("Testing organization retrieval using RestTemplate client");
            
          
            Organization organization = licenseService.retrieveOrganizationInfo(organizationId, clientType);

            if(organization != null) {
                System.out.println("Organization Retrieved using RestTemplate: " + organization.getName());
            } else {
                System.out.println("Organization could not be retrieved using RestTemplate.");
            }
        };
    }
}*/
