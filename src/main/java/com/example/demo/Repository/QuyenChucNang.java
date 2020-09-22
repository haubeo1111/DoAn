package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Login;
import com.example.demo.models.QLUser;

@Repository
public interface QuyenChucNang extends CrudRepository<QLUser,Long>{
	@Query(value = "select qus.tendangnhap from qluser qus\r\n" + 
			"inner join userchucnang ucn on qus.id=ucn.iduser\r\n" + 
			"inner join chucnang cn on cn.id=ucn.idcn\r\n" + 
			"inner join vaitro vt on vt.id=qus.idvaitro\r\n" + 
			"inner join vaitrochucnang vtc on vtc.idvt=vt.id\r\n" + 
			"inner join groupuser gu on gu.id=qus.idgroupuser\r\n" + 
			"inner join groupusercn gucn on gucn.idgroupuser=gu.id\r\n" + 
			"where cn.cnurl=? and qus.isdelete=0 \r\n" + 
			"group by qus.tendangnhap",nativeQuery=true)
	List<String> getAll(String url);
}
