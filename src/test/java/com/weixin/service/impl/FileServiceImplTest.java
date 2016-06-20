package com.weixin.service.impl;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.app.Application;
import com.weixin.service.iface.FileService;

/**
 * @author jay
 * @since 2016年6月20日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FileServiceImplTest {

	@Autowired
	FileService fileService;

	@Test
	public void testSave() throws Exception {
		
		File file = new File("test.jpg");
//		try {
//            FileInputStream stream = new FileInputStream(file);
//            ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
//            byte[] b = new byte[1024];
//            for (int n;(n = stream.read(b)) != -1;) {
//			out.write(b, 0, n);
//			}
//			stream.close();
//            out.close();
//            String id = fileService.save(out.toByteArray(), file.getName());
//            System.out.println(id);
//		} catch (IOException e) {
//        }
		
		//File file = new File("f:/test.jpg"); // lookup File or Resource
				InputStream input = null;
				try {
					input = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
		        byte[] b = new byte[1000];  
		        int n;  
		        while ((n = input.read(b)) != -1) {  
		            bos.write(b, 0, n);  
		        }  
		        input.close();  
		        bos.close();  
		        String id = fileService.save(bos.toByteArray(),file.getName());
		        System.out.println(id);
		
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileById() {
		fileService.getFileById("57675a9b8cdafc52eec42547");
	}

}
