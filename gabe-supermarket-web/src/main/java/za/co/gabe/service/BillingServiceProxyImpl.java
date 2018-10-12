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
@Repository("billingServiceProxy")
public class BillingServiceProxyImpl implements BillingServiceProxy {

    @Override
    public void addInvoice(String invoiceJsonObj) throws Exception {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("productJsonObj", invoiceJsonObj);

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/save/{productJsonObj}", String.class,
                uriVariables);

        String response = responseEntity.getBody();
    }

    @Override
    public void updateInvoice(String invoiceJsonObj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInvoice(String invoiceJsonObj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findInvoiceById(long invoiceId) {

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("invoiceId", invoiceId);

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/findById/{invoiceId}", String.class,
                uriVariables);

        String response = responseEntity.getBody();

        return response;
    }

    @Override
    public String findAllInvoices() {

        Map<String, Long> uriVariables = new HashMap<>();

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/findAll", String.class,
                uriVariables);

        String response = responseEntity.getBody();

        return response;
    }
}
