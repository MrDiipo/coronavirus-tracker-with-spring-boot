package com.mrdiipo.coronavirustracker.controllers;

import com.mrdiipo.coronavirustracker.models.LocationStats;
import com.mrdiipo.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> locationStats = coronaVirusDataService.getAllStats();
        int totalCases = locationStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        int totalNewCases = locationStats.stream().mapToInt(stats -> stats.getDiffFromPreviousDay()).sum();

        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        model.addAttribute("totalReportedCases", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
