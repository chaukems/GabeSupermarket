/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Matimba
 */
@Transactional
@Repository("productServiceProxy")
public class ProductServiceProxyImpl implements ProductServiceProxy {

    @Override
    public void addProduct(String productJsonObj) throws Exception {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("productJsonObj", productJsonObj);

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8100/findById/{productId}", String.class,
                uriVariables);

        String response = responseEntity.getBody();
    }

    @Override
    public void updateProduct(String productJsonObj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(String productJsonObj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findProductById(long productId) {

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("productId", productId);

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8100/findById/{productId}", String.class,
                uriVariables);

        String response = responseEntity.getBody();

        return response;
    }

    @Override
    public String findAllProducts() {
        Map<String, Long> uriVariables = new HashMap<>();

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8100/findAll", String.class,
                uriVariables);

        String response = responseEntity.getBody();

        return response;
    }

}
