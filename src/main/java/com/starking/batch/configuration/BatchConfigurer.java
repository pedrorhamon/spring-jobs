package com.starking.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.starking.batch.model.Contract;
import com.starking.batch.model.ContractHistory;

/**
 * @author pedroRhamon
 */

@Configuration
@SuppressWarnings("removal")
public class BatchConfigurer  extends DefaultBatchConfigurer {
	
	@Bean
	public Job startBatch( JobBuilderFactory jobBuilderFactory, Step step1) {
		return jobBuilderFactory.get("contractEffective")
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.build();
	}
	
	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory,
			ItemReader<Contract> itemReader,
            ItemProcessor<Contract, ContractHistory> itemProcessor,
            ItemWriter<ContractHistory> itemWriter) {
		return stepBuilderFactory.get("step1")
				.<Contract, ContractHistory>chunk(1000)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}

}
