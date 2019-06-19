package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@ToString
@Log4j
@Service
@AllArgsConstructor //럼복으로 끝판...
public class Restaurant {
//	@Setter(onMethod_= @Autowired) 스프링 4버전.. 제일무난함..이걸제일많이씀...
	private Chef chef;

	public void order() {
		log.info(chef.cook());
	}//스프링 4.3버전이상부터 하나만 주입하고 하나만받는 상황이면 새성자만잇어도 자동으로넣느다.

//	@Autowired
//	public void setChef(Chef chef) {
//		this.chef = chef;  이것이 위에 @setter로 들어간거(스프링4. 대버전)
//	}
}