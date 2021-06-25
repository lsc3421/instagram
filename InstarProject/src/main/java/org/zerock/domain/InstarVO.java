package org.zerock.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class InstarVO {
	private int bno;
	private String userID;
	private String password;
	private String email;
	private String userName;
	private int user_num;
	
	private MultipartFile file;
	
	private int userImgNo;
	private String profileName;
	private long profileSize;
	
}
