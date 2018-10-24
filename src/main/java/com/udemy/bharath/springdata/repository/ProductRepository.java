package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jd on 2018.10.22..
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findByName(String name);

    public List<Product> findByNameAndDescription(String name, String description);

    public List<Product> findByNameLike(String name);

    public List<Product> findByPriceGreaterThan(Double price);

}
