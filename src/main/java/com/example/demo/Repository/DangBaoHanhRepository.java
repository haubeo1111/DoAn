package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DangBaoHanh;
import com.example.demo.models.DangBaoHanh;

@Repository
public interface DangBaoHanhRepository extends CrudRepository<DangBaoHanh,Long> {
	@Query(value = "select * from DangBaoHanh where isdelete=0",nativeQuery=true)
	List<DangBaoHanh> getAll();
	@Query(value = "select * from DangBaoHanh where id=? and isdelete=0",nativeQuery=true)
	Optional<DangBaoHanh> find(long id);
	@Query(value = "SELECT * FROM DangBaoHanh WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<DangBaoHanh> findup(String name);
}
