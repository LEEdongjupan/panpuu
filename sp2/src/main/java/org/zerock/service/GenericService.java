package org.zerock.service;

<<<<<<< HEAD
public interface GenericService<VO, K> {

	public void register(VO vo);
	
	public VO get(K key);
	
	public int modify(VO vo);
	
	public int remove(K key);
=======
import java.util.List;

import org.zerock.domain.Criteria;

public interface GenericService<VO, K> {

	public void register(VO vo);
	
	public VO get(K key);
	
	public int modify(VO vo);
	
	public int remove(K key);
	
	public List<VO> getList(Criteria cri);
	
	public int getListCount(Criteria cri);
>>>>>>> refs/remotes/origin/master
	
}
