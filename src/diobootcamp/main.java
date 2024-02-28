package diobootcamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import diobootcamp.dominio.Bootcamp;
import diobootcamp.dominio.Conteudo;
import diobootcamp.dominio.Curso;
import diobootcamp.dominio.Dev;
import diobootcamp.dominio.Mentoria;

public class main {
	public static void main(String[] args) {
		Curso cursoJavaBasico = new Curso();
		cursoJavaBasico.setTitulo("Java Básico");
		cursoJavaBasico.setDescricao("Aprenda os conceitos básicos sobre java");
		cursoJavaBasico.setCargaHoraria(8);
		
		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("C# .NET");
		cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#");
		cursoDotNet.setCargaHoraria(8);
		
		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avançado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avançado sobre Java Avancado");
		cursoJavaAvancado.setCargaHoraria(8);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
		mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos.");
		mentoria.setData(LocalDateTime.now().plusDays(2));
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setName("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(10));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);
		
		
		Dev freire = new Dev();
		freire.setName("Freire");
		
		Dev lukis = new Dev();
		lukis.setName("Freire");
		
		freire.inscrever(cursoDotNet);
		freire.inscrever(bootcamp);
		freire.progredir();
		freire.progredir();
		
		lukis.inscrever(bootcamp);
		lukis.progredir();
		lukis.progredir();
		lukis.progredir();
		
		System.out.println(String.format("XP Freire: %.2f", freire.calcularTotalXp()));
		System.out.println(String.format("XP Lukis: %.2f", lukis.calcularTotalXp()));
		
		List<Dev> ranking = Arrays.asList(freire,lukis).stream().sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp())).collect(Collectors.toList());
	
		for (Dev dev : ranking) {
			System.out.println(dev.getName());
		}
	}
}
