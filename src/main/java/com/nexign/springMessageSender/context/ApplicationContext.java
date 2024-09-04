package com.nexign.springMessageSender.context;

import com.nexign.springMessageSender.factory.BeanFactory;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final Map<Class<?>, Object> cache = new HashMap<>();



    public <T> T getBean(Class<T> tClass) {
        if (cache.containsKey(tClass)) {
            return (T) cache.get(tClass);
        }

        T bean = BeanFactory.getBean(tClass);
        System.out.println("Bean добавлен в контекст");
        cache.put(tClass, bean);
        return bean;
    }
}
