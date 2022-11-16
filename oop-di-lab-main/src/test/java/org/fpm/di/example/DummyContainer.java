package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;

public class DummyContainer implements Container {
    DummyBinder binder;
    public DummyContainer(DummyBinder b){
        this.binder = b;
    }
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if(binder.implementations.containsKey(clazz)){
            return getComponent((Class<T>) binder.implementations.get(clazz));
        }
        if(binder.instances.containsKey(clazz)){
            return (T) binder.instances.get(clazz);
        }
        try {
            T comp = null;
            for(Constructor<?> c : clazz.getConstructors()){
                if(c.isAnnotationPresent(Inject.class)){
                    Object[] params = new Object[c.getParameters().length];
                    for(int i = 0; i < c.getParameters().length; i++){
                        params[i] = getComponent(c.getParameters()[i].getType());
                    }
                    comp = (T) c.newInstance(params);
                    break;
                }
            }
            if(comp == null){
                comp = clazz.newInstance();
            }
            if(clazz.isAnnotationPresent(Singleton.class)){
                binder.bind(clazz, comp);
            }
            return comp;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

      /*
        if (clazz.equals(A.class)) {
            return (T) new A();
        }
        if (clazz.equals(B.class)) {
            return (T) new B();
        }
        return null;*/
    }
}
