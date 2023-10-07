package com.starking.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pedroRhamon
 */

@Configuration
public class BatchConfigurer  extends DefaultBatchConfiguration {
	
	@Bean
	public Job startBatch(JobBuilderFactory jobBuilderFactory, Step step1) {
		return jobBuilderFactory.get("contractEffective")
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.build();
	}

}
