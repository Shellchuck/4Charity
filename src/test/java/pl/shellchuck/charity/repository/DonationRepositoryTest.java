package pl.shellchuck.charity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.shellchuck.charity.entity.Category;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.entity.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DonationRepositoryTest {


    private TestEntityManager testEntityManager;
    private DonationRepository donationRepository;

    @Autowired
    public void setTestEntityManager(TestEntityManager testEntityManager) {
        this.testEntityManager = testEntityManager;
    }

    @Autowired
    public void setDonationRepository(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Test
    public void given_donation_when_findById_then_returnDonation() {
        //given
        Donation donation = new Donation();
        donation.setCity("Katowice");
        Institution institution = new Institution();
        testEntityManager.persist(institution);
        donation.setInstitution(institution);
        Category category = new Category();
        testEntityManager.persist(category);
        donation.setCategories(Arrays.asList(category));
        donation.setQuantity(5);
        donation.setStreet("Francuska");
        donation.setZipCode("41-200");
        donation.setPickUpDate(LocalDate.parse("2020-05-03"));
        donation.setPickUpTime(LocalTime.now());
        testEntityManager.persist(donation);
        //when
        Donation katowiceDonation = donationRepository.findById(1L).get();
        //then
        assertEquals(donation, katowiceDonation);
    }

    @Test(expected = NoSuchElementException.class)
    public void given_id_when_FindById_then_throwNoSuchElement() {
        //given
        Long donationId = 1L;
        //when
        donationRepository.findById(donationId).get();
    }

}
