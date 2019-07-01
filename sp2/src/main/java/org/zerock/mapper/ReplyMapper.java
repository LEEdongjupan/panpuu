package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	@Insert("insert into tbl_reply (bno,reply,replyer) values (#{bno},#{reply},#{replyer})")
	public int insert(ReplyVO vo);
	
}
