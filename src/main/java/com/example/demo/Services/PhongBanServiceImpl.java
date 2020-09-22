package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PhongBanRepository;
import com.example.demo.models.PhongBan;

@Service
public class PhongBanServiceImpl implements PhongBanService{
	@Autowired
	PhongBanRepository PhongBanRepository;

	@Override
	public List<PhongBan> getAll() {
		return PhongBanRepository.getAll();
	}

	@Override
	public Optional<PhongBan> find(long id) {
		return PhongBanRepository.find(id);
	}

	@Override
	public PhongBan save(PhongBan entity) {
		return PhongBanRepository.save(entity);
	}

	@Override
	public List<PhongBan> findup(String name) {
		return PhongBanRepository.findup(name);
	}

	@Override
	public List<PhongBan> findlk(String name) {
		return PhongBanRepository.findlk(name);
	}

	@Override
	public List<PhongBan>  saveAll(List<PhongBan> entities) {
		return (List<PhongBan>) PhongBanRepository.saveAll(entities);
	}

	@Override
	public List<PhongBan> findByNameLike(String name) {
		return PhongBanRepository.findByNameLike(name);
	}

	@Override
	public Optional<PhongBan> findById(Long id) {
		return PhongBanRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return PhongBanRepository.existsById(id);
	}

	@Override
	public List<PhongBan> findAll() {
		return (List<PhongBan>) PhongBanRepository.findAll();
	}

	@Override
	public List<PhongBan> findAllById(List<Long> ids) {
		return (List<PhongBan>) PhongBanRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return PhongBanRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		PhongBanRepository.deleteById(id);
	}

	@Override
	public void delete(PhongBan entity) {
		PhongBanRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<PhongBan> entities) {
		PhongBanRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		PhongBanRepository.deleteAll();
	}
}
