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
@FeignClient(name = "billing-service")
@RibbonClient(name = "billing-service")
public interface BillingServiceProxy {

    @PostMapping("/addInvoice")
    void addInvoice(String invoiceJsonObj) throws Exception;

    @PostMapping("/updateInvoice")
    void updateInvoice(String invoiceJsonObj) throws Exception;

    @PostMapping("/deleteInvoice")
    void deleteInvoice(String invoiceJsonObj) throws Exception;

    @GetMapping("/findInvoiceById/{invoiceId}")
    String findInvoiceById(@PathVariable("invoiceId") long invoiceId);

    @GetMapping("/findAllInvoices")
    String findAllInvoices();

}
