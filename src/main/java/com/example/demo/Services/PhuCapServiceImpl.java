package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PhuCapRepository;
import com.example.demo.models.PhuCap;

@Service
public class PhuCapServiceImpl implements PhuCapService{
@Autowired
PhuCapRepository phuCapRepository;

@Override
public List<PhuCap> getAll() {
	return phuCapRepository.getAll();
}

@Override
public Optional<PhuCap> find(int id) {
	return phuCapRepository.find(id);
}

@Override
public List<PhuCap> findup(String name) {
	return phuCapRepository.findup(name);
}

@Override
public PhuCap save(PhuCap entity) {
	return phuCapRepository.save(entity);
}

@Override
public List<PhuCap>  saveAll(List<PhuCap> entities) {
	return (List<PhuCap>) phuCapRepository.saveAll(entities);
}

@Override
public Optional<PhuCap> findById(Long id) {
	return phuCapRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return phuCapRepository.existsById(id);
}

@Override
public List<PhuCap> findAll() {
	return (List<PhuCap>) phuCapRepository.findAll();
}

@Override
public List<PhuCap> findAllById(List<Long> ids) {
	return (List<PhuCap>) phuCapRepository.findAllById(ids);
}

@Override
public long count() {
	return phuCapRepository.count();
}

@Override
public void deleteById(Long id) {
	phuCapRepository.deleteById(id);
}

@Override
public void delete(PhuCap entity) {
	phuCapRepository.delete(entity);
}

@Override
public void deleteAll(List<PhuCap> entities) {
	phuCapRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	phuCapRepository.deleteAll();
}

}
