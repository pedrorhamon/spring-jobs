package com.starking.batch.controllers;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.RestController;

import com.starking.batch.repositories.ContractRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pedroRhamon
 */

@RestController
@RequiredArgsConstructor
public class ContractController {

	private final ContractRepository contractRepository;
	
	private final JobLauncher jobLauncher;
	
	private final Job job;
	
	
}
