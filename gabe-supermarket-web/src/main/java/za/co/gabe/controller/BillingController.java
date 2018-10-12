package za.co.gabe.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.gabe.service.BillingServiceProxy;

@RestController
@Api(description = "Billing management API")
@RequestMapping({"/billing"})
public class BillingController {

    @Autowired
    private BillingServiceProxy billingServiceProxy;

    @PostMapping("/addInvoice")
    public void addInvoice(String invoiceJsonObj) throws Exception {
        billingServiceProxy.addInvoice(invoiceJsonObj);
    }

    @PostMapping("/updateInvoice")
    public void updateInvoice(String invoiceJsonObj) throws Exception {
        billingServiceProxy.updateInvoice(invoiceJsonObj);
    }

    @PostMapping("/deleteInvoice")
    public void deleteInvoice(String invoiceJsonObj) throws Exception {
        billingServiceProxy.deleteInvoice(invoiceJsonObj);
    }

    @GetMapping("/findInvoiceById/{invoiceId}")
    public String findInvoiceById(@PathVariable("invoiceId") long invoiceId) {
        return billingServiceProxy.findInvoiceById(invoiceId);

    }

    @GetMapping("/findAllInvoices")
    public String findAllInvoices() {
        return billingServiceProxy.findAllInvoices();
    }

}
