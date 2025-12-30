package com.spring.file_based_details.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.file_based_details.entity.FileEntity;
import com.spring.file_based_details.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	private FileRepository fileRepository;
	
	public void ProcessFile(String filepath) throws Exception{
		
		List<String> lines = Files.readAllLines(Paths.get(filepath));
		
		lines.stream().skip(1)
			.forEach( line -> {
				String[] data = line.split(",");
				
				String name = data[0];
				String email = data[1];
				Double salary = Double.parseDouble(data[2]);
				
				// Update if exists else CREATE
				
				FileEntity file = fileRepository.findByEmail(email)
						.orElse(new FileEntity());
				
				file.setName(name);
				file.setEmail(email);
				file.setSalary(salary);
				
				fileRepository.save(file); // create or update
			
			});
	}
	
	public void deleteEmployee(Long id) {
		fileRepository.deleteById(id);
		
	}
}
