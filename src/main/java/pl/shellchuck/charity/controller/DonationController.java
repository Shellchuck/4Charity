package pl.shellchuck.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.service.CategoryService;
import pl.shellchuck.charity.service.DonationService;
import pl.shellchuck.charity.service.InstitutionService;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private DonationService donationService;
    private CategoryService categoryService;
    private InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/add")
    public String fillDonation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("allCategories", categoryService.listCategories());
        model.addAttribute("allInstitutions", institutionService.listInstitutions());
        return "form";
    }

    @PostMapping("/add")
    public String Donate(@ModelAttribute Donation donation) {
        donationService.addDonation(donation);
        return "form-confirmation";
    }

}
