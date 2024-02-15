package com.optimagrowth.license;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.repository.LicenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class LicenseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LicenseRepository licenseRepository;

    @Test
    public void whenFindById_thenReturnLicense() {
        // given
        License license = new License();
        license.setLicenseId("123");
        license.setDescription("Test License");
        license.setOrganizationId("12345");
        license.setProductName("Test Product");
        license.setLicenseType("test");
        entityManager.persist(license);
        entityManager.flush();

        // when
        Optional<License> found = licenseRepository.findById(license.getLicenseId());

        // then
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getLicenseId()).isEqualTo(license.getLicenseId());
    }
}
