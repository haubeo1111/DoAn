package com.example.demo.Controllers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class Imageuploadcontroller {
	@RequestMapping(value="getimage/{image}",method=RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("image")String photo){
		if(!photo.equals("")||photo!=null) {
			try {
			Path filename=Paths.get("uploads",photo);
			System.out.println("duong dan la : "+filename);
			byte [] buffer=Files.readAllBytes(filename);
			ByteArrayResource byteArrayResource =new ByteArrayResource(buffer);
			return (ResponseEntity<ByteArrayResource>) ResponseEntity.ok()
			.contentLength(buffer.length)
			.contentType(MediaType.parseMediaType("image/png"))
			.body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			} 
		}
		return ResponseEntity.badRequest().build();
	}

}
