/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.billing.service.repository;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.co.gabe.billing.service.entity.Invoice;

/**
 *
 * @author ABMC684
 */
@Transactional
@Repository("invoiceRepo")
public class InvoiceRepositoryImpl extends AbstractDao<Long, Invoice> implements InvoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Invoice save(Invoice invoice) {
        persist(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> findAll() {

        Criteria crit = createEntityCriteria();
        //crit.add(Restrictions.eq("id", id));
        return crit.list();
    }

    @Override
    public Invoice findById(long id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Invoice invoice = (Invoice) crit.uniqueResult();
        return invoice;
    }

}
