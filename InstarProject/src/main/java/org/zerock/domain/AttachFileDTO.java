package org.zerock.domain;

import lombok.Data;


// 첨부파일에 대한 정보를 브라우저로 반환하기 위하여 사용
@Data
public class AttachFileDTO {
	private String fileName;  	// 원본파일의 이름(브라우저에서 업로드한 파일의이름)
	private String uploadPath;  // 절대경로를 사용해서 다운로드, 이미지를 표시할때 필요.
	private String uuid; 		// 데이터베이스에 저장된 파일 정보를 접근할때 필요(px)
	private boolean image; 		// 이미지 여부를 저장
	
}
