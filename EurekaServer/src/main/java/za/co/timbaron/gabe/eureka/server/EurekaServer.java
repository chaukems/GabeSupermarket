/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.timbaron.gabe.eureka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ABMC684
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

    private static final Logger logger = LoggerFactory.getLogger(EurekaServer.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
        logger.debug("--Application Started--");
    }

}
