package diobootcamp.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bootcamp {
	private String name;
	private LocalDate inicio;
	private LocalDate fim;
	private List<Conteudo> conteudos = new ArrayList<>();
	private List<Dev> devs = new ArrayList<>();
	
	
	
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Dev> getDevs() {
		return devs;
	}
	public void setDevs(List<Dev> devs) {
		this.devs = devs;
	}
	
}
