package com.example.demo.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Repository.NhanVienRepository.EmployeeRowMapper;
import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;
import com.example.demo.models.NhanVien;

@Repository
public class ChucVuRepository {
	
	 public ChucVuRepository() {
		super();
	}
	@Autowired
	    JdbcTemplate jdbcT;
	  class EmployeeRowMapper implements RowMapper <ChucVu> {
	        @Override
	        public ChucVu mapRow(ResultSet rs, int rowNum) throws SQLException {
	          //  NhanVien nhanvien = new NhanVien();
	            ChucVu chucvu=new ChucVu();
	            chucvu.setId(rs.getInt("id"));
	            chucvu.setMacv(rs.getString("macv"));
	            chucvu.setTencv(rs.getString("tencv"));
	            chucvu.setIsdelete(rs.getInt("isdelete"));
	           // nhanvien.setId(rs.getInt("id"));
	           // nhanvien.setName(rs.getString("name"));;
	           // nhanvien.setAddress(rs.getString("address"));;
	           //nhanvien.setPhone(rs.getString("phone"));
	          // nhanvien.setBirthday(rs.getDate("birthday"));
	          // nhanvien.setImage(rs.getString("image"));
	          // nhanvien.setDegree(rs.getString("degree"));
	          // nhanvien.setGender(rs.getBoolean("gender"));
	          // nhanvien.setIsdelete(rs.getInt("isdelete"));
	          // chucvu.set(rs.getString("chucvu"));
	          // chucvu.setMacv(rs.getInt("chucvu"));
	          // nhanvien.setChucvu(chucvu);
	            return chucvu;
	        }
	    }
	  public List<ChucVu> findAll(){
		  String sql="select id,macv,tencv,isdelete from chucvu where isdelete=0";
			RowMapper<ChucVu> row=new EmployeeRowMapper();
			return jdbcT.query(sql,row);
		  }
	  public int save(ChucVu chucvu) {
String sql="INSERT INTO chucvu(id,macv,tencv,isdelete) VALUES (?,?,?,?)";
jdbcT.update(sql,new Object[] {chucvu.getId(),chucvu.getMacv(),chucvu.getTencv(),0});		
return 1;
	  }
	  public Optional <ChucVu> findById(int id) {
	        return Optional.of(jdbcT.queryForObject("select * from chucvu where id=? and isdelete=0", new Object[] {
	                id
	            },
	            new BeanPropertyRowMapper <ChucVu> (ChucVu.class)));
	    }
	  public List<ChucVu> findup(String name){
		  String sql="SELECT * FROM chucvu WHERE tencv @@ to_tsquery("+name+")";
		  RowMapper<ChucVu> row=new EmployeeRowMapper();
		  return jdbcT.query(sql,row);
	  }
	
	  public int edit(ChucVu chucvu) {
		 String sql="update chucvu set macv=?,tencv=? where id=?";
		 jdbcT.update(sql,new Object[] {chucvu.getMacv(),chucvu.getTencv()
				, chucvu.getId()	});
		  return 1; 
	  }
	 public int delete(ChucVu chucvu) {
		 String sql="update chucvu set isdelete=1 where id=?";
		 jdbcT.update(sql,new Object[] {chucvu.getId()});
		 return 1;
	 }
	 
}
