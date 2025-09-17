package com.gabyferrari.send_book_email_spring_batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gabyferrari.send_book_email_spring_batch.domain.UserBookLoan;

@Configuration
public class SendEmailRequestReturnWriterConfig {
	
	@Bean
	ItemWriter<UserBookLoan> sendEmailRequestReturnWriter() {
		return items -> items.forEach(System.out::println);
	}

}
