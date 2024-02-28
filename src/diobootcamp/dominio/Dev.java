package diobootcamp.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dev {
	private String name;
	private List<Conteudo> conteudosInscritos = new ArrayList<>();
	private List<Conteudo> conteudosConcluidos = new ArrayList<>();

	public void inscrever(Conteudo conteudo) {
		if (conteudosInscritos.contains(conteudo)) {
			System.err.println("Você ja está cadastrado!");
		} else {
			conteudosInscritos.add(conteudo);
		}

	}

	public void inscrever(Bootcamp bootcamp) {
		// Alternativa 1: foreach tradicional.
		for (Conteudo conteudo : bootcamp.getConteudos()) {
			inscrever(conteudo);
		}
		// Alternativa 2: API de Stream.
		//bootcamp.getConteudos().stream().forEach(this::inscrever);
		bootcamp.getDevs().add(this);

	}

	public void progredir() {
		Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			conteudosConcluidos.add(conteudo.get());
			conteudosInscritos.remove(conteudo.get());
		}else {
			System.err.println("Você não está mais inscrito em nenhum conteudo!");
		}
	}

	public double calcularTotalXp() {
		return conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(List<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public List<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(List<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

}
