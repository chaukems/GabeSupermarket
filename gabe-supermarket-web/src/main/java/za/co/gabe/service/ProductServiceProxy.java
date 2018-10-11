/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Matimba
 */
@FeignClient(name = "products-service")
@RibbonClient(name = "products-service")
public interface ProductServiceProxy {

    @PostMapping("/addProduct")
    void addProduct(String productJsonObj) throws Exception;

    @PostMapping("/updateProduct")
    void updateProduct(String productJsonObj) throws Exception;

    @PostMapping("/deleteProduct")
    void deleteProduct(String productJsonObj) throws Exception;

    @GetMapping("/findProductById/{productId}")
    String findProductById(@PathVariable("productId") long productId);

    @GetMapping("/findAllProducts")
    String findAllProducts();

}
