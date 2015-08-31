package org.python;

import java.lang.reflect.InvocationTargetException;

import org.python.exceptions.RuntimeError;


public class Constructor implements Callable {
    public java.lang.reflect.Constructor constructor;

    public Constructor(java.lang.reflect.Constructor constructor) {
        this.constructor = constructor;
    }

    public org.python.Object invoke(java.lang.Object... args) {
        try {
            return (org.python.Object) this.constructor.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeError("Illegal access to Java constructor " + this.constructor);
        } catch (InvocationTargetException e) {
            throw new RuntimeError(e.getCause().toString());
        } catch (InstantiationException e) {
            throw new RuntimeError(e.getCause().toString());
        }
    }

}