package org.java.ticketone;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi {
    
    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }
    
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo (String titolo) {
		this.titolo= titolo;
	}

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }
    
    public List<Evento> getEventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : this.eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }
    
    public int getNumeroEventi() {
    	return this.eventi.size();
    }
    
    public void svuotaListaEventi() {
    	this.eventi.clear();
    }
    
    public String mostraEventi() {
        
        this.eventi.sort(Comparator.comparing(Evento::getData));

        StringBuilder sb = new StringBuilder();
        sb.append(this.titolo).append("\n");

        
        for (Evento evento : this.eventi) {
            sb.append(evento.toString()).append("\n");
        }

        return sb.toString();
    }
    
    public BigDecimal mediaPrezzoConcerto() {
        List<Evento> concerti = eventi.stream()
                .filter(evento -> evento instanceof Concerto)
                .collect(Collectors.toList());

        return concerti.stream()
                .map(evento -> ((Concerto) evento).getPrezzo())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(concerti.size()), 2, RoundingMode.HALF_UP);
    }


    public BigDecimal mediaPrezzoSpettacolo() {
        List<Evento> spettacoli = eventi.stream()
                .filter(evento -> evento instanceof Spettacolo)
                .collect(Collectors.toList());

        return spettacoli.stream()
                .map(evento -> ((Spettacolo) evento).getPrezzo())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(spettacoli.size()), 2, RoundingMode.HALF_UP);
    }


    public BigDecimal mediaPrezzoEvento() {
        return eventi.stream()
                .filter(evento -> evento instanceof Concerto || evento instanceof Spettacolo)
                .map(evento -> {
                    if (evento instanceof Concerto) {
                        return ((Concerto) evento).getPrezzo();
                    } else {
                        return ((Spettacolo) evento).getPrezzo();
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(eventi.size()), 2, RoundingMode.HALF_UP);
    }



}