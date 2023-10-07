package com.starking.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pedroRhamon
 */

@Configuration
public class BatchConfigurer  extends DefaultBatchConfiguration {
	
	@Bean
	public Job startBatch() {
		
	}

}
