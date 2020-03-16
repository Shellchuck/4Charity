package pl.shellchuck.charity.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.repository.DonationRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public Donation searchDonationById(Long id) {
        return donationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
    }
}
