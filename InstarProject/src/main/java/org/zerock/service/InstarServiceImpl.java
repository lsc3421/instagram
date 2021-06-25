package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.InstarVO;
import org.zerock.mapper.InstarMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstarServiceImpl implements InstarService{
	
	private InstarMapper mapper;
	
	@Override
	public void register(InstarVO instarvo) {
		mapper.register(instarvo);
	}


	@Override
	public int idCheck(String userID) {
		int result = mapper.idCheck(userID);
		return result;
	}


	@Override
	public InstarVO Login(InstarVO instarvo) throws Exception {
		return mapper.login(instarvo);
	}


}
