package org.zerock.service;

import org.zerock.domain.InstarVO;

public interface InstarService {
	public void register(InstarVO instrarvo);
	public int idCheck(String userID);
	public InstarVO Login(InstarVO userID)throws Exception;
}
