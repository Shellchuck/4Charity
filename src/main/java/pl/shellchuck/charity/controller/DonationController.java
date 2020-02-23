package pl.shellchuck.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.shellchuck.charity.entity.Category;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.entity.Institution;
import pl.shellchuck.charity.repository.CategoryRepository;
import pl.shellchuck.charity.repository.DonationRepository;
import pl.shellchuck.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;

    public DonationController(DonationRepository donationRepository,
                              CategoryRepository categoryRepository,
                              InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/add")
    public String fillDonation(Model model) {
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form";
    }

    @PostMapping("/add")
    public String Donate(@ModelAttribute Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }

    @ModelAttribute("allCategories")
    public List<Category> getCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    @ModelAttribute("allInstitutions")
    public List<Institution> getInstitutions() {
        List<Institution> allInstitutions = institutionRepository.findAll();
        return allInstitutions;
    }

}
