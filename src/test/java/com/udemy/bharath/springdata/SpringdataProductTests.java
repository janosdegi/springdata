package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Product;
import com.udemy.bharath.springdata.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataProductTests {

	@Autowired
	ProductRepository productRepository;

	@Before
	public void logBefore() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ----------------------------------------------------------------------------------------------------------- ");
		System.out.println(" ");
		System.out.println(" ");
	}

	@After
	public void logAfter() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ----------------------------------------------------------------------------------------------------------- ");
		System.out.println(" ");
		System.out.println(" ");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
//		Product product = new Product(1, "Iphone", "Awesome", 1000d);
//		Product product = new Product(2, "Iphone X", "Super", 1100d);
//		Product product = new Product(3, "Iphone 8", "Very good", 900d);
		Product product = new Product(4, "Iphone 8", "not so good", 750d);
		productRepository.save(product);
	}

	@Test
	public void testRead() {
		Product product = productRepository.findById(1).orElse(null);
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
	}

	@Test
	public void testUpdate() {
		Product product = productRepository.findById(1).orElse(null);
		product.setPrice(1200d);
		productRepository.save(product);
	}

	@Test
	public void testDelete() {
		if (productRepository.existsById(1)) {
			Product product = productRepository.findById(1).orElse(null);
			productRepository.delete(product);
			System.out.println("-----------------------------------");
			System.out.println("Product with ID=1 is deleted");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("-----------------------------------");
			System.out.println("Product with ID=1 does not exists");
			System.out.println("-----------------------------------");
		}

	}

	@Test
	public void testCount() {
		assertEquals(1, productRepository.count());
	}


//	Testing finder methods -------------------------------------------------------------------------------------------------------


	@Test
	public void testFindByName() {

		List<Product> products = getAndLogProducts(productRepository.findByName("Iphone 8"));

		assertEquals(2, products.size());
	}

	@Test
	public void testFindByNameAndDescription() {
		assertEquals(1, productRepository.findByNameAndDescription("Iphone 8", "not so good").size());
	}

	@Test
	public void testFindByNameLike() {
		List<Product> products = getAndLogProducts(productRepository.findByNameLike("%Iphone%"));
		assertEquals(4, products.size());
	}

	@Test
	public void testFindByNameContains() {
		List<Product> products = getAndLogProducts(productRepository.findByNameContains("Iphone"));
		assertEquals(4, products.size());
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = getAndLogProducts(productRepository.findByPriceGreaterThan(900d));
		assertEquals(2, products.size());
	}

	@Test
	public void testfindByPriceBetween() {
		List<Product> products = getAndLogProducts(productRepository.findByPriceBetween(740d, 1000d));
		assertEquals(3, products.size());
	}

	@Test
	public void testfindByIdIn() {
//		List<Integer> intList = new ArrayList<>();
//		intList.add(new Integer(2));
//		intList.add(new Integer(3));
//		intList.add(new Integer(4));

		List<Integer> intList = Arrays.asList(2,3,4);

		List<Product> products = getAndLogProducts(productRepository.findByIdIn(intList));
		assertEquals(3, products.size());
	}

	@Test
	public void testfindByPriceIn() {
//		List<Double> dblList = new ArrayList<>();
//		dblList.add(new Double(1100));
//		dblList.add(new Double(900));

		List<Double> dblList = Arrays.asList(1100d, 900d);
		List<Product> products = getAndLogProducts(productRepository.findByPriceIn(dblList));
		assertEquals(2, products.size());
	}


//	Testing Paging and sorting -------------------------------------------------------------------------------------------------------

	@Test
	public void testfindAllPaging() {
//		Pageable pageable = new PageRequest(0, 2);
		Pageable pageable = PageRequest.of(0, 2); //0: number of page, 2: elements on the page
		Page<Product> results = getAndLogProductsPages(productRepository.findAll(pageable));
	}

	@Test
	public void testfindAllSorting() {
//		productRepository.findAll(Sort.by("description")).forEach(p -> System.out.println(p.toString()));
//		productRepository.findAll(Sort.by("description").descending()).forEach(p -> System.out.println(p.toString())); //desc

		//short by multiple properties
		//productRepository.findAll(Sort.by("description","price")).forEach(p -> System.out.println(p.toString()));

		//order
		productRepository.findAll(Sort.by(	new Sort.Order(Sort.Direction.DESC, "price"),
											new Sort.Order(Sort.Direction.ASC, "name")))
				.forEach(p -> System.out.println(p.toString()));
	}

	@Test
	public void testfindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "description"); //0: number of page, 2: elements on the page
		Page<Product> results = getAndLogProductsPages(productRepository.findAll(pageable));
	}

	@Test
	public void testfindByPriceInPagingAndSorting() {
//		Pageable pageable = PageRequest.of(0, 2);
		Pageable pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "description");
		List<Double> dblList = Arrays.asList(1100d, 900d, 1000d);
		List<Product> products = getAndLogProducts(productRepository.findByPriceIn(dblList, pageable));
	}


//	JPQL -------------------------------------------------------------------------------------------------------

	@Test
	public void findAllProducts() {
		List<Product> products = getAndLogProducts(productRepository.findAllProducts());
	}

	@Test
	public void findAllProductsPartialData() {
		List<Object[]> products = productRepository.findAllProductsPartialData();
		int j = 0;
		products.forEach(oArray -> {
			for (int i = 0; i < oArray.length; i++) {
				System.out.print(oArray[i] + " ");
			}
			System.out.println();
		});
	}

	@Test
	public void findAllProductsByName() {
		List<Product> products = getAndLogProducts(productRepository.findAllProductsByName("Iphone"));
	}

	@Test
	public void findAllProductsBetween() {
		List<Product> products = getAndLogProducts(productRepository.findAllProductsBetween(770d, 1001d));
	}

	@Test
	@Transactional //as this is a junit test after the transaction finished the transaction will be rolled back
	@Rollback(false) //to avoid this default rollback functionality
	public void deleteProductsByName() {
		productRepository.deleteProductsByName("bla");
	}

//	Utility -------------------------------------------------------------------------------------------------------

	private List<Product> getAndLogProducts(List<Product> products) {
		products.forEach(p -> System.out.println(p.toString()));
		return products;
	}

	private Page<Product> getAndLogProductsPages(Page<Product> products) {
		products.forEach(p -> System.out.println(p.toString()));
		return products;
	}

	private List<Object[]> getAndLogProductsPartialData(List<Object[]> products) {
		products.forEach(p -> System.out.println(p.toString()));
		return products;
	}
}
