package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Services.LoginService;
import com.example.demo.Services.ChucNangService;
import com.example.demo.Services.DangKyService;
import com.example.demo.Services.GroupUserService;
import com.example.demo.Services.QLUserService;
import com.example.demo.Services.UserChucNangService;
import com.example.demo.Services.VaiTroService;
import com.example.demo.Services.VaitroChucNangService;
import com.example.demo.dto.Md5;
import com.example.demo.models.Login;
import com.example.demo.models.KhuyenMai;
import com.example.demo.models.Login;
import com.example.demo.models.QLUser;
import com.example.demo.models.UserChucNang;
import com.example.demo.models.VaitroChucNang;

@Controller
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	LoginService LoginService;
	@Autowired
	QLUserService QLUserService;
	@Autowired
	DangKyService DangKyService;
	@Autowired
	UserChucNangService userChucNangService;
	@Autowired
	VaitroChucNangService VaitroChucNangService;
	@Autowired
	ChucNangService ChucNangService;
	@Autowired
	VaiTroService VaiTroService;
	@Autowired
	GroupUserService GroupUserService;

	@RequestMapping("/")
	public String index(Model model) {
		Login dto = new Login();
		model.addAttribute("Login", dto);
		model.addAttribute("action", "/Login/checklogin");
		return "Login";
	}

	public long random() {
		Random rd = new Random();
		long longNumber = rd.nextLong();
		if (longNumber < 0) {
			return (-1 * longNumber);
		}
		return longNumber;
	}

//Kiem Tra Loi
//tat ca loi co the xay ra
//chon dong tren trang
//hien thi tong so
//tim kiem giu lai
//
	@PostMapping("/saveorupdate")
	public String save(ModelMap model, @ModelAttribute("Login") Login Login) {
		Login.setId(random());
		Login.setIsdelete(0);
		LoginService.save(Login);
		Login u = new Login();
		model.addAttribute("Login", u);
		return "register-Login";

	}

	@PostMapping("/update")
	public String update(ModelMap model, @ModelAttribute("Login") Login Login) {
		// LoginService.update(Login.getName(),Login.getGender(),Login.getBirthday(),Login.getEmail()
		// ,Login.getPhone(),Login.getPassword(),Login.getAddress(),Login.getId());
		LoginService.save(Login);
		model.addAttribute("Login", Login);
		return "register-Login";

	}

	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") long id) {
		Optional<Login> u = LoginService.findById(id);
		if (u.isPresent()) {
			model.addAttribute("Login", u.get());
		} else {
			model.addAttribute("Login", new Login());
		}
		model.addAttribute("action", "/Login/update");

		return "register-Login";
	}

	@Autowired
	JdbcTemplate jdbcT;

	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Long id, HttpServletRequest request,
			RedirectAttributes redirect) {
//employeeService.isdelete(id);
		String sql = "update Login set isdelete=1 where id=?";
		Login Login = new Login(id);
		jdbcT.update(sql, new Object[] { Login.getId() });
		request.getSession().setAttribute("employeelist", null);
		redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

		return "redirect:/Login/page/{id}";
	}

	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model, @RequestParam("xoa[]") List<Long> ll, HttpServletRequest request,
			RedirectAttributes redirect) {
		for (int i = 0; i < ll.size(); i++) {
			System.out.println("so la : " + ll.get(i));
			Long g = ll.get(i);
			String sql = "update Login set isdelete=1 where id=?";
			Login Login = new Login(g);
			jdbcT.update(sql, new Object[] { Login.getId() });
			// employeeService.isdelete(g);
		}

		request.getSession().setAttribute("employeelist", null);
		redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/Login/page/{id}";
	}

	@GetMapping("/page")
	public String index(Model model, HttpServletRequest request, RedirectAttributes redirect) {
		request.getSession().setAttribute("employeelist", null);
		// RedirectView redirectView = new RedirectView();
		// redirectView.setUrl("http://www.yahoo.com");
		// return redirectView;
		redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		// return "redirect:/accounts/{id}";
		// if(model.asMap().get("success") != null)
		// redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/Login/page/{id}";
	}

	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		// model.addAttribute("customer",customerService.findAll());
		List<Login> list = (List<Login>) LoginService.findAll();
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
		String baseUrl = "/Login/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-Login";
	}

	public String xuly(String name) {
		name.trim();
		String tim = "";
		List<String> T = new ArrayList<>();
		String[] words = name.split("\\s");
		for (String w : words) {
			System.out.println(w);
			T.add(w);
		}
		for (int i = 0; i < T.size(); i++) {
			if (i == T.size() - 1) {
				tim = tim + T.get(i);
			} else {
				tim = tim + T.get(i) + "|";
			}
		}
		System.out.println("so ls: " + tim);
		return tim;
	}

	@GetMapping("/search")
	public String search(@RequestParam("s") String s, Model model, HttpServletRequest request) {
		if (s.equals("")) {
			return "/Login/page";
		}
		List<Login> list = LoginService.findup(xuly(s));
		if (list == null) {
			return "/Login/page";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);

		// final int goToPage = pageNumber - 1;
		// if (goToPage <= pages.getPageCount() && goToPage >= 0) {
		// pages.setPage(goToPage);
		// }
		// request.getSession().setAttribute("employeelist", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/Login/page/";
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);
		return "view-Login";
	}

	@GetMapping("/search/pageNumber")
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request) {
		if (s.equals("")) {
			return "/Login/page";
		}
		List<Login> list = LoginService.findAll();
		if (list == null) {
			return "/Login/page";
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
		String baseUrl = "/Login/page/";
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);
		return "view-Login";
	}

	@RequestMapping("/checklogin")
	public String checklogin(ModelMap model, @ModelAttribute("Login") Login Login, HttpSession session) {
		Login.setPassword(Md5.md5(Login.getPassword()));
		System.out.println("har "+Login.getPassword());
		for (int j = 0; j < DangKyService.findAll().size(); j++) {
			if (Login.getTendangnhap().equalsIgnoreCase(DangKyService.findAll().get(j).getTendangnhap())
					&& Login.getPassword().equalsIgnoreCase(DangKyService.findAll().get(j).getPassword())) {

				session.setAttribute("tendangnhap", Login.getTendangnhap());
				return "layout/main-layout1";
			}

		}

		return "Login";
	}

}
