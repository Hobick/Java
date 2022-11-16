package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.MyExmaple.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
///==========================================
        binder.bind(MilkyWay.class);
        binder.bind(Nebula.class);
        binder.bind(Expedition.class);

        binder.bind(Star.class, Sun.class);
        binder.bind(Expedition.class, CosmicExpedition.class);
        binder.bind(Nebula.class, Orion.class);

        binder.bind(Sun.class, new Sun());
    }
}
