package org.java.ticketone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main2 {
    public static void main(String[] args) {
        ProgrammaEventi programma = new ProgrammaEventi("Programma Eventi");

        Concerto concerto1 = new Concerto("Concerto 1", LocalDate.of(2023, 10, 20), 100, LocalTime.of(17, 30), BigDecimal.valueOf(50.00));
        Concerto concerto2 = new Concerto("Concerto 2", LocalDate.of(2023, 10, 20), 200, LocalTime.of(21, 0), BigDecimal.valueOf(60.00));
        Concerto concerto3 = new Concerto("Concerto 3", LocalDate.of(2023, 10, 21), 150, LocalTime.of(20, 0), BigDecimal.valueOf(70.00));

        Spettacolo spettacolo1 = new Spettacolo("Spettacolo 1", LocalDate.of(2023, 10, 20), 100, BigDecimal.valueOf(40.00));
        Spettacolo spettacolo2 = new Spettacolo("Spettacolo 2", LocalDate.of(2023, 10, 22), 200, BigDecimal.valueOf(50.00));
        Spettacolo spettacolo3 = new Spettacolo("Spettacolo 3", LocalDate.of(2023, 10, 23), 150, BigDecimal.valueOf(60.00));

        programma.aggiungiEvento(concerto1);
        programma.aggiungiEvento(concerto2);
        programma.aggiungiEvento(concerto3);
        programma.aggiungiEvento(spettacolo1);
        programma.aggiungiEvento(spettacolo2);
        programma.aggiungiEvento(spettacolo3);

        System.out.println("Numero di eventi nel programma: " + programma.getNumeroEventi());

        System.out.println(programma.mostraEventi());

        System.out.println("Eventi il giorno 20/10/2023:");
        for (Evento evento : programma.getEventiInData(LocalDate.of(2023, 10, 20))) {
            System.out.println(evento);
        }
        
        System.out.println("\n------------------\n");

        System.out.println("Media prezzo concerti: " + programma.mediaPrezzoConcerto()+ "€") ;
        System.out.println("Media prezzo spettacoli: " + programma.mediaPrezzoSpettacolo()+ "€");
        System.out.println("Media prezzo eventi: " + programma.mediaPrezzoEvento()+ "€");

        programma.svuotaListaEventi();

        System.out.println("Numero di eventi nel programma dopo aver svuotato la lista: " + programma.getNumeroEventi());
    }
}
