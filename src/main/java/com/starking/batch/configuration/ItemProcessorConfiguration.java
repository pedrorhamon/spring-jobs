package com.starking.batch.configuration;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starking.batch.model.Contract;
import com.starking.batch.model.ContractHistory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pedroRhamon
 */

@Configuration
@Slf4j
public class ItemProcessorConfiguration {

	private AtomicInteger count = new AtomicInteger();

	private ObjectMapper mapper = new ObjectMapper();

	@Bean
	public ItemProcessor<Contract, ContractHistory> itemProcessor() {
		return new ItemProcessor<Contract, ContractHistory>() {

			@Override
			public ContractHistory process(Contract item) throws Exception {
				log.info("processing the data " + item.getContractId() + " Record No :" + count.incrementAndGet());
				return mapper.convertValue(item, ContractHistory.class);
			}
		};
	}

}
