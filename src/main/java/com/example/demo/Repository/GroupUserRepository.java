package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.models.GroupUser;

@Repository
public interface GroupUserRepository extends CrudRepository<GroupUser,Long>{
	@Query(value = "select * from GroupUser where isdelete=0",nativeQuery=true)
	List<GroupUser> getAll();
	@Query(value = "select * from GroupUser where id=? and isdelete=0",nativeQuery=true)
	Optional<GroupUser> find(int id);
	@Query(value = "SELECT * FROM GroupUser WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<GroupUser> findup(String name);
}
