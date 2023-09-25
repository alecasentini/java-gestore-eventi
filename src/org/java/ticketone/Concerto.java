package org.java.ticketone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) {
		super(titolo, data, postiTotali);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
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

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		String oraFormattata = ora.format(timeFormatter);

		return dataFormattata + " " + oraFormattata + " - " + getTitolo() + " - " + String.format("%.2f€", prezzo);
	}
}

