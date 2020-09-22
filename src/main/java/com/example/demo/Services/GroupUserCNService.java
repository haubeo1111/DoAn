package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.GroupUserCN;

public interface GroupUserCNService {

	void deleteAll();

	void deleteAll(List<GroupUserCN> entities);

	void delete(GroupUserCN entity);

	void deleteById(Long id);

	long count();

	List<GroupUserCN> findAllById(List<Long> ids);

	List<GroupUserCN> findAll();

	boolean existsById(Long id);

	Optional<GroupUserCN> findById(Long id);

	List<GroupUserCN> saveAll(List<GroupUserCN> entities);

	GroupUserCN save(GroupUserCN entity);

	List<GroupUserCN> findup(String name);

	List<GroupUserCN> findiduser(long id);

	Optional<GroupUserCN> findidcn(long id);

	Optional<GroupUserCN> find(long id);

	List<GroupUserCN> getAll();

}
