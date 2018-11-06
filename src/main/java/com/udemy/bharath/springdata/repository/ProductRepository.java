package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jd on 2018.10.22..
 */
//public interface ProductRepository extends CrudRepository<Product, Integer> {
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    public List<Product> findByName(String name);

    public List<Product> findByNameAndDescription(String name, String description);

    public List<Product> findByNameLike(String name);

    public List<Product> findByNameContains(String name);

    public List<Product> findByPriceGreaterThan(Double price);

    public List<Product> findByPriceBetween(Double from, Double to);

    public List<Product> findByIdIn(List<Integer> ids);

    public List<Product> findByPriceIn(List<Double> prices);

    public List<Product> findByPriceIn(List<Double> prices, Pageable pageable);


    //jpql --------------------------------------------------------------
    @Query("from Product")
    public List<Product> findAllProducts();

}
