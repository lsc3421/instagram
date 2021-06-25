package org.zerock.mapper;

import org.zerock.domain.InstarVO;

public interface InstarMapper {
	
	public void register(InstarVO instarvo);
	public int idCheck(String userID);
	public InstarVO login(InstarVO instarvo)throws Exception;
}
