package org.fpm.di.example.MyExmaple;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MilkyWay {
    private final SolarSystem system;
    @Inject
    public MilkyWay(SolarSystem ss){
        this.system = ss;
    }

    public SolarSystem getSystem(){
        return system;
    }
}
