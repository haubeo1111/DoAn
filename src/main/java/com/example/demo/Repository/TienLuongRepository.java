package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TienLuong;

@Repository
public interface TienLuongRepository extends CrudRepository<TienLuong,Long>{
	@Query(value = "select * from TienLuong where isdelete=0",nativeQuery=true)
	List<TienLuong> getAll();
	@Query(value = "select * from TienLuong where id=? and isdelete=0",nativeQuery=true)
	Optional<TienLuong> find(long id);
	@Query(value = "SELECT * FROM TienLuong WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<TienLuong> findup(String name);
	
	@Query(value="select count(bcc.ngaycham) from bangchamcong bcc inner join employee el on el.id=bcc.idemployee where bcc.tinhtrang=1 and bcc.isdelete=0 and el.id=? and bcc.ngaycham < now() and  bcc.ngaycham >= (now()-INTERVAL '30 days')",nativeQuery=true)
	int ngaylam(Long id);
	@Query(value="select count(bcc.ngaycham) from bangchamcong bcc inner join employee el on el.id=bcc.idemployee where bcc.tinhtrang=1 and bcc.isdelete=0 and el.id=? and bcc.ngaycham <  ?  and  bcc.ngaycham >=?",nativeQuery=true)
	int ngaylams(Long id,Date ngaycuoi,Date ngaydau);
	@Query(value="SELECT * FROM TienLuong",nativeQuery=true)
	  Page<TienLuong> findall1(Pageable pageable);
}
