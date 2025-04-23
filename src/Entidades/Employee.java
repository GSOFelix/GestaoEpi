package Entidades;

import Enums.MotivoSubstituicao;
import Enums.Turno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDate.*;

public abstract class Employee {

    protected String name;
    protected int registration;
    protected List<Epi> epiList;
    protected Turno turn;

    public Employee(String name, int registration, Turno turn) {
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
            /* if (isExpired(epi.getExpire())) {
                System.out.println("O Equipamento " + epi.getName() + " esta Vencido!");
                return;
            }*/
        }

        if (!exists) {
            epiList.add(epi);
        }
    }

    public void getAllEpis() {
        System.out.println("Equipamentos do funcionario: " + this.name);

        for (Epi e : epiList) {
            String message = String.format("Codigo: %d \nDescrição: %s \nData Vencimento: %s",
                    e.getCod(),
                    e.getName(),
                    e.getExpire().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println(message);
            System.out.println("======================================");
        }
    }

    private boolean isExpired(LocalDate vencimento) {
        return vencimento.isBefore(LocalDate.now()) || vencimento.isEqual(LocalDate.now());
    }

    private void removeEpi(Epi epi){

        epiList.removeIf(e -> e.getCod() == epi.getCod());

    }

    public void replaceEpi(Epi oldE,Epi newE, MotivoSubstituicao m){
        Objects.requireNonNull(m, "Motivo de substituição não pode ser nulo.");

        if (!oldE.getName().equals(newE.getName())) {
            System.out.println("Só pode substituir pelo mesmo tipo de EPI.");
            return;
        }

        if (m == MotivoSubstituicao.VENCIDO) {
            if (!oldE.getExpire().isBefore(LocalDate.now())) {;
                System.out.println("EPI ainda está dentro da validade. Substituição não realizada.");
                return;
            }
        }

        System.out.println("Substituindo EPI por motivo: " + m);
        removeEpi(oldE);
        addEpi(newE);
    }
}
