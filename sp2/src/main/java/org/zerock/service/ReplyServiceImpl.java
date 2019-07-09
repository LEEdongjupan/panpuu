package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service
@Transactional
@Log4j
public class ReplyServiceImpl implements ReplyService {
	@Setter(onMethod_= @Autowired )
	private ReplyMapper mapper;
	
	@Setter(onMethod_= @Autowired )
	private BoardMapper boardmapper;
	
	@Override
	public void register(ReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.insert(vo);
		boardmapper.updateReplyCnt(vo.getBno(), 1);
	}

	@Override
	public ReplyVO get(Integer key) {
		// TODO Auto-generated method stub
		return mapper.select(key);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {

		ReplyVO vo = mapper.select(key);
		
		mapper.delete(key);
		
		return boardmapper.updateReplyCnt(vo.getBno(), -1);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyVO> getSimpleList(Integer bno) {
		// TODO Auto-generated method stub
		return mapper.list(bno);
	}
	@Transactional
	@Override
	public void addTest(String str) {
		// TODO Auto-generated method stub
		mapper.insert1(str);
		mapper.insert2(str);
	}

}
