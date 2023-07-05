package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final DonationService donationService;

    private final InstitutionService institutionService;


@RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("donations", donationService.findAll());
        model.addAttribute("quantity", donationService.sumOfBags());
        model.addAttribute("institutions", institutionService.findAll());
        return "index";
    }
}
