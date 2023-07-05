package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.CurrentUser;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

   private final InstitutionService institutionService;

   private final CategoryService categoryService;

    private final DonationService donationService;

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("donation", new Donation());
        model.addAttribute("institutions", institutionService.findAll());
        return "home";
    }

    @PostMapping("/home")
    public String handleForm(@ModelAttribute("donation") @Valid Donation donation, @AuthenticationPrincipal CurrentUser currentUser,
                                     BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        donation.setUser(currentUser.getUser());
        donationService.saveDonation(donation);
        return "form-confirmation";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

}
