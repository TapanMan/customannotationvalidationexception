/**package com.custom.validation.config;

import com.custom.validation.entity.CustomerBatch;
import com.custom.validation.repository.CustomerBatchRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
@EnableBatchProcessing
@Configuration
public class SpringBatchConfig {

    @Autowired
    private JobBuilder jobBuilder;
    @Autowired
    private StepBuilder stepBuilder;

    @Autowired
    private CustomerBatchRepository customerBatchRepository;

    @Bean
    public FlatFileItemReader<CustomerBatch> reader() {
        FlatFileItemReader<CustomerBatch> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/CustomerBatch.csv"));
        itemReader.setName("Customer Batch CSV");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }
    @Bean
    public LineMapper<CustomerBatch> lineMapper() {
        DefaultLineMapper<CustomerBatch> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNumber", "country", "dateOfBirth");
        BeanWrapperFieldSetMapper<CustomerBatch> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(CustomerBatch.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public CustomerBatchProcessor processor() {
        return new CustomerBatchProcessor();
    }
    @Bean
    public RepositoryItemWriter<CustomerBatch> writer() {
        RepositoryItemWriter<CustomerBatch> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerBatchRepository);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public Step setp1(JobRepository repository, PlatformTransactionManager manager) {
        return new StepBuilder("First-step", repository).<CustomerBatch, CustomerBatch>chunk(2, manager).reader(reader()).processor(processor()).writer(writer()).taskExecutor(taskExecutor()).build();
    }

    @Bean
    public Job runJob(JobRepository repository, PlatformTransactionManager manager) {
        return new JobBuilder("Customer Batch Job", repository).flow(setp1(repository, manager)).end().build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
**/
// Commented