package org.springframework.samples.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {


	@AnotherValue("H2")
	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "Hello world!";
	}

	@AnotherValue("HH")
	@RequestMapping("/simple2")
	public @ResponseBody String simple2() {
		return "Hello world!";
	}

	@RequestMapping("/simple3")
	public @ResponseBody String simple3() {
		return "Hello world!";
	}

}
