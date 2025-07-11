package com.javarush.khmelov.lesson14.config;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Winter {

    private Winter() {

    }

    private static final Map<Class<?>, Object> beans = new ConcurrentHashMap<>();

    @SneakyThrows
    public static <T> T find(Class<T> clazz) {
        if (!beans.containsKey(clazz)) {
            Constructor<?> constructor = clazz.getConstructors()[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = find(parameterTypes[i]);
            }
            beans.put(clazz, constructor.newInstance(parameters));
        }
        //noinspection unchecked
        return (T) beans.get(clazz);
    }
}
