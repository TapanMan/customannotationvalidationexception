/**package com.custom.validation.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerBatchController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @PostMapping("/batch-job")
    public BatchStatus importCSVToDB() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("startedAt", System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution =jobLauncher.run(job, jobParameters);
        System.out.println("Job Execution "+ jobExecution.getStatus());
        System.out.println("Job is running ****************");
        while (jobExecution.isRunning()){
            System.out.println("Job is already running ####################");
        }
        return jobExecution.getStatus();
    }
}
**/
