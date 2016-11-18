package com.bit2016.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;

@Service
public class BlogService {
	private static final String SAVE_PATH = "/upload"; 
	public static final String URL = "/jblog/assets/logo";

	@Autowired
	private BlogDao blogDao;

	public String restore(MultipartFile multipartFile, String title, Long userNo, String logo) {
		String url = "";
		BlogVo blogVo = null;
		try {
			if (multipartFile.isEmpty() == true) {
				blogVo = new BlogVo();
				blogVo.setBlogLogo(logo);
				blogVo.setBlogTitle(title);
				blogVo.setUserNo(userNo);
				
			} else {
				String originalFileName = multipartFile.getOriginalFilename();
				String extName = originalFileName.substring(originalFileName.lastIndexOf('.') + 1,
						originalFileName.length());
				String saveFileName = generateSaveFileName(extName);
				writeFile(multipartFile, saveFileName);

				//url = URL + saveFileName;
				blogVo = new BlogVo();
				blogVo.setBlogLogo(saveFileName);
				blogVo.setBlogTitle(title);
				blogVo.setUserNo(userNo);
			}
				blogDao.update(blogVo);
			
		} catch (IOException ex) {
			//throw new UploadFileException("write file");
			//log 남기기
			throw new RuntimeException("write file");
		}
		return url;
	}
	
	private void writeFile( MultipartFile multipartFile, String saveFileName) throws IOException {
		
			byte[] fileData = multipartFile.getBytes();
			FileOutputStream fos = new FileOutputStream( SAVE_PATH + "/" + saveFileName );
			fos.write( fileData );
			
			if (fos != null) {
				fos.close();
			}
		
	}
	private String generateSaveFileName( String ext) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		
		fileName += calendar.get( Calendar.YEAR );
		fileName += calendar.get( Calendar.MONTH );
		fileName += calendar.get( Calendar.DATE );
		fileName += calendar.get( Calendar.HOUR );
		fileName += calendar.get( Calendar.MINUTE );
		fileName += calendar.get( Calendar.SECOND );
		fileName += calendar.get( Calendar.MILLISECOND );
		fileName += ("." + ext );
		
		return fileName;
	}

	public BlogVo getInfo(String userId) {
		
		return blogDao.getInfo(userId);
	}
	
}
