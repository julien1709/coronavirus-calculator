package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

	@Autowired
	CoronaVirusDataService coronaVirusDataService;


	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		addModelValues(model, allStats);
		return "home";
	}

	@GetMapping("/lower")
	public String lower(Model model) {
		List<LocationStats> sortedStats = coronaVirusDataService.getAllStats().stream().sorted().collect(Collectors.toList());
		addModelValues(model, sortedStats);
		return "lower";
	}

	private void addModelValues(Model model, List<LocationStats> sortedStats) {
		int totalReportedCases = sortedStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
		int totalNewCases = sortedStats.stream().mapToInt(LocationStats::getDeltaFromPreviousDate).sum();
		model.addAttribute("locationStats", sortedStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
	}

}
