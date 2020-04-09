package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private Integer creditos = 0;
	private ArrayList<Curso> cursando;
	private ArrayList<Curso> aprobados;

	
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.creditos=0;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	} 

	public int creditosObtenidos() {
		return this.creditos;
	}
	
	public void aprobar(Curso c) {
		this.aprobados.add(c);
	}
	
	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	public int cantidadCursos() {
		return this.cursando.size();
	}
	
	public boolean equals(Alumno a) {
		if (this.nroLibreta == a.nroLibreta) return true;
		return false;
	}

	@Override
	public int compareTo(Alumno o) {
		return this.nombre.compareToIgnoreCase(o.nombre);	
	}
	
	

}
