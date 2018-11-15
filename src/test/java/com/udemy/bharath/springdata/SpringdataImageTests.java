package com.udemy.bharath.springdata;

import com.udemy.bharath.springdata.domain.Image;
import com.udemy.bharath.springdata.repository.ImageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataImageTests {

	@Autowired
	ImageRepository imageRepository;

	@Test
	public void testImageSave() throws IOException {

		File file = new File("C:\\Users\\Dégi János\\Desktop\\wallpapers\\EEtmekc.jpg");
		byte[] fileContent = new byte[(int)file.length()];

		FileInputStream fis = new FileInputStream(file);
		fis.read(fileContent);

		Image image = new Image(1,"maven.jpg",fileContent);
		imageRepository.save(image);

		fis.close();
	}

	@Test
	public void testImageRead() throws IOException {
		Image image = imageRepository.findById(1L).orElse(null);
		File file = new File("D:\\tmp\\" + image.getName());
		byte[] fileContent = new byte[(int)file.length()];
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(image.getData());
		fos.close();
	}


}
