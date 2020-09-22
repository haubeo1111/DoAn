package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.HoadonRepository;
import com.example.demo.models.Hoadon;
@Service
public class HoadonServicesImpl implements HoadonServices{
@Autowired
HoadonRepository hoadonRepository ;

@Override
public List<Hoadon> getAll() {
	return hoadonRepository.getAll();
}

@Override
public Optional<Hoadon> find(long id) {
	return hoadonRepository.find(id);
}

@Override
public List<Hoadon> findup(String name) {
	return hoadonRepository.findup(name);
}

@Override
public List<Hoadon> findlk(String name) {
	return hoadonRepository.findlk(name);
}

@Override
public Hoadon  save(Hoadon entity) {
	return hoadonRepository.save(entity);
}

@Override
public List<Hoadon>  saveAll(List<Hoadon> entities) {
	return (List<Hoadon>) hoadonRepository.saveAll(entities);
}

@Override
public Optional<Hoadon> findById(Long id) {
	return hoadonRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return hoadonRepository.existsById(id);
}

@Override
public List<Hoadon> findAll() {
	return (List<Hoadon>) hoadonRepository.findAll();
}

@Override
public List<Hoadon> findAllById(Iterable<Long> ids) {
	return (List<Hoadon>) hoadonRepository.findAllById(ids);
}

@Override
public long count() {
	return hoadonRepository.count();
}

@Override
public void deleteById(Long id) {
	hoadonRepository.deleteById(id);
}

@Override
public void delete(Hoadon entity) {
	hoadonRepository.delete(entity);
}

@Override
public void deleteAll(List<Hoadon> entities) {
	hoadonRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	hoadonRepository.deleteAll();
}


}
