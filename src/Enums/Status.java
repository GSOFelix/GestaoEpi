package Enums;

import java.time.LocalDate;

public enum Status {
    VENCIDO,
    OK,
    QUASE_VENCIDO;

    public static Status statusExpire(LocalDate vencimento) {
        var hoje = LocalDate.now();
        int diasLimite = 30;

        if (vencimento.isBefore(hoje)) {
            return Status.VENCIDO;
        } else if (!vencimento.isAfter(hoje.plusDays(diasLimite))) {
            return Status.QUASE_VENCIDO;
        } else {
            return Status.OK;
        }
    }
}




