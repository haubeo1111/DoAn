package com.example.demo.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ChucVu;
import com.example.demo.models.NhanVien;





@Repository
public class NhanVienRepository {
	  @Autowired
	    JdbcTemplate jdbcT;
	  class EmployeeRowMapper implements RowMapper <NhanVien> {
	        @Override
	        public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
	            NhanVien nhanvien = new NhanVien();
	           // ChucVu chucvu=new ChucVu();
	            nhanvien.setId(rs.getInt("id"));
	            nhanvien.setName(rs.getString("name"));;
	            nhanvien.setAddress(rs.getString("address"));;
	           nhanvien.setPhone(rs.getString("phone"));
	           nhanvien.setBirthday(rs.getDate("birthday"));
	           nhanvien.setImage(rs.getString("image"));
	           nhanvien.setDegree(rs.getString("degree"));
	           nhanvien.setGender(rs.getInt("gender"));
	           nhanvien.setIsdelete(rs.getInt("isdelete"));
	          // chucvu.set(rs.getString("chucvu"));
	         //  chucvu.setId(rs.getInt("chucvuid"));;
	           nhanvien.setChucvu(rs.getInt("chucvuid"));
	           nhanvien.setManv(rs.getString("manv"));
	            return nhanvien;
	        }
	    }
	  public List<NhanVien> findAll(){
		  String sql="select * from nhanvien where isdelete=0";
			RowMapper<NhanVien> row=new EmployeeRowMapper();
			return jdbcT.query(sql,row);
		  }
	  public int save(NhanVien nhanvien) {
String sql="INSERT INTO nhanvien(id,name,address,phone,image,isdelete,degree,chucvuid,birthday,gender,manv) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
jdbcT.update(sql,new Object[] {nhanvien.getId(),nhanvien.getName(),nhanvien.getAddress(),nhanvien.getPhone()
		,nhanvien.getImage(),0,nhanvien.getDegree(),nhanvien.getChucvu(),nhanvien.getBirthday(),nhanvien.getGender(),nhanvien.getManv()});		
return 1;
	  }
	  public Optional <NhanVien> findById(int id) {
	        return Optional.of(jdbcT.queryForObject("select * from nhanvien where id=? and isdelete=0", new Object[] {
	                id
	            },
	            new BeanPropertyRowMapper <NhanVien> (NhanVien.class)));
	    }
	  public int edit(NhanVien nhanvien) {
		 String sql="update nhanvien set name=?,address=?,phone=?,image=?,degree=?,chucvuid=?,birthday=?,gender=?,manv=? where id=?";
		 jdbcT.update(sql,new Object[] {nhanvien.getName(),nhanvien.getAddress(),nhanvien.getPhone()
					,nhanvien.getImage(),nhanvien.getDegree(),nhanvien.getChucvu(),nhanvien.getBirthday(),nhanvien.getGender(),nhanvien.getManv(),nhanvien.getId()});
		  return 1; 
	  }
	 public int delete(NhanVien nhanvien) {
		 String sql="update nhanvien set isdelete=1 where id=?";
		 jdbcT.update(sql,new Object[] {nhanvien.getId()});
		 return 1;
	 }
}
