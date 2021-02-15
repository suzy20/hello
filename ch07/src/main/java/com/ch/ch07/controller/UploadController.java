package com.ch.ch07.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.ch07.model.Member;

@Controller
public class UploadController {
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile mf, 
			Member member, Model model, HttpSession session) throws IOException {
		String fileName = mf.getOriginalFilename();
		String real = session.getServletContext().getRealPath("/resources/upload");
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		fos.write(mf.getBytes());
		fos.close();
		// mf.transferTo(new File("c:/java/"+fileName)); 내컴퓨터 c,java...에 이미지파일 저장됨
		int fileSize = (int)mf.getSize();
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		model.addAttribute("id", member.getId());
		model.addAttribute("name", member.getName());
		return "upload";
	}
	// MultipartFile : 음악, 그림, 문서 등 다양한 파일을 binary형식인 데이터
	@RequestMapping("upload2")
	public String upload2(Member member, Model model, HttpSession session) throws IOException {
		String fileName1 = member.getFile().getOriginalFilename();
		// 파일명을 변경할 때 사용 uuid
		UUID uuid = UUID.randomUUID();
		String fileName = uuid+"-"+fileName1;
		String real = session.getServletContext().getRealPath("/resources/upload");
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		// /resources/upload위치에 fileName 이름으로 파일 저장
		fos.write(member.getFile().getBytes());
		fos.close();
		// mf.transferTo(new File("c:/java/"+fileName)); 내컴퓨터 c,java...에 이미지파일 저장됨
		int fileSize = (int)member.getFile().getSize();
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		model.addAttribute("id", member.getId());
		model.addAttribute("name", member.getName());
		return "upload";
	}
	@RequestMapping("uploadForm3")
	public String uploadForm3() {
		return "uploadForm3";
	}
	// 그림 여러개 들어올 때 
	@RequestMapping("upload3")
	public String upload3(HttpSession session, 
			MultipartHttpServletRequest mhr, Model model) throws IOException {
		// 실제 파일이 저장되는 위치를 지정하기 위해 
		String real = session.getServletContext().getRealPath("/resources/upload");
		// 파일이 여러개인 경우는 파일과 데이터가 mhr에 포함돼서 들어옴
		String name = mhr.getParameter("name");
		String id = mhr.getParameter("id");
		// 파일명 여러개 저장하기 위한 list
		List<String> fileList = new ArrayList<String>();
		// 여러개 실제 파일을 읽어서 list에 포함
		List<MultipartFile> list = mhr.getFiles("file");
		// 여러개 파일을 하나씩 추출하여 mf에 저장
		for (MultipartFile mf : list) {
			// list에 여러 파일명 담기
			String fileName = mf.getOriginalFilename();
			fileList.add(fileName);
			// 하나씩 실제 저장 위치에 저장
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(mf.getBytes());
			fos.close();
		}
		// jsp에 전달
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("fileList", fileList);
		return "upload3";
	}
}


