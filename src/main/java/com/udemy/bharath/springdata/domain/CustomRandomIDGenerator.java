package com.udemy.bharath.springdata.domain;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by jd on 2018.10.24..
 */
public class CustomRandomIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor,
                                 Object o) throws HibernateException {
        Random random = null;

        int id = 0;

        random = new Random();

        id = random.nextInt(1000000);

        return new Long(id);
    }

}
