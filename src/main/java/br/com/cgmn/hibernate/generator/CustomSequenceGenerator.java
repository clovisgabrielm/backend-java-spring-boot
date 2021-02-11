package br.com.cgmn.hibernate.generator;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;
import java.lang.reflect.Method;

public class CustomSequenceGenerator extends SequenceStyleGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        try {
            Class<?> clazz = object.getClass();

            Method getId = clazz.getDeclaredMethod("getId", new Class<?>[] {});

            Long currentId = (Long) getId.invoke(object, new Object[] {});

            if (currentId == null) {
                return super.generate(session, object);
            }

            return currentId;
        } catch (Exception e) {
            throw new RuntimeException("Wrong sequence configuration.");
        }
    }

}
