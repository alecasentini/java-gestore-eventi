package org.java.ticketone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	public Evento(String titolo, LocalDate data, int postiTotali) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
        }
        
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0; 
    }
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo (String titolo) {
		this.titolo= titolo;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
	        if (data.isBefore(LocalDate.now())) {
	            throw new IllegalArgumentException("La data dell'evento non può essere nel passato");
	        }
	        
	        this.data = data;
	}
	
	public int getPostiTotali() {
		return postiTotali;
	}
	
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void prenota() {
		if (data.isBefore(LocalDate.now()) || postiPrenotati == postiTotali){
            throw new IllegalArgumentException("Impossibile procede con la prenotazione");
        }
		postiPrenotati++;
		
	}
	
	public void disdici() {
		if (data.isBefore(LocalDate.now()) || postiPrenotati == 0){
            throw new IllegalArgumentException("Impossibile disdire la prenotazione");
        }
		postiPrenotati--;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormattata = data.format(formatter);
		return dataFormattata + " - " + titolo;
	}
}
