package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDate.*;

public abstract class Employee {

    protected String name;
    protected int registration;
    protected List<Epi> epiList;
    protected String turn;

    public Employee(String name, int registration, String turn) {
        this.name = name;
        this.registration = registration;
        this.turn = turn;
        epiList = new ArrayList<>();
    }

    public void addEpi(Epi epi) {
        boolean exists = false;

        for (Epi e : epiList) {
            if (e.getCod() == epi.getCod() || Objects.equals(e.getName(), epi.getName())) {
                exists = true;
                System.out.println("Equipamento já adicionado para o operador.");
                break;
            }
            if (isExpired(epi.getExpire())) {
                System.out.println("O Equipamento " + epi.getName() + " esta Vencido!");
                return;
            }
        }

        if (!exists) {
            epiList.add(epi);
        }
    }

    public void getAllEpis() {

        for (Epi e : epiList) {
            String message = String.format("Equipamentos do funcionario: %s \nCodigo: %d \nDescrição: %s",
                    this.name, e.getCod(), e.getName());
            System.out.println(message);
            System.out.println("======================================");
        }
    }

    private boolean isExpired(LocalDate vencimento) {
        return vencimento.isBefore(LocalDate.now()) || vencimento.isEqual(LocalDate.now());
    }
}
