package died.guia06;

import java.util.List;


public class Alumno {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos = 0;
	
	
	public int creditosObtenidos() {
		return this.creditos;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	public int cantidadCursos() {
		return this.cursando.size();
	}
	
	

}
