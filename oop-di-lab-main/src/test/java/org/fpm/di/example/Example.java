package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.MyExmaple.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void MyTest1(){
        Earth e = container.getComponent(Earth.class);
        assertSame(e.getMoon(), container.getComponent(Moon.class));
        assertSame(e, container.getComponent(Earth.class));
    }

    @Test
    public void MyTest2(){
        MilkyWay galaxy = container.getComponent(MilkyWay.class);
        assertSame(galaxy.getSystem().getEarth(), container.getComponent(Earth.class));

        SolarSystem solarSystem = container.getComponent(SolarSystem.class);
        assertSame(solarSystem.getJupiter(), container.getComponent(Jupiter.class));
        assertSame(solarSystem, galaxy.getSystem());

    }

    @Test
    public void MyTest3(){
        Nebula nebula = container.getComponent(Nebula.class);
        SolarSystem solarSystem = container.getComponent(SolarSystem.class);
        assertNotSame(solarSystem.getAsteroidBelt(), ((Orion)nebula).getAsteroidBelt());
    }

    @Test
    public void MyTest4(){
        Expedition exp = container.getComponent(Expedition.class);
        SolarSystem solarSystem = container.getComponent(SolarSystem.class);
        assertSame(solarSystem.getJupiter(), ((CosmicExpedition)exp).getJupiter());
    }

    @Test
    public void MyTest5(){
        CosmicExpedition exp1 = container.getComponent(CosmicExpedition.class);
        CosmicExpedition exp2 = container.getComponent(CosmicExpedition.class);
        assertSame(exp1.getJupiter(), exp2.getJupiter());
        assertNotSame(exp1, exp2);
    }

    @Test
    public void GlobalTest(){
        CosmicExpedition exp = container.getComponent(CosmicExpedition.class);
        MilkyWay milkyWay = container.getComponent(MilkyWay.class);
        Orion orion = container.getComponent(Orion.class);
        assertSame(exp.getJupiter(), milkyWay.getSystem().getJupiter());
        assertSame(exp.getEarth(), milkyWay.getSystem().getEarth());
        assertSame(exp.getMoon(), milkyWay.getSystem().getEarth().getMoon());
        assertSame(container.getComponent(Sun.class), milkyWay.getSystem().getStar());
        assertSame(milkyWay.getSystem().getStar(), container.getComponent(Star.class));
        assertNotSame(container.getComponent(AsteroidBelt.class), container.getComponent(AsteroidBelt.class));
        Star st = container.getComponent(Star.class);
        assertSame(st, container.getComponent(Sun.class));
        assertSame(st, milkyWay.getSystem().getStar());
    }


}
