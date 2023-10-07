package com.starking.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

/**
 * @author pedroRhamon
 */

@Service
public class ContractService {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@SneakyThrows
	@Scheduled(fixedRate = 15000)
	@Async
	public void startBatch() {
		
	}

}
