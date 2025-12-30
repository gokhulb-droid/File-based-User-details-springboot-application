package com.spring.file_based_details.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file_based_details.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long>{
	Optional<FileEntity> findByEmail(String email);
}
