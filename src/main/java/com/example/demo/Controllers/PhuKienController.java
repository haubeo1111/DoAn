package com.example.demo.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Services.LoaiPKService;
import com.example.demo.Services.PhuKienService;
import com.example.demo.dto.PhuKienDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.PhuKien;
import com.example.demo.models.LoaiDT;
import com.example.demo.models.LoaiPK;

@Controller
@RequestMapping("/PhuKien")
public class PhuKienController {
@Autowired
PhuKienService PhuKienService;
@Autowired
LoaiPKService LoaiPKService;
@GetMapping("/")
public String index(Model model) {
	PhuKienDTO dto=new PhuKienDTO();
	model.addAttribute("dto",dto);
	model.addAttribute("action","/PhuKien/saveorupdate");
	return "register-PhuKien";
}

@ModelAttribute(name="loaipk")
public List<LoaiPK> getAll(){
	
return  (List<LoaiPK>) LoaiPKService.getAll();
}
public long random() {
	Random rd = new Random();
	long longNumber = rd.nextLong();
	if(longNumber<0) {return (-1*longNumber);}
	return longNumber;
}
//Kiem Tra Loi
//tat ca loi co the xay ra
//chon dong tren trang
//hien thi tong so
//tim kiem giu lai
//
@PostMapping("/saveorupdate")
public String save(ModelMap model,@ModelAttribute("dto")PhuKienDTO dto) {
	dto.setId(random());
	//public String save(ModelMap model){
//		System.out.println("hau bbb000 ");
	//
	Optional<PhuKien> optionalstaff=PhuKienService.find(dto.getId());
	//System.out.println("hau bbb1111 ");
	PhuKien staff=null;
	String image="logo.png";
	//System.out.println("hau bbb2222 ");
	Path path=Paths.get("uploads/");
	//System.out.println("hau bbb ");
	if(optionalstaff.isPresent()) {
//		//save
		if(dto.getHinhanh().isEmpty()) {
		image=optionalstaff.get().getHinhanh();	
		}else {
			try {
			InputStream inputStream=dto.getHinhanh().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getHinhanh().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			image=dto.getHinhanh().getOriginalFilename().toString();
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); 
			}}
	}else {
//		//add new.
	if(!dto.getHinhanh().isEmpty()) {
		try {
			InputStream inputStream=dto.getHinhanh().getInputStream();
			Files.copy(inputStream,path.resolve(dto.getHinhanh().getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			image=dto.getHinhanh().getOriginalFilename().toString();
		} catch (Exception e) {
//			// TODO: handle exception
			e.printStackTrace(); 
	}
	}
	}

//dto.setId(random());
		 staff=new PhuKien(dto.getId(),dto.getMapk(),dto.getTenpk(),dto.getNgaynhap(),image,dto.getSoluong(),
		dto.getGiaban(),dto.getMaloaipk(),0);

	PhuKienService.save(staff);
	return "register-PhuKien";

	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("dto")PhuKienDTO dto) {
	//dto.setId(random());
	//public String save(ModelMap model){
//		System.out.println("hau bbb000 ");
	//
	Optional<PhuKien> optionalstaff=PhuKienService.find(dto.getId());
	//System.out.println("hau bbb1111 ");
	PhuKien staff=null;
	String image="logo.png";
	//System.out.println("hau bbb2222 ");
	Path path=Paths.get("uploads/");
	//System.out.println("hau bbb ");
	if(optionalstaff.isPresent()) {
//		//save
		if(dto.getHinhanh().isEmpty()) {
		image=optionalstaff.get().getHinhanh();	
		}else {
			try {
			InputStream inputStream=dto.getHinhanh().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getHinhanh().getOriginalFilename()), 					StandardCopyOption.REPLACE_EXISTING);
			image=dto.getHinhanh().getOriginalFilename().toString();
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); 
			}}
	}else {
//		//add new.
	if(!dto.getHinhanh().isEmpty()) {
		try {
			InputStream inputStream=dto.getHinhanh().getInputStream();
			Files.copy(inputStream,path.resolve(dto.getHinhanh().getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			image=dto.getHinhanh().getOriginalFilename().toString();
		} catch (Exception e) {
//			// TODO: handle exception
			e.printStackTrace(); 
	}
	}
	}

//dto.setId(random());
	 staff=new PhuKien(dto.getId(),dto.getMapk(),dto.getTenpk(),dto.getNgaynhap(),image,dto.getSoluong(),
				dto.getGiaban(),dto.getMaloaipk(),0);

	PhuKienService.save(staff);
	return "register-PhuKien";

	}
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
Optional<PhuKien> optionalstaff=PhuKienService.find(id);
PhuKienDTO dto=null;
if(optionalstaff.isPresent()) {
	PhuKien st=optionalstaff.get();
	File file=new File("uploads/"+st.getHinhanh());
	FileInputStream input; 
	try {
		input=new FileInputStream(file);
		MultipartFile multiphoto=new MockMultipartFile("file",file.getName(),"text/plain",
				IOUtils.toByteArray(input)); 
		dto=new PhuKienDTO(st.getId(),st.getMapk(),st.getTenpk(),st.getNgaynhap(),multiphoto,st.getSoluong(),st.getGiaban(),
				st.getMaloaipk(),0);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	model.addAttribute("dto",dto);
	model.addAttribute("action","/PhuKien/update");
}else {
	model.addAttribute("dto",new EmployeeDTO());
	model.addAttribute("action","/PhuKien/saveorupdate");
}
//model.addAttribute("action","/employee/update");
return "register-PhuKien";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")Long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update PhuKien set isdelete=1 where id=?";
 PhuKien PhuKien=new  PhuKien(id);
 jdbcT.update(sql,new Object[] {PhuKien.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());
return "redirect:/PhuKien/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		Long g=ll.get(i);
		 String sql="update PhuKien set isdelete=1 where id=?";
		 PhuKien PhuKien=new  PhuKien(g);
		 jdbcT.update(sql,new Object[] {PhuKien.getId()});
		//employeeService.isdelete(g);
	}
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/PhuKien/page/{id}";
}
@GetMapping("/page")
public String index(Model model,HttpServletRequest request
		,RedirectAttributes redirect) {
	request.getSession().setAttribute("employeelist", null);
	// RedirectView redirectView = new RedirectView();
	  //  redirectView.setUrl("http://www.yahoo.com");
	    //return redirectView;
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	   //return "redirect:/accounts/{id}";
	//if(model.asMap().get("success") != null)
	//	redirect.addFlashAttribute("success",model.asMap().get("success").toString());
	return "redirect:/PhuKien/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("chucvu",LoaiDTService.getAll());
	List<PhuKien> list =(List<PhuKien>) PhuKienService.getAll();
	System.out.println(list.size());
	if (pages == null) {
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);
	} else {
		final int goToPage = pageNumber - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
	}
	request.getSession().setAttribute("employeelist", pages);
	int current = pages.getPage() + 1;
	int begin = Math.max(1, current - list.size());
	int end = Math.min(begin + 5, pages.getPageCount());
	int totalPageCount = pages.getPageCount();
	String baseUrl = "/PhuKien/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-PhuKien";
}
public String xuly(String name) {
name.trim();
String tim="";
List<String> T=new ArrayList<>();
String[] words = name.split("\\s");
for (String w : words) {
	   System.out.println(w);
	   T.add(w);
}
for(int i=0;i<T.size();i++) {
	if(i==T.size()-1) {
		tim=tim+T.get(i);
	}else {
	tim=tim+T.get(i)+"|" ;
	}
}
 System.out.println("so ls: "+ tim);
			return tim;
}
@GetMapping("/search")	
public String search(@RequestParam("s") String s, Model model, HttpServletRequest request	
	) {	
	if (s.equals("")) {	
		return "/PhuKien/page";	
	}	
	List<PhuKien> list = PhuKienService.findup(xuly(s));	
	if (list == null) {	
		return "/PhuKien/page";	
	}	
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
	int pagesize = 3;	
	pages = new PagedListHolder<>(list);	
	pages.setPageSize(pagesize);	
		
	//final int goToPage = pageNumber - 1;	
	//if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
	//	pages.setPage(goToPage);	
	//}	
	//request.getSession().setAttribute("employeelist", pages);	
	int current = pages.getPage() + 1;	
	int begin = Math.max(1, current - list.size());	
	int end = Math.min(begin + 5, pages.getPageCount());	
	int totalPageCount = pages.getPageCount();	
	String baseUrl = "/employee/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-PhuKien";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/PhuKien/page";	
	}	
	List<PhuKien> list = PhuKienService.getAll();	
	if (list == null) {	
		return "/PhuKien/page";	
	}	
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
	int pagesize = 3;	
	pages = new PagedListHolder<>(list);	
	pages.setPageSize(pagesize);	
		
	final int goToPage = Integer.parseInt(s) - 1;	
	if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
		pages.setPage(goToPage);	
	}	
	request.getSession().setAttribute("employeelist", pages);	
	int current = pages.getPage() + 1;	
	int begin = Math.max(1, current - list.size());	
	int end = Math.min(begin + 5, pages.getPageCount());	
	int totalPageCount = pages.getPageCount();	
	String baseUrl = "/PhuKien/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-PhuKien";	
}

}
