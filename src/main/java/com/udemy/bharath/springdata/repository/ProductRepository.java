package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

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

    @Query("from Product")
    public List<Product> findAllProductsPageable(Pageable pageable);

    @Query("select p.name, p.description from Product p")
    public List<Object[]> findAllProductsPartialData();

    @Query("from Product where name=:name_param")
    public List<Product> findAllProductsByName(@Param("name_param") String name);

    @Query("from Product where price > :priceMin and price < :priceMax")
    public List<Product> findAllProductsBetween(@Param("priceMin") Double priceFrom, @Param("priceMax") Double priceTo);

    @Modifying
    @Query("delete from Product where name = :name")
    void deleteProductsByName(@Param("name") String name);

    //native sql query --------------------------------------------------------------

    @Query(value = "select * from product", nativeQuery = true)
    public List<Product> findAllProductsNQ();

    @Query(value = "select * from product where name=:nameNamedParam", nativeQuery = true)
    public List<Product> findProductsByNameNQ(@Param("nameNamedParam") String name);




}
