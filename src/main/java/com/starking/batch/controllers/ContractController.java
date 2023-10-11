package com.starking.batch.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.batch.model.Contract;
import com.starking.batch.repositories.ContractRepository;

import lombok.SneakyThrows;

/**
 * @author pedroRhamon
 */

@RestController
public class ContractController {

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@GetMapping("/insert")
	public String saveDummyData() {
		List<Contract> contractList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			Contract contract = new Contract();
			contract.setHolderName("name-" + i);
			contract.setDuration(new Random().nextInt());
			contract.setAmount(new Random().nextInt(500000));
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, new Random().nextInt(2020));
			calendar.set(Calendar.MONTH, new Random().nextInt(12));
			calendar.set(Calendar.DAY_OF_MONTH, new Random().nextInt(30) + 1);
			Date startDate = calendar.getTime();
			contract.setCreationDate(startDate);
			contract.setStatus("InProgress");
			contractList.add(contract);
		}
		this.contractRepository.saveAll(contractList);
		return "saved successfully";
	}

	@GetMapping("/start-batch")
	@SneakyThrows
	public String startBatch() {

		JobParameters jobParameter = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();

		this.jobLauncher.run(job, jobParameter);

		return "batch started...";
	}

}
