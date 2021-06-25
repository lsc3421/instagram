package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	
	// 2021/06/16 형태로
		private String getFolder() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String str = sdf.format(date);
			return str.replace("-", File.separator);
		}

	// 첨부파일이 이미지타입인지를 검사 : context-Type이 "image/*" 인지를 검사
	   private boolean checkImageType(File file) {
	      try {
	         String contentType = Files.probeContentType(file.toPath());
	         if (contentType != null) // modified by ksseo
	            return contentType.startsWith("image"); // image/jpg, image/png,
	         else
	            return false;
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return false;
	   }
	   
	   @PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // JSON형태로 응답
		@ResponseBody
		public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile, Model model) {
			log.info("upload ajax post.....");
			List<AttachFileDTO> list = new ArrayList<AttachFileDTO>(); // 반환될 목록
			String uploadFolder = "D:\\zzz\\upload";

			// 업로드 폴더 생성
			String uploadFolderPath = getFolder(); // yyyy/MM/dd
			File uploadPath = new File(uploadFolder, uploadFolderPath);
			log.info("uploadpath:" + uploadPath);
			if (uploadPath.exists() == false) { // dd 경로까지의 중간폴더 들을 모두생성
				uploadPath.mkdirs();
				// make yyyy/MM/dd folder
			}
			for (MultipartFile multipartFile : uploadFile) {
				AttachFileDTO attachDTO = new AttachFileDTO();

				log.info("------------------------------");
				log.info("uploadfilename:" + multipartFile.getOriginalFilename());
				log.info("uploadFileSize:" + multipartFile.getSize());
				String uploadFileName = multipartFile.getOriginalFilename();
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
				log.info("onlyfilename:" + uploadFileName);
				attachDTO.setFileName(uploadFileName); // 브라우저에서 첨부한 파일이름

				// 파일이름 중복방지
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid.toString() + "_" + uploadFileName;

				// 파일저장
				// File saveFile = new File(uploadFolder, uploadFileName);
				File saveFile = new File(uploadPath, uploadFileName);
				try {
					multipartFile.transferTo(saveFile); // 원본파일을 저장
					attachDTO.setUuid(uuid.toString()); // uuid
					attachDTO.setUploadPath(uploadFolderPath); // yyyy/MM/dd 폴더의 구조

					// 썸네일을 저장
					// 이미지 파일 유형인지 검사
					if (checkImageType(saveFile)) {
						attachDTO.setImage(true);
						FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
						Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
						thumbnail.close();
					}
					list.add(attachDTO);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			} // url : /uploadAjaxAction.jsp 응답 -> 404 Not Found가 발생
			return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
		}

}