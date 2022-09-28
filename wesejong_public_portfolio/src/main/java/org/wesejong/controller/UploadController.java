package org.wesejong.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/upload/*")
@Log4j
public class UploadController {

	@PostMapping("/imageUploadAction")
	public void imageUploadAction(HttpServletRequest request,
			HttpServletResponse response,
			MultipartHttpServletRequest multiFile) throws Exception{
		
		
		//printWriter.println을 올바르게 사용하기 위해서는 text/html 형식으로 보내야합니다.JSON형식으로 보낼시 반응없음
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		//ckeditor에서 파일을 보낼때 보내는 이름이 upload임
		MultipartFile uploadFile = multiFile.getFile("upload"); 

		//파일을 저장해놓을 폴더
		//String uploadFolder = "C:\\upload";
//		로컬에서 테스트할때 String uploadFolder = "C:\\upload";
//		처럼하면 안되는 이유는 tomcat 서버에서 실행하는데 이것을 어떻게 tomcat에서 가져오냐 이것임.
//		또한 eclipse에서 resources에 ckupload를 만들어주는 이유는 tomcat은 eclipse를 따라가서 자동으로
//		tomcat에도 프로그램이 만들어져서 그런것 아닐까 추측해봄.
		//uploadFolder:C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload
		//프로젝트 자체에 올리는것이 아닌 실제 서버에 올려야만 사진이 올릴때마다 사라지지 않습니다.
//		String uploadFolder =request.getSession().getServletContext().getRealPath("/")+"resources\\ckupload";
//		https://sjucomme@sjucomme.cafe24.com/sjucomme/tomcat/webapps/ROOT/resources/upload/temp
		
//		로컬에서 테스트할시 when studying
//		String uploadFolder =request.getSession().getServletContext().getRealPath("/")+"resources\\ckupload";
//		String uploadFolder = "C:\\upload"; 로하면 tomcat서버에서의 위치로 작동하지 않음
//		wesejong 서버에 올릴시
		String uploadFolder ="/wesejong/tomcat/webapps/ckupload";
//		sjucomme 서버에 올릴시
//		String uploadFolder ="/sjucomme/tomcat/webapps/ckupload";
	
//		String uploadFolder =request.getSession().getServletContext().getRealPath("/")+"resources\\ckupload";
		System.out.println(uploadFolder);
		log.info(uploadFolder);
		log.info("uploadFolder:"+uploadFolder);
		//make folder -------
		//getFolder:2021\07\14	
		//upload Path:C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload\2021\07\14
		String getFolder_path = getFolder();
		File uploadPath = new File(uploadFolder, getFolder_path);
		log.info("getFolder:"+getFolder_path);

		//make yyyy/MM/dd folder
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();
		}
		
		
		
		if(uploadFile!=null && uploadFile.getSize() > 0) {
			log.info("-------------------------------");
			
			UUID uuid = UUID.randomUUID();
			
			String uploadFileName = uploadFile.getOriginalFilename();
			//IE has file Path
			//uploadFileName:d7257d79-6640-4f53-87d2-7bb64e5f6253_notice.PNG
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			//uploadPath::C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload\2021\07\14
			//fileUrl:C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload\2021\07\14\d7257d79-6640-4f53-87d2-7bb64e5f6253_notice.PNG
			//ckupload198e6db4-ebc5-4c3d-91dd-3775cbf0e57d_notice.PNG
			//file.separator를 통해서 경로를 리턴하였을시에 윈도우에서는 \\ 리눅스에는 / 이런식으로나오는데
			//ckeditor에서 fileurl을 그냥 file.separator를 통해서 보냈을시에 backslash를 읽어내지못한다.
			//그리하여 split을 통해 blackslash를 '/'형태로 바꾸는 와중에
			//java.util.regex.PatternSyntaxException라는 에러를 해결한 사이트
			//https://stackoverflow.com/questions/10336293/splitting-filenames-using-system-file-separator-symbol
			String pattern = Pattern.quote(System.getProperty("file.separator"));
			String[] getFolder_path_array = getFolder_path.split(pattern);
			String fileUrl = request.getContextPath() + File.separator + "ckupload" + File.separator + getFolder_path + File.separator + uploadFileName;
			for(int i=0; i<getFolder_path_array.length;i++) {
				System.out.println(getFolder_path_array[i]);
			}
//			fileUrl = "/ckupload/2021/07/13/notice.PNG";
			fileUrl = request.getContextPath() + "/ckupload" + "/" + getFolder_path_array[0] + "/" + getFolder_path_array[1]  + "/" + getFolder_path_array[2] + "/" + uploadFileName;
			
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				uploadFile.transferTo(saveFile);
				log.info("uploadFileName:"+uploadFileName);
				log.info("upload Path:"+ uploadPath);
				log.info("url:"+fileUrl);
				
				//check Image type File
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					
					Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
				
				
//				json.addProperty("uploaded", 1);
//				json.addProperty("fileName", uploadFileName);
//				json.addProperty("url","/ckupload/2021/07/13/notice.PNG");
				String callback=request.getParameter("CKEditorFuncNum");
//				fileUrl = "/ckupload/2021/07/13/notice.PNG";
//				printWriter.println(json);
//	            printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+fileUrl+"','이미지가 업로드되었습니다.')"+"</script>");
	            
//	            printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+"\\ckupload\\2021\\07\\13\\notice.PNG"+"','이미지가 업로드되었습니다.')"+"</script>");
				printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+fileUrl+"','이미지가 업로드되었습니다.')"+"</script>");
//				printWriter.println("{\"filename\" : \""+uploadFileName+"\", \"uploaded\" : 1, \"url\":\""+"/ckupload/2021/07/13/notice.PNG"+"\"}");
//				try {
//					response.setContentType("application/json; charset=utf-8");
//					response.getWriter().write("{\"filename\" : \""+uploadFileName+"\", \"uploaded\" : 1, \"url\":\""+"/ckupload/2021/07/13/notice.PNG"+"\"}");
//				} catch(IOException e) {
//					e.printStackTrace();
//				}
				 
				

//				map.put("uploaded", 1);
//				map.put("fileName", uploadFileName);
//				map.put("url",uploadPath+ "\\" + uploadFileName);
				
				
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}finally {
				if(printWriter!=null) {
					printWriter.close();
					
				}
			}
		}
		
	
	}
	
	@PostMapping("/imageUploadActionx")
	public void imageUploadActionx(HttpServletRequest request,
			HttpServletResponse response,
			MultipartHttpServletRequest multiFile) throws Exception{
		
		
		//printWriter.println을 올바르게 사용하기 위해서는 text/html 형식으로 보내야합니다.JSON형식으로 보낼시 반응없음
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		JsonObject json = new JsonObject();
		//ckeditor에서 파일을 보낼때 보내는 이름이 upload임
		MultipartFile uploadFile = multiFile.getFile("upload"); 

		//파일을 저장해놓을 폴더
		//String uploadFolder = "C:\\upload";
		//uploadFolder:C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload
		//프로젝트 자체에 올리는것이 아닌 실제 서버에 올려야만 사진이 올릴때마다 사라지지 않습니다.
		String uploadFolder =request.getSession().getServletContext().getRealPath("/")+"resources\\ckupload";
		log.info("uploadFolder:"+uploadFolder);
		//make folder -------
		//getFolder:2021\07\14	
		//upload Path:C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload\2021\07\14
		String getFolder_path = getFolder();
		File uploadPath = new File(uploadFolder, getFolder_path);
		log.info("getFolder:"+getFolder_path);

		//make yyyy/MM/dd folder
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();
		}
		
		
		
		if(uploadFile!=null && uploadFile.getSize() > 0) {
			log.info("-------------------------------");
			
			UUID uuid = UUID.randomUUID();
			
			String uploadFileName = uploadFile.getOriginalFilename();
			//IE has file Path
			//uploadFileName:d7257d79-6640-4f53-87d2-7bb64e5f6253_notice.PNG
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			//uploadPath::C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload\2021\07\14
			//fileUrl:C:\Users\\user\Desktop\cloud_navy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\wesejong\resources\ckupload\2021\07\14\d7257d79-6640-4f53-87d2-7bb64e5f6253_notice.PNG
			//ckupload198e6db4-ebc5-4c3d-91dd-3775cbf0e57d_notice.PNG
			//file.separator를 통해서 경로를 리턴하였을시에 윈도우에서는 \\ 리눅스에는 / 이런식으로나오는데
			//ckeditor에서 fileurl을 그냥 file.separator를 통해서 보냈을시에 backslash를 읽어내지못한다.
			//그리하여 split을 통해 blackslash를 '/'형태로 바꾸는 와중에
			//java.util.regex.PatternSyntaxException라는 에러를 해결한 사이트
			//https://stackoverflow.com/questions/10336293/splitting-filenames-using-system-file-separator-symbol
			String pattern = Pattern.quote(System.getProperty("file.separator"));
			String[] getFolder_path_array = getFolder_path.split(pattern);
			String fileUrl = request.getContextPath() + File.separator + "ckupload" + File.separator + getFolder_path + File.separator + uploadFileName;
			for(int i=0; i<getFolder_path_array.length;i++) {
				System.out.println(getFolder_path_array[i]);
			}
//			fileUrl = "/ckupload/2021/07/13/notice.PNG";
			fileUrl = request.getContextPath() + "/ckupload" + "/" + getFolder_path_array[0] + "/" + getFolder_path_array[1]  + "/" + getFolder_path_array[2] + "/" + uploadFileName;
			
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				uploadFile.transferTo(saveFile);
				log.info("uploadFileName:"+uploadFileName);
				log.info("upload Path:"+ uploadPath);
				log.info("url:"+fileUrl);
				
				//check Image type File
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					
					Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumbnail, 100, 100);
				}
				
				
				
//				json.addProperty("uploaded", 1);
//				json.addProperty("fileName", uploadFileName);
//				json.addProperty("url","/ckupload/2021/07/13/notice.PNG");
				String callback=request.getParameter("CKEditorFuncNum");
//				fileUrl = "/ckupload/2021/07/13/notice.PNG";
//				printWriter.println(json);
//	            printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+fileUrl+"','이미지가 업로드되었습니다.')"+"</script>");
	            
//	            printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+"\\ckupload\\2021\\07\\13\\notice.PNG"+"','이미지가 업로드되었습니다.')"+"</script>");

//				원본입니다.
				printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+fileUrl+"','이미지가 업로드되었습니다.')"+"</script>");
//				printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+fileUrl+"</script>");
				
//				printWriter.println("{\"filename\" : \""+uploadFileName+"\", \"uploaded\" : 1, \"url\":\""+"/ckupload/2021/07/13/notice.PNG"+"\"}");
//				try {
//					response.setContentType("application/json; charset=utf-8");
//					response.getWriter().write("{\"filename\" : \""+uploadFileName+"\", \"uploaded\" : 1, \"url\":\""+"/ckupload/2021/07/13/notice.PNG"+"\"}");
//				} catch(IOException e) {
//					e.printStackTrace();
//				}
				 
				

//				map.put("uploaded", 1);
//				map.put("fileName", uploadFileName);
//				map.put("url",uploadPath+ "\\" + uploadFileName);
				
				
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}finally {
				if(printWriter!=null) {
					printWriter.close();
				}
			}
		}
		
	
	}
	
/*	년/월/일 폴더의 생성
	첨부파일을 보관하는 폴더를 생성하는 작업은
	한번에 폴더를 생성하거나 존재하는 폴더를 이용하는 방식을 사용합니다.
	java.io.File에 존재하는 mkdirs()를 이용하면 
	필요한 상위폴더까지 한번에 생성할수있으므로 간단히 처리할 수 있습니다*/
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	
//	  화면에서 약간의 검사를 통해서 업로드 되는 파일의 확장자를 검사하기는하지만, 
//	  Ajax로 사용하는 호출은 반드시 브라우저만을 통해서 들어오는
//	  것이 아니므로 확인할 필요가 있습니다. 서버에 업로드 된 파일은 조금 시간이 걸리더라도
//	   파일자체가 이미지인지를 정확히 체크한뒤에 저장하는
//	  것이 좋습니다. 특정한 파일이 이미지 타입인지를 검사하는 별도의 checkImageType() 메서드를 추가합니다.
	
	private boolean checkImageType(File file){
	    try{
	        String contentType = Files.probeContentType(file.toPath());
	    
	        return contentType.startsWith("image");
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	    return false;
	}

	
}
