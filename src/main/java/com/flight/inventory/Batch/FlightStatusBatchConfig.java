package com.flight.inventory.Batch;

import com.flight.inventory.Enums.FlightStatus;
import com.flight.inventory.Models.Flights;
import com.flight.inventory.Repository.FlightJdbcWriter;
import com.flight.inventory.Repository.FlightJdbcReader;
import com.flight.inventory.Repository.FlightRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;

@Configuration
@EnableBatchProcessing
public class FlightStatusBatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private FlightRepository flightRepository;

    @Bean
    public Job updateFlightStatusJob() {
        return new JobBuilder("updateFlightStatusJob",jobRepository)
                .start(updateFlightStatusStep())
                .build();
    }

    @Bean
    public Step updateFlightStatusStep() {
        return new StepBuilder("updateFlightStatusStep", jobRepository)
                .<Flights, Flights>chunk(10, platformTransactionManager)
                .reader(flightItemReader())
                .processor(flightItemProcessor())
                .writer(flightItemWriter())
                .build();
    }

    @Bean
    public ItemReader<Flights> flightItemReader() {
        return new FlightJdbcReader(flightRepository);
    }

    @Bean
    public ItemProcessor<Flights,Flights> flightItemProcessor() {
        return flight-> {
            LocalDateTime now=LocalDateTime.now();
            if(flight.getDepartureTime().isAfter(now)) {
                if (flight.getDepartureTime().minusMinutes(30).isBefore(now)) {
                    flight.setStatus(FlightStatus.BOARDING);
                } else {
                    flight.setStatus(FlightStatus.SCHEDULED);
                }
            }
            else if(flight.getDepartureTime().isBefore(now) && flight.getArrivalTime().isAfter(now))
            {
                flight.setStatus(FlightStatus.INFLIGHT);
            }
            else if(flight.getArrivalTime().isBefore(now))
            {
                flight.setStatus(FlightStatus.LANDED);
            }
            return flight;
        };
    }

    @Bean
    public ItemWriter<Flights> flightItemWriter() {
        return new FlightJdbcWriter(flightRepository);
    }


}
