package org.zerock.mapper;


import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	@Autowired
	private ReplyService service;
	
	@Test
	public void testTx() {
		service.addTest("lee dj");
		
	}
	
	private int[] bnoArr = {14327,14333,14328,14329,14338};
	
	@Test
	public void testList() {
		mapper.list(14557).forEach(vo-> log.info(vo));
	}
	
	
	@Test
	public void testInsert() {
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo =new ReplyVO();
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글test" +i);
			vo.setReplyer("replyer"+i);
			mapper.insert(vo);
		});
		}
	
	@Test
	public void testpdate() {
		
		ReplyVO vo = mapper.select(5);
		vo.setReply("수정된 s내뇽");
		mapper.update(vo);
		
	}
		
	}
	

