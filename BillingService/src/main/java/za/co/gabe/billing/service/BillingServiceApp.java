/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.billing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import za.co.gabe.billing.service.entity.Invoice;
import za.co.gabe.billing.service.repository.InvoiceRepository;

/**
 *
 * @author ABMC684
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"za.co.gabe.billing"})
public class BillingServiceApp implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InvoiceRepository invoiceRepo;

    public static void main(String... args) {
        SpringApplication.run(BillingServiceApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("---------------------Some minor testing------------------");
        Invoice invoice = invoiceRepo.findById(1L);

        System.out.println(invoice);
        logger.info("Invoice findById 10001 -> {}", invoice.getId());
        logger.info("Invoice Client name -> {}", invoice.getClient());
        logger.info("---------------------Some minor testing end------------------");
    }
}
