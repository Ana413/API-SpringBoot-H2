package com.example.projeto.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.repository.entity.ProjetoApiEntity;

@Repository
public interface ProjetoApiRepository extends PagingAndSortingRepository<ProjetoApiEntity, Integer>{

	public List<ProjetoApiEntity> findAll();
}
