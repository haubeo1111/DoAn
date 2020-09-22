package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.GroupUserRepository;
import com.example.demo.models.GroupUser;

@Service
public class GroupUserServiceImpl implements GroupUserService{
@Autowired
GroupUserRepository GroupUserRepository;

@Override
public List<GroupUser> getAll() {
	return GroupUserRepository.getAll();
}


@Override
public GroupUser save(GroupUser entity) {
	return GroupUserRepository.save(entity);
}

@Override
public List<GroupUser> findup(String name) {
	return GroupUserRepository.findup(name);
}


@Override
public List<GroupUser>  saveAll(List<GroupUser> entities) {
	return (List<GroupUser>) GroupUserRepository.saveAll(entities);
}


@Override
public Optional<GroupUser> findById(Long id) {
	return GroupUserRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return GroupUserRepository.existsById(id);
}

@Override
public List<GroupUser> findAll() {
	return (List<GroupUser>) GroupUserRepository.findAll();
}

@Override
public List<GroupUser> findAllById(List<Long> ids) {
	return (List<GroupUser>) GroupUserRepository.findAllById(ids);
}

@Override
public long count() {
	return GroupUserRepository.count();
}

@Override
public void deleteById(Long id) {
	GroupUserRepository.deleteById(id);
}

@Override
public void delete(GroupUser entity) {
	GroupUserRepository.delete(entity);
}

@Override
public void deleteAll(List<GroupUser> entities) {
	GroupUserRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	GroupUserRepository.deleteAll();
}

}
