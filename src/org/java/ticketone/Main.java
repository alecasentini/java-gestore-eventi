package org.java.ticketone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserisci un nuovo evento");
        System.out.print("Titolo: ");
        String titolo = sc.nextLine();
        
        System.out.print("Data (formato: dd/MM/yyyy): ");
        String dataString = sc.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        System.out.print("Posti totali: ");
        int postiTotali = sc.nextInt();
        
        Evento evento = new Evento(titolo, data, postiTotali);
        
        System.out.print("Quanti posti vuoi prenotare? ");
        int postiDaPrenotare = sc.nextInt();
        
        for(int i=0; i<postiDaPrenotare; i++) {
            try {
                evento.prenota();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        
        System.out.print("Quanti posti vuoi disdire? ");
        int postiDaDisdire = sc.nextInt();
        
        for(int i=0; i<postiDaDisdire; i++) {
            try {
                evento.disdici();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        
        sc.close();
    }
}

