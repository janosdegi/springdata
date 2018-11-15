package com.udemy.bharath.springdata.repository;

import com.udemy.bharath.springdata.domain.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd on 2018.11.15..
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}
