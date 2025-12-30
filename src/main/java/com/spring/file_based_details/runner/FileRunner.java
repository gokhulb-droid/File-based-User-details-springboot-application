package com.spring.file_based_details.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.file_based_details.service.FileService;

@Component
public class FileRunner implements CommandLineRunner {

	
	@Autowired
	private FileService fileservice;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("File processing started..");
		
		fileservice.ProcessFile("src/main/resources/file.csv");
		
		System.out.println("File process completed!");
		
	}
	
	
}
