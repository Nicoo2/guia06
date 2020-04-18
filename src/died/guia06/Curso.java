package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import died.guia06.util.*;
/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private ArrayList<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	//private Integer ultimoInscripto = 0;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditosRequeridos = 0;
	}

	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo,Integer creditos, Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}

	/**
	 * Este metodo, verifica si el alumno se puede inscribir y si es asi lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que estÃ¡ inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno estÃ¡ inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultÃ¡neo a no mÃ¡s de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 * @throws IOException 
	 */
	public Boolean inscribir(Alumno a) {
		
		try {
			
			if ((a.creditosObtenidos() >= this.creditosRequeridos)  && (inscriptos.size() < cupo) && (a.cantidadCursos(cicloLectivo) < 3)) {
				log.registrar(this, "inscribir ", a.toString());
			}
			else {
				System.out.println("No cumple con algún requisito.");
				return false;
			}
			
		} catch (IOException e) {
			//Si falla registrar()
			
			System.out.println("Falló el metodo registrar.");
			e.printStackTrace();
			return false;
			
		}
		//Si no falla registrar()
		inscriptos.add(a);
		a.inscripcionAceptada(this);
		return true;
		
	}
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		ArrayList<Alumno> auxLista = this.inscriptos;
		
		try {	
			System.out.println("Ingrese numero operacion:" );
			System.out.println("1 - Por nombres alfabeticamente");
			System.out.println("2 - Por numero de libreta");
			System.out.println(" 3 - Por total de creditos");
			System.out.println("\n\n");
			System.out.println("0 - Cancelar operación.");
			
			Scanner scan = new Scanner(System.in);
			int opcion = scan.nextInt(); 

			switch (opcion) {
			case 1:
					Collections.sort(auxLista, new CompararAlumnoNombre());
				break;
			case 2:
					Collections.sort(auxLista, new CompararAlumnosNroLibreta());
				break;
			case 3:
					Collections.sort(auxLista, new CompararAlumnoCreditos());
				break;				
			case 0:
				System.out.println("Operacion cancelada.");
				return;

			default:
				break;
			}

			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			
		} catch (IOException e) {
			//Si falla registrar()
			System.out.println("Fallo el metodo registrar.");
			e.printStackTrace();
		}
		
		System.out.println(auxLista);	
		
	}


}
