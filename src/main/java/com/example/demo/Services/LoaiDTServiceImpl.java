package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoaiDTRepository;
import com.example.demo.models.LoaiDT;

@Service
public class LoaiDTServiceImpl implements LoaiDTService {
@Autowired
LoaiDTRepository loaiDTRepository;

@Override
public List<LoaiDT> getAll() {
	return loaiDTRepository.getAll();
}

@Override
public Optional<LoaiDT> find(String id) {
	return loaiDTRepository.find(id);
}

@Override
public List<LoaiDT> findup(String name) {
	return loaiDTRepository.findup(name);
}

@Override
public List<LoaiDT> findlk(String name) {
	return loaiDTRepository.findlk(name);
}

@Override
public LoaiDT save(LoaiDT entity) {
	return loaiDTRepository.save(entity);
}

@Override
public List<LoaiDT>  saveAll(List<LoaiDT> entities) {
	return (List<LoaiDT>) loaiDTRepository.saveAll(entities);
}

@Override
public Optional<LoaiDT> findById(String id) {
	return loaiDTRepository.findById(id);
}

@Override
public boolean existsById(String id) {
	return loaiDTRepository.existsById(id);
}

@Override
public List<LoaiDT> findAll() {
	return (List<LoaiDT>) loaiDTRepository.findAll();
}

@Override
public List<LoaiDT> findAllById(List<String> ids) {
	return (List<LoaiDT>) loaiDTRepository.findAllById(ids);
}

//@Override
//public String count() {
//	return loaiDTRepository.count();
//}

@Override
public void deleteById(String id) {
	loaiDTRepository.deleteById(id);
}

@Override
public void delete(LoaiDT entity) {
	loaiDTRepository.delete(entity);
}

@Override
public void deleteAll(List<LoaiDT> entities) {
	loaiDTRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	loaiDTRepository.deleteAll();
}

}
