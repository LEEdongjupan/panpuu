package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

@RestController
@RequestMapping("/order/*")
public class SampleController2 {

	@PostMapping("/new")
	public String add(@RequestBody Ticket ticket) {
		
		System.out.println("ticket:"+ticket);
		return "success";
	}
	
	@GetMapping(value = "/{ono}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	public SampleVO ex01( @PathVariable("ono") Integer ono) {

		System.out.println("=========================");
		System.out.println(ono);
		System.out.println("=========================");
		SampleVO vo = new SampleVO();
		vo.setFirst("dj");
		vo.setLast("lee");
		return vo;
	}
	
	@RequestMapping("hello2")
	public String hello2() {
		return "hello world 2";
	}
	
	@RequestMapping("hello22")
	public ResponseEntity<String> hello22() {

		ResponseEntity<String> res = new ResponseEntity<String>("hello world",HttpStatus.OK);
		return res;
	}
	
}
