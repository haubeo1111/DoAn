package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TKLoaiDTRepository;
import com.example.demo.models.TKLoaiDT;

@Service
public class TKLoaiDTServiceImpl implements TKLoaiDTService {
@Autowired
TKLoaiDTRepository tkLoaiDTRepository;

@Override
public List<TKLoaiDT> getAll() {
	return tkLoaiDTRepository.getAll();
}

@Override
public Optional<TKLoaiDT> find(long id) {
	return tkLoaiDTRepository.find(id);
}

@Override
public List<TKLoaiDT> findup(String name) {
	return tkLoaiDTRepository.findup(name);
}

@Override
public List<TKLoaiDT> findlk(String name) {
	return tkLoaiDTRepository.findlk(name);
}

@Override
public TKLoaiDT save(TKLoaiDT entity) {
	return tkLoaiDTRepository.save(entity);
}



@Override
public List<TKLoaiDT>  saveAll(List<TKLoaiDT> entities) {
	return (List<TKLoaiDT>) tkLoaiDTRepository.saveAll(entities);
}

@Override
public Optional<TKLoaiDT> findById(Long id) {
	return tkLoaiDTRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return tkLoaiDTRepository.existsById(id);
}

@Override
public List<TKLoaiDT> findAll() {
	return (List<TKLoaiDT>) tkLoaiDTRepository.findAll();
}

@Override
public List<TKLoaiDT> findAllById(List<Long> ids) {
	return (List<TKLoaiDT>) tkLoaiDTRepository.findAllById(ids);
}

@Override
public long count() {
	return tkLoaiDTRepository.count();
}

@Override
public void deleteById(Long id) {
	tkLoaiDTRepository.deleteById(id);
}

@Override
public void delete(TKLoaiDT entity) {
	tkLoaiDTRepository.delete(entity);
}

@Override
public void deleteAll(List<TKLoaiDT> entities) {
	tkLoaiDTRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	tkLoaiDTRepository.deleteAll();
}

}
