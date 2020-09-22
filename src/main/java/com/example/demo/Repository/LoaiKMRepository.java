package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LoaiKM;
import com.example.demo.models.LoaiKM;

@Repository
public interface LoaiKMRepository extends CrudRepository<LoaiKM,Integer> {
	@Query(value = "select * from loaiKM where isdelete=0",nativeQuery=true)
	List<LoaiKM> getAll();
	@Query(value = "select * from loaiKM where id=? and isdelete=0",nativeQuery=true)
	Optional<LoaiKM> find(int id);
	@Query(value = "SELECT * FROM loaiKM WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<LoaiKM> findup(String name);
}
