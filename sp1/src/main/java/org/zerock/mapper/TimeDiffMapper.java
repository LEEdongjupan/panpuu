package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeDiffMapper {
	
	@Select("select DATEDIFF(now() ,'1993-09-23')")
	public int calcGap();
	
	@Select("select DATEDIFF(now() ,#{day})")
	public int calcGap2(String day);
}
