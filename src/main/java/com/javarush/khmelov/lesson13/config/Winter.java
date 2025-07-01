package com.javarush.khmelov.lesson13.config;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Winter {

    private Winter(){

    }

    private static final Map<Class<?>, Object> beans = new ConcurrentHashMap<>();

    @SuppressWarnings({"ReassignedVariable", "unchecked"})
    @SneakyThrows
    public static <T> T find(Class<T> clazz) {
        Object component = beans.get(clazz);
        if (component == null) {
            Constructor<?> constructor = clazz.getConstructors()[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = find(parameterTypes[i]);
            }
            component = constructor.newInstance(parameters);
        }
        return (T) component;
    }
}
