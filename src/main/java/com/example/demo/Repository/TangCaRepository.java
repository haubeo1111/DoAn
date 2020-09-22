package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TangCa;
import com.example.demo.models.TangCa;

@Repository
public interface TangCaRepository extends CrudRepository<TangCa,Long>{
	@Query(value = "select * from TangCa where isdelete=0",nativeQuery=true)
	List<TangCa> getAll();
	@Query(value = "select * from TangCa where id=? and isdelete=0",nativeQuery=true)
	Optional<TangCa> find(long id);
	@Query(value = "SELECT * FROM TangCa WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<TangCa> findup(String name);
}
