package Entidades;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Worker extends Employee {
    public Worker(String name, int registration, String turn) {
        super(name, registration, turn);
    }

    public void clockOut() {
        var now = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        var dataHora = now.format(formatter);

        System.out.println("** Turno encerrado para operário:  " + this.name + " **");
        System.out.printf("Data e hora de saida: " + dataHora);
    }
}
