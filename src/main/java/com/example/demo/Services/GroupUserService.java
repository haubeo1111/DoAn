package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.GroupUser;

public interface GroupUserService {

	void deleteAll();

	void deleteAll(List<GroupUser> entities);

	void delete(GroupUser entity);

	void deleteById(Long id);

	long count();

	List<GroupUser> findAllById(List<Long> ids);

	List<GroupUser> findAll();

	boolean existsById(Long id);

	Optional<GroupUser> findById(Long id);

	List<GroupUser> saveAll(List<GroupUser> entities);

	List<GroupUser> findup(String name);

	GroupUser save(GroupUser entity);

	

	List<GroupUser> getAll();

	

}
