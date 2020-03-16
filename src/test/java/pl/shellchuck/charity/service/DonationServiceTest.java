package pl.shellchuck.charity.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.repository.DonationRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DonationServiceTest {

    private DonationRepository donationRepository;
    private DonationService donationService;

    @Before
    public void setUp() {
        donationRepository = mock(DonationRepository.class);
        donationService = new DonationServiceImpl(donationRepository);
    }

    @Test
    public void given_donation_when_addDonation_then_return_object() {
        //given
        Donation donation = new Donation();
        when(donationRepository.save(donation)).thenReturn(donation);
        //when
        Donation katowiceDonation = donationService.addDonation(donation);
        //then
        assertNotNull(katowiceDonation);
        assertEquals(donation, katowiceDonation);
    }

    @Test
    public void given_id_when_searchDonationById_then_returnOptionalDonation() {
        //given
        Long id = 1L;
        Donation donationObj = new Donation();
        Optional<Donation> donation = Optional.of(donationObj);
        when(donationRepository.findById(id)).thenReturn(donation);
        //when
        Donation foundDonation = donationService.searchDonationById(id);
        //then
        assertEquals(donation.get(), foundDonation);
    }

    @Test(expected = NoSuchElementException.class)
    public void given_IdOfNotExisitngElement_when_searchDonationById_then_throwException() {
        //given
        Long id = 1L;
        Donation donationObj = new Donation();
        Optional<Donation> donation = Optional.of(donationObj);
        when(donationRepository.findById(id)).thenReturn(donation);
        //when
        Donation foundDonation = donationService.searchDonationById(2L);
    }

}
