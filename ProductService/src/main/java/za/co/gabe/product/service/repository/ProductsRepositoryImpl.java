/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.product.service.repository;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import za.co.gabe.product.service.entity.Product;

/**
 *
 * @author Matimba
 */
@Repository("productRepo")
public class ProductsRepositoryImpl extends AbstractDao<Long, Product> implements ProductsRepository {

    public void addProduct(Product product) throws Exception {
        persist(product);
    }

    public void updateProduct(Product product) throws Exception {
        update(product);
    }

    public void deleteProduct(Product product) throws Exception {
        delete(product);
    }

    public Product findById(long productId) {
        return getByKey(productId);
    }

    public List<Product> findAll() {
        Criteria crit = createEntityCriteria();
        return crit.list();
    }

    public Product getByBarcode(long barcode) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("barcode", barcode));
        return (Product) crit.uniqueResult();
    }

}
