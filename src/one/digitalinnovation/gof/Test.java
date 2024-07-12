package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.Comportamento;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;

public class Test {

    public static void main(String[] args) {

        // Singleton

        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);

        // Strategy

        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);

        int passosPorPadrao = 3;
        int repeticoesDoPadrao = 4;

        for (int i = 1; i <= repeticoesDoPadrao; i++) {
            System.out.println("Padrão " + i + ":");

            for (int j = 1; j <= passosPorPadrao; j++) {
                System.out.println("Passo " + ((i - 1) * passosPorPadrao + j) + ":");
                robo.mover();
            }

            if (i < repeticoesDoPadrao) {
                System.out.println("Alternando comportamentos:");
                robo.setComportamento(defensivo);
                robo.mover();
                robo.setComportamento(agressivo);
                robo.mover();
                robo.setComportamento(normal);
                robo.mover();
            }
        }
	}
}
