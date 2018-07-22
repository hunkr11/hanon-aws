package com.mkyong.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanon.system.service.StockService;

@Controller
@ComponentScan("com.hanon.system")
//@RequestMapping(value = "/spring-mvc-file-upload")
public class StockController {	
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value = "/uploadStocksFile", method = RequestMethod.POST)
	@ResponseBody
	public 
	Object uploadStocksFile(MultipartHttpServletRequest request, HttpServletResponse response) {
	//	log.info("uploadPost called");
		System.out.println("uploadStocksFile");
		Map<String, Object> files = null;
		String json = "[]";
		try {
			files = stockService.uploadStocksFile(request, response);			
			json = new ObjectMapper().writeValueAsString(files);
		} catch (Exception e) {	
			e.printStackTrace();
//			log.error("EXCEPTION", e);
		}

		return json;
	}
	
	@RequestMapping(value = "/folder/{path}", method = RequestMethod.GET)
	public void folder(HttpServletResponse response, @PathVariable String path) {
		System.out.println("path : "+path);
	//	FileRepo fileRep = masterService.getFileRepoById(id);
	//	log.info("Downloading File :: " + fileUploadDirectory + "/" + fileRep.getNewFilename());
		try {
		//	Path file = Paths.get(fileUploadDirectory, fileRep.getNewFilename());
			Path file = Paths.get("C:/upload_files/"+path+".xls");
			System.out.println("File  : "+"C:/upload_files/"+path+".xls");
			if (Files.exists(file)) {
				System.out.println("File Exist : ");
//				response.setContentType(fileRep.getType());
//				response.addHeader("Content-Disposition", "attachment; filename=" + fileRep.getName());

				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();

			} else {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		//	log.error("Exception", e);
		}
	}
	


}
