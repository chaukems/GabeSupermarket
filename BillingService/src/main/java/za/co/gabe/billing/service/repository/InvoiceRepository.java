/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.billing.service.repository;

import java.util.List;
import za.co.gabe.billing.service.entity.Invoice;

/**
 *
 * @author ABMC684
 */

public interface InvoiceRepository {

    Invoice save(Invoice invoice);

    List<Invoice> findAll();

    Invoice findById(long id);
}
