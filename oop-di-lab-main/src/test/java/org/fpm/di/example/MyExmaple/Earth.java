package org.fpm.di.example.MyExmaple;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Earth {
    private final Moon moon;
    @Inject
    public Earth(Moon m){
        this.moon = m;
    }

    public Moon getMoon(){
        return moon;
    }
}
