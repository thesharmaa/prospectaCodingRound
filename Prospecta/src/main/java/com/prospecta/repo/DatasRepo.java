package com.prospecta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.entity.Datas;
@Repository
public interface DatasRepo extends JpaRepository<Datas, String>{

	public List<Datas> findByCategory(String category);
}
