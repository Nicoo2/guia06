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

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getNroLibreta() {
		return nroLibreta;
	}
	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	public ArrayList<Curso> getCursando() {
		return cursando;
	}


	public void setCursando(ArrayList<Curso> cursando) {
		this.cursando = cursando;
	}


	public ArrayList<Curso> getAprobados() {
		return aprobados;
	}


	public void setAprobados(ArrayList<Curso> aprobados) {
		this.aprobados = aprobados;
	}

//////
	public int creditosObtenidos() {
		return this.creditos;
	}
	
	public void aprobar(Curso c) { // elimina el curso aprobado de las lista 'cursando'
		this.aprobados.add(c);
		this.cursando.remove(c);		
	}
	
	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	public int cantidadCursos() {
		return this.cursando.size();
	}
	
	public int cantidadCursos(Integer unCiclo) {
		int res = 0;
		for(Curso c: this.cursando) {	
			if( (int) c.getCicloLectivo() == (int) unCiclo){
				
				res +=1;	
			}
		}
		return res;	
	}
	
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nroLibreta=" + nroLibreta + ", creditos=" + creditos + "]" +"\n";
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
