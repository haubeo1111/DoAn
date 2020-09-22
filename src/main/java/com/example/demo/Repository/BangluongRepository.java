package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.BangLuong;
import com.example.demo.models.Hoadon;
@Repository
public interface BangluongRepository extends CrudRepository<BangLuong,Integer>{
	@Query(value = "select * from bangluong where isdelete=0",nativeQuery=true)
	List<BangLuong> getAll();
	@Query(value = "select * from bangluong where id=? and isdelete=0",nativeQuery=true)
	Optional<BangLuong> find(int id);
	@Query(value = "SELECT * FROM BangLuong WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<BangLuong> findup(String name);
}
