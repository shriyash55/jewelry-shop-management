package com.jewelry.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception{
        if(customerRepository.count()==0){

            Customer customer1 = new Customer();
            customer1.setFirstName("Shri");
            customer1.setLastName("Vedpathak");
            customer1.setPhone("0123456789");
            customer1.setBalance(5000.0);

            Customer customer2 = new Customer();
            customer2.setFirstName("Pratik");
            customer2.setLastName("Unnad");
            customer2.setPhone("9876543210");
            customer2.setBalance(2500.0);

            customerRepository.save(customer1);
            customerRepository.save(customer2);

            System.out.println("Sample customer added to database!");
        }else {
            System.out.println("Database already has " + customerRepository.count() + " customers");
        }
    }

}
