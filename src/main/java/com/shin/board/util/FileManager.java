package com.shin.board.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	private static final Logger logger = LoggerFactory.getLogger(FileManager.class);

	/**
	 * @param filePath 파일 경로
	 * @param file 저장할 파일
	 * @return 생성된 파일 명(유일한 값)
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String FileSave(String filePath, MultipartFile file) throws IllegalStateException, IOException {
		File dir = new File(filePath + "/");
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		// 파일 중복명 처리
		String genId = UUID.randomUUID().toString();
		// 본래 파일명
		String originalfileName = file.getOriginalFilename();
		String fileExtension = getExtension(originalfileName);
		String saveFileName = genId + "." + fileExtension;
		// 저장되는 파일 이름
		
		String savePath = filePath + "/" + saveFileName; // 저장 될 파일 경로
		
		// 이미지 파일일 경우 리사이즈
		if (fileExtension.equals("jpg") || fileExtension.equals("jpeg") || fileExtension.equals("png")) {
			BufferedImage img = ImageUtils.resize(ImageUtils.getImage(file), 480, 320);
			ImageUtils.writeJpeg(img, new File(savePath), 1);
		} else {
			file.transferTo(new File(savePath));
		}
		
		// 저장될 유니크한 파일 이름 반환
		return saveFileName;
	}
	
	/**
	 * 파일이름으로부터 확장자를 반환
	 * @param fileName
	 *            : 확장자를 포함한 파일 명
	 * @return 파일 이름에서 뒤의 확장자 이름만을 반환
	 */
	private static String getExtension(String fileName) {
		int dotPosition = fileName.lastIndexOf('.');
		
		if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
			return fileName.substring(dotPosition + 1);
		} else {
			return "";
		}
	}
	
	/**
	 * 실제 디스크 파일 삭제
	 * @param filePath 파일경로
	 * @param fileName 실제파일이름
	 */
	public static void FileRemove(String filePath, String fileName) {
		String removeFilePath = filePath + "/" + fileName;
		File file = new File(removeFilePath);
		
		if (file.delete()) {
			logger.info(removeFilePath + "파일이 정상적으로 삭제 되었습니다. ");
		} else {
			logger.info(removeFilePath + "파일이 삭제되지 않았습니다. ");
		}
	}
}
