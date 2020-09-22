package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.GroupUserCN;
@Repository
public interface GroupUserCNRepository extends CrudRepository<GroupUserCN,Long>{
	@Query(value = "select * from GroupUserCN where isdelete=0",nativeQuery=true)
	List<GroupUserCN> getAll();
	@Query(value = "select * from GroupUserCN where id=? and isdelete=0",nativeQuery=true)
	Optional<GroupUserCN> find(long id);
	@Query(value = "select * from GroupUserCN where idcn=? and isdelete=0",nativeQuery=true)
	Optional<GroupUserCN> findidcn(long id);
	@Query(value = "select * from GroupUserCN where idgroupuser=? and isdelete=0",nativeQuery=true)
	List<GroupUserCN> findiduser(long id);
	@Query(value = "SELECT * FROM GroupUserCN WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<GroupUserCN> findup(String name);
}
