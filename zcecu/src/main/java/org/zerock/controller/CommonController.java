package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	@GetMapping("/customLogout")
	public void CommenLogout() {
		log.info("logout");
	}
	
	@RequestMapping("/accessError")
	public void accessError() {
	
		log.info("accesserror");
	}
	@GetMapping("/customLogin")
	public void customLogin() {
		log.info("customlogin");
	}
}
