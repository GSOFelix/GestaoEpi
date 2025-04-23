import Entidades.Epi;
import Entidades.Manager;
import Entidades.Worker;
import Enums.MotivoSubstituicao;
import Enums.Turno;

import java.time.LocalDate;

public class GestaoEpi {
    public static void main(String[] args) {

        // Epis do operador
        var luva = new Epi(1, "Luva", LocalDate.of(2028, 12, 31), "Mãos");
        var colete = new Epi(2, "Colete", LocalDate.of(2025, 5, 23), "Torso");
        var colete2 = new Epi(6, "Colete", LocalDate.of(2026, 5, 23), "Torso");
        var capacete = new Epi(3, "Capacete", LocalDate.of(2024, 7, 15), "Cabeça");
        var capacete2 = new Epi(7, "Capacete", LocalDate.of(2028, 7, 15), "Cabeça");
        var botas = new Epi(4, "Botas", LocalDate.of(2026, 12, 31), "Pés");

        var operador = new Worker("João Pedro", 568956, Turno.NOITE);
        var operador2 = new Worker("Felipe", 568957, Turno.MANHA);
        var operador3 = new Worker("Carlos", 568958, Turno.TARDE);

        var gestor = new Manager("Guilherme Felix", 236589, Turno.MANHA);


        operador.addEpi(capacete);
        operador.addEpi(colete);
        operador2.addEpi(luva);
        operador3.addEpi(botas);
        operador3.addEpi(colete2);

        gestor.addWorker(operador);
        gestor.addWorker(operador2);
        gestor.addWorker(operador3);

        gestor.generateReport();

        operador.replaceEpi(capacete, capacete2, MotivoSubstituicao.VENCIDO);
        operador.replaceEpi(colete, colete2, MotivoSubstituicao.RECALL);


        gestor.generateReport();


    }
}
