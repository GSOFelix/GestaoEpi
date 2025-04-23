package Entidades;

import Enums.Status;
import Enums.Turno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Manager extends Employee {
    private List<Worker> workers = new ArrayList<>();

    public Manager(String name, int registration, Turno turn) {
        super(name, registration, turn);
    }

    public void addWorker(Worker worker) {
        if (!workers.contains(worker)) {
            workers.add(worker);
        }
    }

    public void removeWorker(Worker worker) {
        if (workers.remove(worker)) {
            System.out.println("Operario removido com sucesso");
        } else {
            System.out.println("O operario não esta na lista do Gestor");
        }
    }

    public void listByTurn(Turno turn) {
        for (Worker w : workers) {
            if (w.turn.name().equals(turn.name())) {
                System.out.println("Operario: " + w.name + "\nTurno : " + w.turn + "\nRegistro: " + w.registration);
            }
        }
    }

    public void generateReport() {
        System.out.printf("%38s\n", "Relação de Operários e EPIs");
        System.out.printf("| %-15s | %-15s | %-10s \n", "OPERÁRIO", "EPI", "STATUS");
        for (Worker w : workers) {
            for (Epi e : w.epiList) {
                Status expiration = Status.statusExpire(e.getExpire());
                System.out.printf("| %-15s | %-15s | %-10s \n", w.name, e.getName(), expiration);
            }
        }
    }

    public void listExpireEpis() {
        System.out.println("__Relação de Epis Vencidos__");
        for (Worker w : workers) {
            for (Epi e : w.epiList) {
                Status expiration = Status.statusExpire(e.getExpire());
                if(expiration.name().equals(Status.VENCIDO.name()))
                    System.out.printf("Epi: %s %nVencimento: %s ",
                            e.getName(),
                            e.getExpire().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
    }

}
