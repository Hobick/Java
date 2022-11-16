package org.fpm.di.example.MyExmaple;

import javax.inject.Inject;

public class CosmicExpedition extends Expedition{
    private final Earth earth;
    private final Jupiter jupiter;
    private final Moon moon;

    @Inject
    public CosmicExpedition(Moon m, Earth e, Jupiter j){
        this.moon = m;
        this.earth = e;
        this.jupiter = j;
    }

    public Moon getMoon(){
        return moon;
    }

    public Earth getEarth(){
        return earth;
    }

    public Jupiter getJupiter(){
        return jupiter;
    }
}
