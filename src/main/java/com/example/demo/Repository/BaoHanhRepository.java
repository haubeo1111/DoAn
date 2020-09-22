package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.models.BaoHanh;

@Repository
public interface BaoHanhRepository extends CrudRepository<BaoHanh,Long>{
	@Query(value = "select * from baohanh where isdelete=0",nativeQuery=true)
	List<BaoHanh> getAll();
	@Query(value = "select * from baohanh where id=? and isdelete=0",nativeQuery=true)
	Optional<BaoHanh> find(int id);
	@Query(value = "select * from baohanh where mabh=? and isdelete=0",nativeQuery=true)
	Optional<BaoHanh> findma(String mabh);
	@Query(value = "SELECT * FROM baohanh WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<BaoHanh> findup(String name);
}
