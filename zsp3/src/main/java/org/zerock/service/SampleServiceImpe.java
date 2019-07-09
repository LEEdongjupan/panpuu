package org.zerock.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpe implements SampleService {

	@Override
	public Integer add(String s1, String s2) throws Exception {
		// TODO Auto-generated method stub
		return Integer.parseInt(s1)+Integer.parseInt(s2);
	}

}
