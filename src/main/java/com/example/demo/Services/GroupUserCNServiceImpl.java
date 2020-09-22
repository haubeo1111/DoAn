package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.GroupUserCNRepository;
import com.example.demo.Repository.GroupUserRepository;
import com.example.demo.models.GroupUser;
import com.example.demo.models.GroupUserCN;

@Service
public class GroupUserCNServiceImpl implements GroupUserCNService{
@Autowired
GroupUserCNRepository groupUserCNRepository;

@Override
public List<GroupUserCN> getAll() {
	return groupUserCNRepository.getAll();
}

@Override
public Optional<GroupUserCN> find(long id) {
	return groupUserCNRepository.find(id);
}

@Override
public Optional<GroupUserCN> findidcn(long id) {
	return groupUserCNRepository.findidcn(id);
}

@Override
public List<GroupUserCN> findiduser(long id) {
	return groupUserCNRepository.findiduser(id);
}

@Override
public List<GroupUserCN> findup(String name) {
	return groupUserCNRepository.findup(name);
}

@Override
public GroupUserCN save(GroupUserCN entity) {
	return groupUserCNRepository.save(entity);
}

@Override
public List<GroupUserCN>  saveAll( List<GroupUserCN> entities) {
	return (List<GroupUserCN>) groupUserCNRepository.saveAll(entities);
}

@Override
public Optional<GroupUserCN> findById(Long id) {
	return groupUserCNRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return groupUserCNRepository.existsById(id);
}

@Override
public List<GroupUserCN> findAll() {
	return (List<GroupUserCN>) groupUserCNRepository.findAll();
}

@Override
public List<GroupUserCN> findAllById(List<Long> ids) {
	return (List<GroupUserCN>) groupUserCNRepository.findAllById(ids);
}

@Override
public long count() {
	return groupUserCNRepository.count();
}

@Override
public void deleteById(Long id) {
	groupUserCNRepository.deleteById(id);
}

@Override
public void delete(GroupUserCN entity) {
	groupUserCNRepository.delete(entity);
}

@Override
public void deleteAll(List<GroupUserCN> entities) {
	groupUserCNRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	groupUserCNRepository.deleteAll();
}



}
