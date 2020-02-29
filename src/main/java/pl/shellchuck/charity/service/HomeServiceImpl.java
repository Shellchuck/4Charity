package pl.shellchuck.charity.service;

import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.entity.Institution;
import pl.shellchuck.charity.repository.DonationRepository;
import pl.shellchuck.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;

    public HomeServiceImpl(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public int giftsSum() {
        List<Donation> allDonations = donationRepository.findAll();
        int allGifts = 0;
        for (Donation donation : allDonations) {
            allGifts += donation.getQuantity();
        }
        return allGifts;
    }

    @Override
    public int donationsSum() {
        return donationRepository.findAll().size();
    }

    @Override
    public List<Institution> listInstitutions() {
            return institutionRepository.findAll();
    }

}
