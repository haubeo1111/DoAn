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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.NhanViendto;

import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	ChucVuService chucVuService;
	@GetMapping("/")
	public String index(Model model) {
		EmployeeDTO dto=new EmployeeDTO();
		model.addAttribute("dto",dto);
		model.addAttribute("action","/employee/saveorupdate");
		return "register-employee";
	}

	@ModelAttribute(name="chucvu")
	public List<ChucVu> getAll(){
		
	return  (List<ChucVu>) chucVuService.findAll();
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
	public String save(ModelMap model,@ModelAttribute("dto")EmployeeDTO dto) {
		dto.setId(random());
		//public String save(ModelMap model){
//			System.out.println("hau bbb000 ");
		//
		Optional<Employee> optionalstaff=employeeService.find(dto.getId());
		//System.out.println("hau bbb1111 ");
		Employee staff=null;
		String image="logo.png";
		//System.out.println("hau bbb2222 ");
		Path path=Paths.get("uploads/");
		//System.out.println("hau bbb ");
		if(optionalstaff.isPresent()) {
//			//save
			if(dto.getImage().isEmpty()) {
			image=optionalstaff.get().getImage();	
			}else {
				try {
				InputStream inputStream=dto.getImage().getInputStream();
					Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				image=dto.getImage().getOriginalFilename().toString();
			} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace(); 
				}}
		}else {
//			//add new.
		if(!dto.getImage().isEmpty()) {
			try {
				InputStream inputStream=dto.getImage().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), 
						StandardCopyOption.REPLACE_EXISTING);
				image=dto.getImage().getOriginalFilename().toString();
			} catch (Exception e) {
//				// TODO: handle exception
				e.printStackTrace(); 
		}
		}
		}

//dto.setId(random());
			 staff=new Employee(dto.getId(),dto.getName(),dto.getAddress(),dto.getPhone(),dto.getBirthday(),dto.getGender(),
			dto.getDegree(),image,0,dto.getChucvuid(),dto.getManv());

		employeeService.save(staff);
		return "register-employee";

		}
	@PostMapping("/update")
	public String update(ModelMap model,@ModelAttribute("dto")EmployeeDTO dto) {
		//dto.setId(random());
		//public String save(ModelMap model){
//			System.out.println("hau bbb000 ");
		//
		Optional<Employee> optionalstaff=employeeService.find(dto.getId());
		//System.out.println("hau bbb1111 ");
		Employee staff=null;
		String image="logo.png";
		//System.out.println("hau bbb2222 ");
		Path path=Paths.get("uploads/");
		//System.out.println("hau bbb ");
		if(optionalstaff.isPresent()) {
//			//save
			if(dto.getImage().isEmpty()) {
			image=optionalstaff.get().getImage();	
			}else {
				try {
				InputStream inputStream=dto.getImage().getInputStream();
					Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), 					StandardCopyOption.REPLACE_EXISTING);
				image=dto.getImage().getOriginalFilename().toString();
			} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace(); 
				}}
		}else {
//			//add new.
		if(!dto.getImage().isEmpty()) {
			try {
				InputStream inputStream=dto.getImage().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), 
						StandardCopyOption.REPLACE_EXISTING);
				image=dto.getImage().getOriginalFilename().toString();
			} catch (Exception e) {
//				// TODO: handle exception
				e.printStackTrace(); 
		}
		}
		}

//dto.setId(random());
			 staff=new Employee(dto.getId(),dto.getName(),dto.getAddress(),dto.getPhone(),dto.getBirthday(),dto.getGender(),
			dto.getDegree(),image,0,dto.getChucvuid(),dto.getManv());

		employeeService.save(staff);
		return "register-employee";

		}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<Employee> optionalstaff=employeeService.find(id);
	EmployeeDTO dto=null;
	if(optionalstaff.isPresent()) {
		Employee st=optionalstaff.get();
		File file=new File("uploads/"+st.getImage());
		FileInputStream input; 
		try {
			input=new FileInputStream(file);
			MultipartFile multiphoto=new MockMultipartFile("file",file.getName(),"text/plain",
					IOUtils.toByteArray(input)); 
			dto=new EmployeeDTO(st.getId(),st.getName(),st.getAddress(),st.getPhone(),st.getBirthday(),st.getGender(),st.getDegree()
					,multiphoto,0,st.getChucvuid(),st.getManv());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("dto",dto);
		model.addAttribute("action","/employee/update");
	}else {
		model.addAttribute("dto",new EmployeeDTO());
		model.addAttribute("action","/employee/saveorupdate");
	}
	//model.addAttribute("action","/employee/update");
	return "register-employee";
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")Long id
			,HttpServletRequest request,RedirectAttributes redirect) {
	//employeeService.isdelete(id);
	String sql="update employee set isdelete=1 where id=?";
	 Employee employee=new  Employee(id);
	 jdbcT.update(sql,new Object[] {employee.getId()});
		//employeeService.isdeletes(id);
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	//model.addAttribute("list1",employeeService.findAll());
	return "redirect:/employee/page/{id}";
	}
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			System.out.println("so la : "+ll.get(i));
			Long g=ll.get(i);
			 String sql="update employee set isdelete=1 where id=?";
			 Employee employee=new  Employee(g);
			 jdbcT.update(sql,new Object[] {employee.getId()});
			//employeeService.isdelete(g);
		}
		request.getSession().setAttribute("employeelist", null);
		 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/employee/page/{id}";
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
		return "redirect:/employee/page/{id}";
	}
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		model.addAttribute("chucvu",chucVuService.findAll());
		List<Employee> list =(List<Employee>) employeeService.getAll();
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
		String baseUrl = "/employee/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-employee";
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
			return "/employee/page";	
		}	
		List<Employee> list = employeeService.findup(xuly(s));	
		if (list == null) {	
			return "/emplyee/page";	
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
		return "view-employee";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/employee/page";	
		}	
		List<Employee> list = employeeService.getAll();	
		if (list == null) {	
			return "/emplyee/page";	
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
		String baseUrl = "/employee/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-employee";	
	}
	@RequestMapping("/tudong")
	public String tudong() {
		return "tudong1";
	}
}
