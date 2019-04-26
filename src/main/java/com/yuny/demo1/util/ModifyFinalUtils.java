package com.yuny.demo1.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author shiyn3
 * @Date 2019/4/25 20:30
 * @Version 1.0
 */
public class ModifyFinalUtils {
    public static void modify(Object object, String fieldName, Object newFieldValue) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true); //Field 的 modifiers 是私有的
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        if(!field.isAccessible()) {
            field.setAccessible(true);
        }

        field.set(object, newFieldValue);
    }
}