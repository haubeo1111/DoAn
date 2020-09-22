package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ChucNangCha;

@Repository
public interface ChucNangChaRepository extends CrudRepository<ChucNangCha,Long>{
	@Query(value = "select * from ChucNangCha where isdelete=0",nativeQuery=true)
	List<ChucNangCha> getAll();
	@Query(value = "select * from ChucNangCha where id=? and isdelete=0",nativeQuery=true)
	Optional<ChucNangCha> find(int id);
	@Query(value = "SELECT * FROM ChucNangCha WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<ChucNangCha> findup(String name);
}
