package com.optimagrowth.license.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.service.LicenseService;

@Configuration
public class OrganizationServiceFeignTesterRunner {

    @Bean
    CommandLineRunner testOrganizationServiceFeignClient(LicenseService licenseService) {
        return args -> {
       
            String organizationId = "66427336-4a0a-49b0-bb63-cad96e86dfab"; 
            String clientType = "feign";

            System.out.println("Testing organization retrieval using the Feign client");

            try {
           
                Organization organization = licenseService.retrieveOrganizationInfo(organizationId, clientType);
                System.out.println("I am using the feign client");
                if (organization != null) {
                    System.out.println("Organization Retrieved using Feign: " + organization.getName());
                } else {
                    System.out.println("Organization not found");
                }
            } catch (Exception e) {
                System.out.println("Error during organization retrieval: " + e.getMessage());
            }
        };
    }
}
