package hu.revival27.demoviewer.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.revival27.demoviewer.service.RingService;

@Controller
public class DemoViewerController {
	String url = "https://clara.io/api/users/nveronica/scenes";
	

	@Autowired
	RingService ringService;

	@GetMapping("")
	public String homepage() {
		System.out.println(ringService.findRings());
		return "index";
	}
	@PostMapping("/")
	public String submitRing() {
		return "index";
	}

	@RequestMapping(value="/log", method=RequestMethod.GET)
	public void getLogFile(HttpServletResponse response) throws IOException {
	    // use Java7+ try-with-resources
		 
		try {
			 InputStream inputStream = new FileInputStream(new File("./ringViewer.log"));
			   // if needed set content type and attachment header
	        response.addHeader("Content-disposition", "attachment;filename=ringViewer.log");
	        response.setContentType("txt/plain");

	        // copy content stream to the HttpServletResponse's output stream
	        IOUtils.copy(inputStream, response.getOutputStream());

	        response.flushBuffer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    
	}

	@GetMapping("https://clara.io/api/users/nveronica/scenes?perPage=500")
	public String getScenes() {
		return "index";
		}

	}
