package com.example.demo.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.NhanVienService;
import com.example.demo.dto.NhanViendto;
import com.example.demo.models.ChucVu;
import com.example.demo.models.NhanVien;



@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
	SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	ChucVuService chucVuService;
@RequestMapping("/")
public String nhanvien(ModelMap model) {
	
		//NhanVien nhanvien =new NhanVien("2a","haumap","myan","09",new Date(),true,"caodang","anh");
		//nhanVienService.save(nhanvien);
	NhanViendto dto=new NhanViendto();
	model.addAttribute("dto",dto);
	model.addAttribute("action","/nhanvien/saveorupdate");

	return "nhanvien";
}
@ModelAttribute(name="depart1")
public List<ChucVu> getAll(){
return  (List<ChucVu>) chucVuService.findAll();
}
@RequestMapping("/list")
public String listnhanvien(ModelMap model) {
model.addAttribute("list1",nhanVienService.findAll() );
NhanViendto dto=new NhanViendto();
model.addAttribute("dto",dto);
Map referenceData = new HashMap();
List<String> courses = new ArrayList<String>();
courses.add("Yoga");
courses.add("Stretching");
courses.add("Pilates");
courses.add("Aerobic");
courses.add("Oriental");
model.addAttribute("courses", courses);
//System.out.println("hau  "+staffsService.findAll().size());
return "view-nhanvien";
}
@RequestMapping("/saveorupdate")
public String save(ModelMap model,@ModelAttribute("dto")NhanViendto dto) {
	//Optional<NhanVien> optionalstaff=nhanVienService.findById(dto.getId());
	//System.out.println("hau bbb1111 ");
	NhanVien staff=null;
	ChucVu chucvu=new ChucVu();
	chucvu.setId(dto.getChucvu());
	String image="anh.jpg";
	//System.out.println("hau bbb2222 ");
	Path path=Paths.get("uploads/");
	//System.out.println("hau bbb ");
	//if(optionalstaff.isPresent()) {
//		//save
	//	if(dto.getImage().isEmpty()) {
		//image=optionalstaff.get().getImage();	
		//}else {
			try {
			InputStream inputStream=dto.getImage().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), 				
						StandardCopyOption.REPLACE_EXISTING);
			image=dto.getImage().getOriginalFilename().toString();
		} catch (Exception e) {
		//		 TODO: handle exception
				e.printStackTrace(); 
			}
	//}else {
//		//add new.
	//if(!dto.getImage().isEmpty()) {
	//	try {
	//		InputStream inputStream=dto.getImage().getInputStream();
	//		Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), 
	//				StandardCopyOption.REPLACE_EXISTING);
	//		image=dto.getImage().getOriginalFilename().toString();
	//	} catch (Exception e) {
//			// TODO: handle exception
	//		e.printStackTrace(); 
	//}
//	}
//	}


		 staff=new NhanVien(dto.getId(),dto.getName(),dto.getAddress(),dto.getPhone(),dto.getBirthday(),dto.getGender(),dto.getDegree(),image,0,dto.getChucvu(),dto.getManv());

	nhanVienService.save(staff);


	return "nhanvien";
}
@RequestMapping("/edit")
public String edit(ModelMap model, @RequestParam("id") int id, @RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("birthday")String birthday
		,@RequestParam("phone") String phone,@RequestParam("degree") String degree,@RequestParam("manv")String manv,
		@RequestParam("gender") int gender,@RequestParam("chucvu")int chucvu,@ModelAttribute("dto")NhanViendto dto,@RequestParam("image1") String image
		) {
Optional<NhanVien> optionalstaff=nhanVienService.findById(id);
NhanViendto dto1=null;
System.out.println("image: " +dto.getImage());

if(dto.getImage().isEmpty()) {
	
	NhanVien nhanvien;
	ChucVu chucvu1=new ChucVu();
	chucvu1.setId(chucvu);
		try {
			System.out.println("ngay : " +birthday);
			nhanvien = new NhanVien(id,name,address,phone,d.parse(birthday),gender,degree,image,chucvu,manv);
			nhanVienService.edit(nhanvien);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//nhanVienService.edit(nhanvien);
	
	//nhanVienService.edit(nhanvien);
}else {
	NhanVien staff=null;
	String image2="anh.jpg";
	Path path=Paths.get("uploads/");
	try {
		InputStream inputStream=dto.getImage().getInputStream();
			Files.copy(inputStream,path.resolve(dto.getImage().getOriginalFilename()), 				
					StandardCopyOption.REPLACE_EXISTING);
		image2=dto.getImage().getOriginalFilename().toString();
	} catch (Exception e) {
	//		 TODO: handle exception
			e.printStackTrace(); 
		}
	 try {
		staff=new NhanVien(id,name,address,phone,d.parse(birthday),gender,degree,image2,0,chucvu,manv);
		nhanVienService.edit(staff);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		//nhanVienService.save(staff);

	//NhanVien st=optionalstaff.get();
	//File file=new File("uploads/"+st.getImage());
	//FileInputStream input; 
	//try {
	//	input=new FileInputStream(file);
	//	MultipartFile multiphoto=new MockMultipartFile("file",file.getName(),"text/plain",
	//			IOUtils.toByteArray(input)); 
	//	dto=new NhanViendto(st.getId(),st.getName(),st.getAddress(),st.getPhone(),st.getBirthday(),st.getGender(),
		//		st.getDegree(),multiphoto,
		//		st.getChucvu(),st.getManv()	);
	//} catch (Exception e) {
		// TODO: handle exception
	//	e.printStackTrace();
	//}
	model.addAttribute("dto",dto);
}
//else {
//	model.addAttribute("dto",new NhanViendto());
//}
//model.addAttribute("action","/nhanvien/saveorupdate");
model.addAttribute("list1",nhanVienService.findAll() );
NhanViendto dto2=new NhanViendto();
model.addAttribute("dto",dto2);
return "view-nhanvien";
}
@ModelAttribute("favouriteList")
public List getFavouriteSports()
{
	List favouriteList = new ArrayList();
	favouriteList.add("Football");
	favouriteList.add("Cricket");
	favouriteList.add("Hockey");
	return favouriteList;
}
public static int a=0;
public static int dem=0;
public static int n=0;
public static int k=0;
public static int kk=1;

@RequestMapping("/tiep")
public String tiep(ModelMap model) {
	n=nhanVienService.findAll().size();
	int h=n;
	int l=0;
	while(n>0) {
		dem=dem+1 ;
		n=n-2;
		l=n%2;
	}
	List<NhanVien>ll=new ArrayList<>();	
	if(a>h-1) {
		for(int i=h-l;i<h;i++) {
			ll.add(nhanVienService.findAll().get(i));
			
			
		}
		
		model.addAttribute("toi",dem);
		
	}else {
	if(h<2) {
		model.addAttribute("list1",nhanVienService.findAll() );	
		model.addAttribute("toi",1);
		}else {
	//while(n>0) {
	//	dem=dem+1 ;
	//	n=n-2;
	//	l=n%2;
	//}
	k=dem;
	if(kk<=k) {
//List<NhanVien>ll=new ArrayList<>();	
//nhanVienService.findAll();
		
for(int i=a;i<a+2;i++) {
	ll.add(nhanVienService.findAll().get(i));
}

model.addAttribute("toi",kk);
kk=kk+1;	


a=a+2;
model.addAttribute("list1",ll );
}else {
	for(int i=h-l;i<h;i++) {
		ll.add(nhanVienService.findAll().get(i));
		model.addAttribute("toi",kk);
	}
}}}
	NhanViendto dto=new NhanViendto();
	model.addAttribute("dto",dto);
	return "view-nhanvien";
}
@RequestMapping("/lui")
public String lui(ModelMap model) {
	//n=nhanVienService.findAll().size();
	List<NhanVien>lk=new ArrayList<>();	
	
//	while(n>0) {
//		dem=dem+1 ;
//		n=n-10;
//	}
	//k=dem;
	if(kk>0) {
//List<NhanVien>ll=new ArrayList<>();	
//nhanVienService.findAll();
for(int i=a;i<a-2;i++) {
	lk.add(nhanVienService.findAll().get(i));
}
kk=kk-1;
model.addAttribute("toi",kk);
//kk=kk-1;	


a=a-2;
model.addAttribute("list1",lk );
}else {
	for(int i=0;i<2;i++) {
		lk.add(nhanVienService.findAll().get(i));
		model.addAttribute("toi",kk);
		model.addAttribute("list1",lk );
	}
}
	NhanViendto dto=new NhanViendto();
	model.addAttribute("dto",dto);
	return "view-nhanvien";
}
//md5 trong passs ửod
//<form>
//<input type=checkbox name="id[]" value=1>
//<input type=checkbox name="id[]" value=4>
//<input type=checkbox name="id[]" value=5>
//<input type=checkbox name="id[]" value=6>

//<form>
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@RequestParam("id") int id) {
NhanVien nhanvien =new NhanVien();
nhanvien.setId(id);
nhanVienService.delete(nhanvien);	
model.addAttribute("list1",nhanVienService.findAll());
return "view-nhanvien";
}
}
