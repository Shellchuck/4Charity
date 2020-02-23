package pl.shellchuck.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.entity.Institution;
import pl.shellchuck.charity.repository.DonationRepository;
import pl.shellchuck.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("")
    public String homeAction(Model model){
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);
        List<Donation> allDonations = donationRepository.findAll();
        int allGifts = 0;
        for (Donation donation : allDonations) {
            allGifts += donation.getQuantity();
        }
        model.addAttribute("allGifts", allGifts);
        int donationsNumber = allDonations.size();
        model.addAttribute("donationsNumber", donationsNumber);
        return "index";
    }
}
