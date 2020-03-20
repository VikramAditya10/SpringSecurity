package com.surdtech;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoResource {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
public String getMessage() {
	return "Hello World!";
}
}
