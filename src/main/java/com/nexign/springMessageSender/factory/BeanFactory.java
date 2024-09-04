package com.nexign.springMessageSender.factory;

import com.nexign.springMessageSender.annotations.Inject;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BeanFactory {

    public static <T> T getBean(Class<T> tClass) {

        Class<? extends T> implClass = tClass;
        if (implClass.isInterface()) {
            implClass = getImpl(implClass);
        }

        T bean = null;

        try {
            bean = implClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Field[] fields = implClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, BeanFactory.getBean(field.getType()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    public static  <T> Class<? extends T> getImpl(Class<T> tClass) {
        Reflections reflections = new Reflections("com.nexign.springMessageSender");
        Set<Class<? extends T>> subTypesOf = reflections.getSubTypesOf(tClass);
        if (subTypesOf.size() !=1) {
            throw new RuntimeException("0 или больше реализаций");
        }
        return subTypesOf.iterator().next();
    }
}
