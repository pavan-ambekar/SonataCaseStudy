package com.sonata.Reoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonata.Model.Diseases;

@Repository
public interface DiseasesRepoisitory extends JpaRepository<Diseases, Long> {

	@Modifying
	@Transactional
	@Query(
			value = "UPDATE diseases SET dis_name = :name WHERE disid = :id",
			nativeQuery = true
			)
	int updateDiseasesById(Long id, String name);
}
