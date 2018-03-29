package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/docker")
public class HelloResource {

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<List<String>> list() {
		return new ResponseEntity<List<String>>(Arrays.asList("sanjeev", "Mangesh"), HttpStatus.OK);
	}

}
