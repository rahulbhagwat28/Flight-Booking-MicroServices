package com.flight.inventory.Batch;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class FlightStatusBatchScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job updateFlightStatusJob;


    @Scheduled(cron="0 */1 * * * *")
    public void runUpdateFlightStatusJob()
    {
        try {
            jobLauncher.run(updateFlightStatusJob,new JobParameters());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
