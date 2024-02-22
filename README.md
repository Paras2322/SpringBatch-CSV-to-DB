# Spring Boot Batch Processing: Dumping CSV Data into Database

This Spring Boot application facilitates batch processing to import data from a CSV file into a database. The process involves reading data from a CSV file, processing it, and persisting it into the database.

## Features

### CSV Data Import

- **Source Data:** The application reads data from a CSV file named `customers.csv`.
- **File Location:** The CSV file is located in the `src/main/resources` directory of the project.
- **Data Structure:** The CSV file contains customer information such as ID, first name, last name, email, gender, contact number, country, and date of birth.
  
### Chunk Processing

- **Chunk Size:** Data processing is performed in chunks of 10 records.
- **Efficiency:** Chunk processing enhances the application's efficiency, particularly when dealing with large datasets.
- **Transaction Management:** Each chunk of data is processed within a transaction to ensure data consistency.

### Parallel Processing

- **Task Executor:** The application utilizes a customized task executor to enable parallel processing of chunks.
- **Concurrency:** The task executor is configured with a concurrency limit of 10 threads.
- **Improved Performance:** Parallel processing enhances throughput and performance, allowing for faster data processing.

### Database Persistence

- **Data Persistence:** Processed data is persisted into a database using Spring Data JPA and Hibernate.
- **Repository:** The `CustomerRepository` interface, extending `JpaRepository`, is used to interact with the database and perform CRUD operations on customer entities.
- **Automatic Schema Generation:** Hibernate automatically generates database schema based on the entity mappings defined in the application.

### Spring Data JPA

- **JPA Repository:** Spring Data JPA provides a powerful repository abstraction layer on top of JPA, simplifying database access and reducing boilerplate code.
- **Entity-Repository Association:** Each entity in the application is associated with a corresponding repository interface, allowing for easy database operations.

## Prerequisites

- **Java Development Kit (JDK):** Ensure that JDK 8 or higher is installed on your system.
- **Apache Maven:** Maven is required to build and run the Spring Boot application.
- **Database:** Install and configure MySQL or another compatible database server. Ensure that the database server is running locally.

## Usage

1. **Clone Repository:** Clone the repository to your local machine using the following command:

   ```bash
   git clone <https://github.com/Paras2322/SpringBatch-CSV-to-DB.git>
   ```

2. **Navigate to Project Directory:** Change to the project directory using the following command:

   ```bash
   cd spring-boot-batch-processing
   ```

3. **Place CSV File:** Ensure that the `customers.csv` file containing the data to be imported is placed in the `src/main/resources` directory of the project.

4. **Run Application:** Execute the application using Maven with the following command:

   ```bash
   mvn spring-boot:run
   ```

5. **Monitor Progress:** Monitor the console logs for batch processing status and any errors encountered during execution.

## Customized Task Executor

In this application, the task executor is customized to allow parallel processing of chunks. The following configuration is used to define the task executor bean:

```java
@Bean
public TaskExecutor taskExecutor(){
    SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
    asyncTaskExecutor.setConcurrencyLimit(10);
    return asyncTaskExecutor;
}
```

## Contributions

Contributions to this project are welcome! If you have any suggestions, enhancements, or bug fixes, feel free to open an issue or submit a pull request.

## Additional Information

- **Official Documentation:** Refer to the [official documentation](https://spring.io/projects/spring-batch) for more information on Spring Batch framework.
- **Customization:** Customize batch processing logic, chunk size, and task executor configuration as per your specific requirements.
- **Maintenance:** Regularly monitor batch job execution and database performance for optimal operation of the application.
