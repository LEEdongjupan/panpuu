package org.zerock.mapper;

<<<<<<< HEAD
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	BoardMapper mapper;
=======
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testMap() {
		String type = "TCW";
		String keyword ="김길동";
		
		if(type == null || type.trim().length() == 0) {
			//return null;
		}
		
		String[] arr = type.split("");
		
		log.info(Arrays.toString(arr));
		
		Map<String ,String> map = new HashMap<>();
		
		for(String word: arr) {
			map.put(word,keyword);
		}
		log.info(map);
		
	}
	
	@Test
	public void testSearch() {
		Map <String, String> map = new HashMap<>();
		map.put("T", "샘플");
		map.put("C", "샘플");
		map.put("W", "샘플");
		mapper.search(map);
	}
	
	@Test
	public void testPageMaker() {
		Criteria cri = new Criteria();
		cri.setPage(11);
		PageMaker pm = new PageMaker(cri,201);
		
		log.info(pm);
		log.info(pm.getLink("/board/list", 3));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setAmount(50);
		cri.setType("TCW");
		cri.setKeyword("user02");
		mapper.selectPage(cri).forEach(vo->log.info(vo));
	}
>>>>>>> refs/remotes/origin/master
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("샘플제목");
		vo.setContent("샘플 내용");
		vo.setWriter("user02");
		mapper.insert(vo);
		
	}
	@Test
	public void testselect() {
		BoardVO vo = mapper.select(7);
		
		log.info(vo);
	}
		
	@Test
	public void testpdate() {
		
		BoardVO vo = mapper.select(5);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		mapper.update(vo);
		
	}
	
	@Test
	public void testdelete() {
		int count = mapper.delete(6);
		
		log.info("delete count:"+count);
		
	}
		
}
