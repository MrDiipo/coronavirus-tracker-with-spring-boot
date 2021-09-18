package com.mrdiipo.coronavirustracker.controllers;

import com.mrdiipo.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    public String home(Model model){
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        return "home";
    }
}
