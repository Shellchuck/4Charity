package pl.shellchuck.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.shellchuck.charity.service.HomeService;


@Controller
public class HomeController {

    private HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping("")
    public String homeAction(Model model) {
        model.addAttribute("allGifts", homeService.giftsSum());
        model.addAttribute("donationsNumber", homeService.donationsSum());
        model.addAttribute("institutions", homeService.listInstitutions());
        return "index";
    }

}
