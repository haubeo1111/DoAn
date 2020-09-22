package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserChucNang;

@Repository
public interface UserChucNangRepository extends CrudRepository<UserChucNang,Long>{
	@Query(value = "select * from UserChucNang where isdelete=0",nativeQuery=true)
	List<UserChucNang> getAll();
	@Query(value = "select * from UserChucNang where id=? and isdelete=0",nativeQuery=true)
	Optional<UserChucNang> find(long id);
	@Query(value = "select * from UserChucNang where idcn=? and isdelete=0",nativeQuery=true)
	Optional<UserChucNang> findidcn(long id);
	@Query(value = "select * from UserChucNang where iduser=? and isdelete=0",nativeQuery=true)
	List<UserChucNang> findiduser(long id);
	@Query(value = "SELECT * FROM UserChucNang WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<UserChucNang> findup(String name);
}
