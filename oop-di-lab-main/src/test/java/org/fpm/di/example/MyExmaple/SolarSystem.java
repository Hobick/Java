package org.fpm.di.example.MyExmaple;

import org.fpm.di.example.A;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SolarSystem {
    private final Star star;

    private final Earth earth;

    private final Jupiter jupiter;

    private final AsteroidBelt asteroidBelt;
    @Inject
    public SolarSystem(Star st, Earth e, Jupiter j, AsteroidBelt ab){
        this.star = st;
        this.earth = e;
        this.jupiter = j;
        this.asteroidBelt = ab;
    }

    public Star getStar(){
        return star;
    }

    public Earth getEarth(){
        return earth;
    }

    public Jupiter getJupiter(){
        return jupiter;
    }

    public AsteroidBelt getAsteroidBelt(){
        return asteroidBelt;
    }
}
