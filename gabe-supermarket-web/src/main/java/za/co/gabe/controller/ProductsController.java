package za.co.gabe.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.gabe.service.ProductServiceProxy;

@RestController
@Api(description = "Products management API")
@RequestMapping({"/product"})
public class ProductsController {

    @Autowired
    private ProductServiceProxy productServiceProxy;

    @PostMapping("/addProduct")
    private void addProduct(String productJsonObj) throws Exception {
        productServiceProxy.addProduct(productJsonObj);
    }

    @PostMapping("/updateProduct")
    private void updateProduct(String productJsonObj) throws Exception {
        productServiceProxy.updateProduct(productJsonObj);
    }

    @PostMapping("/deleteProduct")
    private void deleteProduct(String productJsonObj) throws Exception {
        productServiceProxy.deleteProduct(productJsonObj);
    }

    @GetMapping("/findProductById/{productId}")
    private String findProductById(@PathVariable("productId") long productId) {
        return productServiceProxy.findProductById(productId);

    }

    @GetMapping("/findAll")
    private String findAll() {
        return productServiceProxy.findAllProducts();
    }

}
