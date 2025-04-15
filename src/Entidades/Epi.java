package Entidades;

import java.time.LocalDate;

public class Epi {
    private int Cod;
    private String Name;
    private LocalDate Expire;
    private String Type;

    public Epi(int cod, String name, LocalDate expire, String type) {
        Cod = cod;
        Name = name;
        Expire = expire;
        Type = type;
    }

    public int getCod() {
        return Cod;
    }

    public String getName() {
        return Name;
    }

    public LocalDate getExpire() {
        return Expire;
    }
}
