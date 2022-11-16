package org.fpm.di.example.MyExmaple;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Orion extends Nebula{
    private final AsteroidBelt asteroidBelt;
    @Inject
    public Orion(AsteroidBelt ab){
        this.asteroidBelt = ab;
    }

    public AsteroidBelt getAsteroidBelt(){
        return asteroidBelt;
    }
}
