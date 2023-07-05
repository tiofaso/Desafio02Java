package TestandoRecursos;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class TesteDatHora {
    public static void main(String[] args) {
        Date data = Date.valueOf(LocalDate.now());
        Time hora = Time.valueOf(LocalTime.now());
        System.out.println(data);
        System.out.println(hora);
    }
}
