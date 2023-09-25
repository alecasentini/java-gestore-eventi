package org.java.ticketone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
            sb.append("- ").append(evento.getData()).append(" - ").append(evento.getTitolo()).append("\n");
        }

        return sb.toString();
    }


}