package org.zerock.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "profileData")
public class UserImgsVO {
	private int userImgNo;
	private int userNo;
	private String profileName;
	private long profileSize;
	
	private MultipartFile file;
	
}
