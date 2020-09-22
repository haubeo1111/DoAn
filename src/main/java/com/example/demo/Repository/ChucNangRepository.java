package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ChucNang;


@Repository
public interface ChucNangRepository extends CrudRepository<ChucNang,Long>{
	@Query(value = "select * from ChucNang where isdelete=0 order by cncha",nativeQuery=true)
	List<ChucNang> getAll();
	@Query(value = "select * from ChucNang where id=? and isdelete=0",nativeQuery=true)
	Optional<ChucNang> find(Long id);
	@Query(value = "SELECT * FROM ChucNang WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<ChucNang> findup(String name);
}
