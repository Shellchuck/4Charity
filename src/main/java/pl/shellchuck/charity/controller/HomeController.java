package pl.shellchuck.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.shellchuck.charity.entity.User;
import pl.shellchuck.charity.service.HomeService;
import pl.shellchuck.charity.service.UserService;


@Controller
public class HomeController {

    private HomeService homeService;
    private UserService userService;

    public HomeController(HomeService homeService, UserService userService) {
        this.homeService = homeService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("allGifts", homeService.giftsSum());
        model.addAttribute("donationsNumber", homeService.donationsSum());
        model.addAttribute("institutions", homeService.listInstitutions());
        return "index";
    }

    @GetMapping("/register")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

}
