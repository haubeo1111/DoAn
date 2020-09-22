package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoaiKMRepository;
import com.example.demo.models.LoaiKM;

@Service
public class LoaiKMServiceImpl implements LoaiKMService {
@Autowired
LoaiKMRepository loaiKMRepository;

@Override
public List<LoaiKM> getAll() {
	return loaiKMRepository.getAll();
}

@Override
public Optional<LoaiKM> find(int id) {
	return loaiKMRepository.find(id);
}

@Override
public List<LoaiKM> findup(String name) {
	return loaiKMRepository.findup(name);
}

@Override
public LoaiKM save(LoaiKM entity) {
	return loaiKMRepository.save(entity);
}

@Override
public List<LoaiKM>  saveAll(List<LoaiKM>  entities) {
	return (List<LoaiKM>) loaiKMRepository.saveAll(entities);
}

@Override
public Optional<LoaiKM> findById(Integer id) {
	return loaiKMRepository.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return loaiKMRepository.existsById(id);
}

@Override
public List<LoaiKM> findAll() {
	return (List<LoaiKM>) loaiKMRepository.findAll();
}

@Override
public List<LoaiKM> findAllById(Iterable<Integer> ids) {
	return (List<LoaiKM>) loaiKMRepository.findAllById(ids);
}

@Override
public long count() {
	return loaiKMRepository.count();
}

@Override
public void deleteById(Integer id) {
	loaiKMRepository.deleteById(id);
}

@Override
public void delete(LoaiKM entity) {
	loaiKMRepository.delete(entity);
}

@Override
public void deleteAll(List<LoaiKM> entities) {
	loaiKMRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	loaiKMRepository.deleteAll();
}

}
