package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Product;
import com.udemy.bharath.springdata.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataProductTests {

	@Autowired
	ProductRepository productRepository;

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
		assertEquals(2, productRepository.findByName("Iphone 8").size());
	}

	@Test
	public void testFindByNameAndDescription() {
		assertEquals(1, productRepository.findByNameAndDescription("Iphone 8", "not so good").size());
	}

	@Test
	public void testFindByNameLike() {

		// NOT WORKING

		assertEquals(4, productRepository.findByNameLike("Iphone").size());
	}

	@Test
	public void testFindByPriceGreaterThan() {
		assertEquals(2, productRepository.findByPriceGreaterThan(900d).size());
	}
}
