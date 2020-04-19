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
	////
	public Boolean inscribir(Alumno a) { // !!! añade a la lista 'cursando' del Alumno a el curso que recibe el mensaje
		try {
			if ((a.creditosObtenidos() >= this.creditosRequeridos)  && (inscriptos.size() < cupo) && (a.cantidadCursos(cicloLectivo) < 3)) {
				log.registrar(this, "inscribir ", a.toString());
				inscriptos.add(a);
				a.inscripcionAceptada(this);
				return true;
			}
			else {
				// System.out.println("No cumple con algún requisito.");
				return false;
			}			
		} catch (IOException e) {
			//System.out.println("Falló el metodo registrar.");
			e.printStackTrace();
			return false;
		}
		
			
	}

	public boolean imprimirInscriptos() { // retorna TRUE si pudo imprimir
		ArrayList<Alumno> auxLista = this.inscriptos;
		
		try {	
			System.out.println("Ingrese numero operacion:" );
			System.out.println("1 - Por nombres alfabeticamente");
			System.out.println("2 - Por numero de libreta");
			System.out.println(" 3 - Por total de creditos");
			System.out.println("\n");
			System.out.println("0 - Cancelar operación.");
			
			Scanner scan = new Scanner(System.in);
			int opcion = scan.nextInt(); 
			scan.close();
			
			switch (opcion) {
			case 1:
				log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
					Collections.sort(auxLista, new CompararAlumnoNombre());
					System.out.println(auxLista);
					return true;
				//break;
			case 2:
				log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
					Collections.sort(auxLista, new CompararAlumnosNroLibreta());
					System.out.println(auxLista);
					return true;
				//break;
			case 3:
				log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
					Collections.sort(auxLista, new CompararAlumnoCreditos());
					System.out.println(auxLista);
					return true;
				//break;				
			case 0:
				System.out.println("Operacion cancelada." + "\n");
				return true;
				//break;
			default:
				return false;
				//break;
			}

		} catch (IOException e) {
			//System.out.println("Fallo el metodo registrar.");
			e.printStackTrace();
			return false;
		}
	} 
	
	public int cantidadAlumnosInscriptos() {
		return this.inscriptos.size();
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", cicloLectivo=" + cicloLectivo + "]";
	}
	
	
	
}
