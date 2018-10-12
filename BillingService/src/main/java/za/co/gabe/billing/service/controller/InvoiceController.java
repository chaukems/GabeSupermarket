/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.billing.service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.gabe.billing.service.entity.Invoice;
import za.co.gabe.billing.service.repository.InvoiceRepository;

/**
 *
 * @author ABMC684
 */
@RestController
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceDao;

    @PostMapping("/save")
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceDao.save(invoice);
    }

    @GetMapping("/findAll")
    public List<Invoice> viewAllInvoices() {
        return invoiceDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public Invoice viewInvoice(@PathVariable Long id) {
        return invoiceDao.findById(id);
    }

}
