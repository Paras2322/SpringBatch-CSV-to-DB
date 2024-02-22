package com.springbatch.config;

import com.springbatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        //Filtering the job
//        if (customer.getCountry().equals("United States")) {
//            return customer;
//        } else {
//            return null;
//        }
        return customer;
    }
}