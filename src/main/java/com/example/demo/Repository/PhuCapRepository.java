package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PhuCap;
import com.example.demo.models.PhuCap;

@Repository
public interface PhuCapRepository extends CrudRepository<PhuCap,Long>{
	@Query(value = "select * from PhuCap where isdelete=0",nativeQuery=true)
	List<PhuCap> getAll();
	@Query(value = "select * from PhuCap where id=? and isdelete=0",nativeQuery=true)
	Optional<PhuCap> find(int id);
	@Query(value = "SELECT * FROM PhuCap WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<PhuCap> findup(String name);
}
