package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TangCaRepository;
import com.example.demo.models.TangCa;

@Service
public class TangCaServiceImpl implements TangCaService{
@Autowired
TangCaRepository tangCaRepository;

@Override
public List<TangCa> getAll() {
	return tangCaRepository.getAll();
}

@Override
public Optional<TangCa> find(long id) {
	return tangCaRepository.find(id);
}

@Override
public List<TangCa> findup(String name) {
	return tangCaRepository.findup(name);
}

@Override
public TangCa save(TangCa entity) {
	return tangCaRepository.save(entity);
}

@Override
public List<TangCa>  saveAll(List<TangCa> entities) {
	return (List<TangCa>) tangCaRepository.saveAll(entities);
}

@Override
public Optional<TangCa> findById(Long id) {
	return tangCaRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return tangCaRepository.existsById(id);
}

@Override
public List<TangCa> findAll() {
	return (List<TangCa>) tangCaRepository.findAll();
}

@Override
public List<TangCa> findAllById(List<Long> ids) {
	return (List<TangCa>) tangCaRepository.findAllById(ids);
}

@Override
public long count() {
	return tangCaRepository.count();
}

@Override
public void deleteById(Long id) {
	tangCaRepository.deleteById(id);
}

@Override
public void delete(TangCa entity) {
	tangCaRepository.delete(entity);
}

@Override
public void deleteAll(List<TangCa> entities) {
	tangCaRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	tangCaRepository.deleteAll();
}

}
