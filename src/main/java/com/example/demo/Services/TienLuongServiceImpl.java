package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TienLuongRepository;
import com.example.demo.models.TienLuong;

@Service
public class TienLuongServiceImpl implements TienLuongService{
@Autowired
TienLuongRepository tienLuongRepository;

@Override
public List<TienLuong> getAll() {
	return tienLuongRepository.getAll();
}

@Override
public int ngaylam(Long id) {
	return tienLuongRepository.ngaylam(id);
}

@Override
public Optional<TienLuong> find(long id) {
	return tienLuongRepository.find(id);
}

@Override
public List<TienLuong> findup(String name) {
	return tienLuongRepository.findup(name);
}

@Override
public TienLuong save(TienLuong entity) {
	return tienLuongRepository.save(entity);
}

@Override
public List<TienLuong>  saveAll(List<TienLuong> entities) {
	return (List<TienLuong>) tienLuongRepository.saveAll(entities);
}

@Override
public Optional<TienLuong> findById(Long id) {
	return tienLuongRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return tienLuongRepository.existsById(id);
}

@Override
public List<TienLuong> findAll() {
	return (List<TienLuong>) tienLuongRepository.findAll();
}

@Override
public List<TienLuong> findAllById(List<Long> ids) {
	return (List<TienLuong>) tienLuongRepository.findAllById(ids);
}

@Override
public long count() {
	return tienLuongRepository.count();
}

@Override
public void deleteById(Long id) {
	tienLuongRepository.deleteById(id);
}

@Override
public void delete(TienLuong entity) {
	tienLuongRepository.delete(entity);
}

@Override
public void deleteAll(List<TienLuong> entities) {
	tienLuongRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	tienLuongRepository.deleteAll();
}

}
