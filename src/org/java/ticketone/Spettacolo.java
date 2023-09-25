package org.java.ticketone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Spettacolo extends Evento {
	
	private BigDecimal prezzo;
	
	public Spettacolo(String titolo, LocalDate data, int postiTotali, BigDecimal prezzo) {
		super(titolo, data, postiTotali);
		
		this.prezzo = prezzo;
	}
	
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String dataFormattata = getData().format(dateFormatter);

	    return dataFormattata + " - " + getTitolo() + " - " + String.format("%.2f€", prezzo);
	}


}
