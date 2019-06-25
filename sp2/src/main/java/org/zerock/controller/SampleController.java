package org.zerock.controller;


import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample*")
@Log4j
public class SampleController {

	@GetMapping("/ex1")
	public void doA(SampleDTO dto) {
		
		
	log.info(dto);
	}
	
	@GetMapping("/ex2")
	public void ex2(@RequestParam("name") String name ,@RequestParam("age")int age) {
		
	log.info(name);
	log.info(age);
	
	}
	
	@GetMapping("/ex3")
	public void ex3(@RequestParam("ids") String[] ids) {
		
	log.info(Arrays.toString(ids));
	
	}
	//@GetMapping("/ex4")
	@RequestMapping(value = "/ex4", method = {RequestMethod.GET,RequestMethod.POST})
	public void ex4(SampleDTOList list) {
		
	log.info(list);
	
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, false));
//	}
	
	@GetMapping("/ex5")
	public void ex5(TodoDTO todo) {
		log.info(todo);
	}
	
	@GetMapping("/ex6")
	public void ex6(TodoDTO todo) {
		log.info(todo);
	}
	@GetMapping("/ex7")
	public String ex7(SampleDTO dto,@ModelAttribute("page") int page, Model model) {
		
		log.info("ex7");
		log.info(dto);
		log.info(page);
		
		model.addAttribute("result","SUCCESS");
		
		return "/sample/ex7";
	}
	
	@GetMapping("/ex8")
	public String ex8(RedirectAttributes rttr) {
		log.info("ex8");
		
		rttr.addFlashAttribute("result" , "SUCCESS");
		//한번만 전해줄떄씀.
		return "redirect:/sample/ex9";
	}
	@GetMapping("/ex9")
	public void ex9() {
		log.info("ex9");
	}
	
}
	
