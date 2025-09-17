package com.gabyferrari.send_book_email_spring_batch.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gabyferrari.send_book_email_spring_batch.job.SendBookLoanNotificationScheduleJob;

@Configuration
public class QuartzConfig {

	@Bean
	JobDetail quartzJobDetail() {
		return JobBuilder.newJob(SendBookLoanNotificationScheduleJob.class).storeDurably().build();
	}

	@Bean
	Trigger jobTrigger() {
		String exp = "0 03 16 * * ?";
		return TriggerBuilder
				.newTrigger()
				.forJob(quartzJobDetail())
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(exp))
				.build();
	}
}
