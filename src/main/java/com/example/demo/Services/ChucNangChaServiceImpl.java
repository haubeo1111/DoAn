package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ChucNangChaRepository;
import com.example.demo.models.ChucNangCha;

@Service
public class ChucNangChaServiceImpl implements ChucNangChaService {
@Autowired
ChucNangChaRepository ChucNangChaRepository;

@Override
public List<ChucNangCha> getAll() {
	return ChucNangChaRepository.getAll();
}

@Override
public Optional<ChucNangCha> find(int id) {
	return ChucNangChaRepository.find(id);
}

@Override
public List<ChucNangCha> findup(String name) {
	return ChucNangChaRepository.findup(name);
}

@Override
public ChucNangCha save(ChucNangCha entity) {
	return ChucNangChaRepository.save(entity);
}

@Override
public List<ChucNangCha>  saveAll(List<ChucNangCha> entities) {
	return (List<ChucNangCha>) ChucNangChaRepository.saveAll(entities);
}

@Override
public Optional<ChucNangCha> findById(Long id) {
	return ChucNangChaRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return ChucNangChaRepository.existsById(id);
}

@Override
public List<ChucNangCha> findAll() {
	return (List<ChucNangCha>) ChucNangChaRepository.findAll();
}

@Override
public List<ChucNangCha> findAllById(List<Long> ids) {
	return (List<ChucNangCha>) ChucNangChaRepository.findAllById(ids);
}

@Override
public long count() {
	return ChucNangChaRepository.count();
}

@Override
public void deleteById(Long id) {
	ChucNangChaRepository.deleteById(id);
}

@Override
public void delete(ChucNangCha entity) {
	ChucNangChaRepository.delete(entity);
}

@Override
public void deleteAll(List<ChucNangCha> entities) {
	ChucNangChaRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	ChucNangChaRepository.deleteAll();
}

}

