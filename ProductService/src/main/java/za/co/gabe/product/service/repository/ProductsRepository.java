/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.gabe.product.service.repository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import za.co.gabe.product.service.entity.Product;

/**
 *
 * @author Matimba
 */
@Transactional
public interface ProductsRepository {

    void addProduct(Product product) throws Exception;

    void updateProduct(Product product) throws Exception;

    void deleteProduct(Product product) throws Exception;

    Product findById(long productId);

    Product getByBarcode(long barcode);

    List<Product> findAll();

}
