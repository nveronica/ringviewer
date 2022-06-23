package hu.revival27.demoviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoViewerController {
	@GetMapping("")
	public String homepage() {
		return "index";
	}
}
