package org.zerock.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Data
@ToString
public class BoardVO {
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String fileName;
	private MultipartFile uploadFile;
	
	
	
}