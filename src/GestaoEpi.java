import Entidades.Epi;
import Entidades.Worker;

import java.time.LocalDate;

public class GestaoEpi {
    public static void main(String[] args) {

        // Epis do operador
        var luva = new Epi(1, "Luva", LocalDate.of(2028, 12, 31), "Mãos");
        var colete = new Epi(2, "Colete", LocalDate.of(2028, 1, 20), "Torso");
        var capacete = new Epi(3, "capacete", LocalDate.of(2024, 7, 15), "Cabeça");
        var botas = new Epi(4, "Botas", LocalDate.of(2026, 12, 31), "Pés");

        var operador = new Worker("João Pedro", 568956, "Noturno");

        operador.addEpi(luva);
        operador.addEpi(botas);
        operador.addEpi(colete);
        operador.addEpi(capacete);
        operador.addEpi(colete);

        operador.getAllEpis();

        operador.clockOut();

    }
}
