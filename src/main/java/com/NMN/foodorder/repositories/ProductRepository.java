package com.NMN.foodorder.repositories;

import com.NMN.foodorder.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer>
{
    public Product findByPname(String name);

}
