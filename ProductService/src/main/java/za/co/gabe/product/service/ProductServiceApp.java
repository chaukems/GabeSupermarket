/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import za.co.gabe.product.service.entity.Product;
import za.co.gabe.product.service.repository.ProductsRepository;

/**
 *
 * @author ABMC684
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"za.co.gabe.product.service"})
public class ProductServiceApp implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductsRepository productsRepository;

    public static void main(String... args) {
        SpringApplication.run(ProductServiceApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("---------------------Some minor testing------------------");
        Product product = productsRepository.findById(1);

        logger.info("Product findById 1 -> {}", product.getId());
        logger.info("Product name -> {}", product.getProductName());
        logger.info("---------------------Some minor testing end------------------");
    }
}
