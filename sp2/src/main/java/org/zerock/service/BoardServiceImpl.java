package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
<<<<<<< HEAD
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("vo");
		mapper.insert(vo);
		
	}

	@Override
	public BoardVO get(Integer key) {
		

		
		return mapper.select(key);
	}

	@Override
	public int modify(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		// TODO Auto-generated method stub
		return mapper.delete(key);
	}

	@Override
	public List<BoardVO> listall() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
=======
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("vo");
		mapper.insert(vo);	
	}

	@Override
	public BoardVO get(Integer key) {
		

		
		return mapper.select(key);
	}

	@Override
	public int modify(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		// TODO Auto-generated method stub
		return mapper.delete(key);
	}

	@Override
	public List<BoardVO> listall() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.selectPage(cri);
	}

	@Override
	public int getListCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.selectPageCount(cri);
>>>>>>> refs/remotes/origin/master
	}

	
	
	
}
