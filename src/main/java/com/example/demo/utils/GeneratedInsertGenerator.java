package com.example.demo.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * @author 李嘉旭
 * 主键的自动增长策略
 */
public class GeneratedInsertGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) throws HibernateException {
        Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);

        if (id != null && Integer.valueOf(id.toString()) > 0) {
            return id;
        } else {
            return super.generate(s, obj);
        }
    }
}
