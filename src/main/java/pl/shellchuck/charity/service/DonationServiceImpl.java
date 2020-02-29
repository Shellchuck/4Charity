package pl.shellchuck.charity.service;

import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation addDonation(Donation donation) {
        return donationRepository.save(donation);
    }

}
