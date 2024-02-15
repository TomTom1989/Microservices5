/*package com.optimagrowth.license.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.optimagrowth.license.service.LicenseService;
import com.optimagrowth.license.model.Organization;

@Component
public class OrganizationServiceTesterRunner implements CommandLineRunner {

    private final LicenseService licenseService;

    public OrganizationServiceTesterRunner(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @Override
    public void run(String... args) throws Exception {
      
        String organizationId = "66427336-4a0a-49b0-bb63-cad96e86dfab"; 
        String clientType = "discovery"; 

        System.out.println("Testing organization retrieval using the discovery client");
        Organization organization = licenseService.retrieveOrganizationInfo(organizationId, clientType);
        if (organization != null) {
            System.out.println("Organization Retrieved: " + organization.getName());
        } else {
            System.out.println("Organization retrieval failed.");
        }
    }
}*/
