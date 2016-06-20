package com.weixin.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.weixin.service.iface.FileService;

/**
 * File controller
 * 
 * @author Jay
 * @time 2015年6月3日
 */
@RestController
@RequestMapping("api/file")
public class FileController {

	@Autowired
	FileService fileService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void saveFile(@RequestParam(value = "file") MultipartFile file) {
		try {
			// 文件类型 大小的判断
			fileService.save(file.getBytes(), file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public void getFile(String fileName, HttpServletResponse response){
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			byte[] result = fileService.get(fileName);
			if(null != result){
				os.write(fileService.get(fileName)); 
			}
		} catch (IOException e) {
			
		}
		
	}
	
	@RequestMapping(value = "{type}/{id}", method = RequestMethod.GET)
	public void getFileById(@PathVariable String type, @PathVariable String id, HttpServletResponse response){
		
		switch (type) {
		case "image":
			response.setContentType("image/jpeg");//设置相应信息的类型
			break;
		default:
			break;
		}
		
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			
			byte[] result = fileService.getFileById(id);
			if(null != result){
				os.write(result); 
			}
		} catch (IOException e) {
			
		}
		
	}
}
