package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/sample/*")
public class SampleController {

	 @GetMapping("/all")
	  public void doAll() {
	    
	    log.info("do all can access everybody");
	  }
	  
	  @GetMapping("/member")
	  public void doMember() {
	    
	    log.info("logined member");
	  }
	  
	  
	  @PreAuthorize("hasRole('ROLE_ADMIN') && principal.username == #uid")
	  @GetMapping("/admin")
	  public void doAdmin(@RequestParam(name = "uid",defaultValue = "user00") String uid) {
	    log.info("uid:"+uid);
	    log.info("admin only");
	  }  
	  
	  
	  @PreAuthorize("hasRole('ROLE_MEMBER')")
	  @GetMapping("/manager")
	  public void doManager() {
	    
	    log.info("logined manager,admin only");
	  }
	  

}
