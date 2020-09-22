package com.example.demo.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.ChucVuRepository;
import com.example.demo.Repository.TienLuongRepository;
import com.example.demo.Services.BangChamCongService;
import com.example.demo.Services.BangLuongService;
import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.PhongBanService;
import com.example.demo.Services.PhuCapService;
import com.example.demo.Services.TangCaService;
import com.example.demo.Services.TienLuongService;
import com.example.demo.models.BangChamCong;
import com.example.demo.models.BangLuong;
import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;
import com.example.demo.models.PhongBan;
import com.example.demo.models.PhuCap;
import com.example.demo.models.TangCa;
import com.example.demo.models.TienLuong;

@Controller
@RequestMapping("/TienLuong")
public class TienLuongController {
SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
@Autowired
TienLuongRepository tienLuongRepository;
@Autowired
EmployeeService employeeService;
@Autowired
TienLuongService tienLuongService;
@Autowired
ChucVuRepository chucVuService;
@Autowired 
PhongBanService phongBanService;
@Autowired
BangLuongService bangLuongService;
@Autowired
BangChamCongService bangChamCongService;
@Autowired
PhuCapService phuCapService;
@Autowired
TangCaService tangCaService;

@ModelAttribute("nhanvien")
public List<Employee> getall(){
	return employeeService.getAll();
}
@ModelAttribute("chucvu")
public List<ChucVu> getall1(){
	return chucVuService.findAll();
}
@ModelAttribute("phongban")
public List<PhongBan> getall2(){
	return phongBanService.getAll();
}
@ModelAttribute("bangluong")
public List<BangLuong> getall3(){
	return bangLuongService.getAll();
}
@ModelAttribute("bangChamCong")
public List<BangChamCong> getall4(){
	return bangChamCongService.getAll();
}
@ModelAttribute("phucap")
public List<PhuCap> getall5(){
	return phuCapService.getAll();
}
@ModelAttribute("tangca")
public List<TangCa> getall6(){
	return tangCaService.getAll();
}
public long random() {
	Random rd = new Random();
	long longNumber = rd.nextLong();
	if(longNumber<0) {return (-1*longNumber);}
	return longNumber;
}
@RequestMapping("/")
public String tienluong(ModelMap model) throws ParseException {
	List<TienLuong> tl=new ArrayList<>(); 
	//TienLuong tienluong =new TienLuong();
	int workday=0;
	double pc=0;
	float hsl=0;
	long tien=0;
	int gio=0;
	long tienpc=0;
	for(int i=0;i<employeeService.getAll().size();i++) {
		TienLuong tienluong =new TienLuong();
		tienluong.setId(random());
		tienluong.setIdemployee(employeeService.getAll().get(i).getId());
		for(int j=0;j<phuCapService.getAll().size();j++) {
			if(phuCapService.getAll().get(j).getIdchucvu()==employeeService.getAll().get(i).getChucvuid()){
			pc=	phuCapService.getAll().get(j).getSotien()+pc;
			}
			
		}
		for(int k=0;k<bangLuongService.getAll().size();k++) {
			if(employeeService.getAll().get(i).getChucvuid()==bangLuongService.getAll().get(k).getChucvuid()) {
				hsl=bangLuongService.getAll().get(k).getHesoluong();
			}
		}
		 Calendar calendar = Calendar.getInstance();
	// workday=tienLuongService.ngaylam(employeeService.getAll().get(i).getId());
	 workday=tienLuongRepository.ngaylams(employeeService.getAll().get(i).getId(),d.parse("2020-10-10"),d.parse("2020-9-9"));
	 tienluong.setSongay(workday);
	 for(int l=0;l<tangCaService.getAll().size();l++) {
		 if(tangCaService.getAll().get(l).getIdemployee()==employeeService.getAll().get(i).getId()) {
			 gio=gio+tangCaService.getAll().get(l).getGio();
			 tienpc=tangCaService.getAll().get(l).getTien();
		 }
	 }
		tien=(long) ((pc+hsl*1490000)*workday+gio*tienpc);
		tienpc=1000000;
		tienluong.setLuong(tien);
		tienluong.setLuongthuc((long)(tien*0.895));
		tienluong.setNgaydauthang(new Date());
		tienluong.setNgaycuoithang(d.parse("2020-10-10"));
		tienluong.setIsdelete(0);
		//tienLuongService.save(tienluong);
  tl.add(tienluong);
 // System.out.println("kich koee"+tl.get(1).getLuong());
	}
//	System.out.println("kich koee"+tl.get(1).getLuong());
	//Page<TienLuong> page = tienLuongRepository.findall1(PageRequest.of(0, 5));
	model.addAttribute("tienluong",tl);
return  "view-TienLuong";
}

}
