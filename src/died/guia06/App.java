package died.guia06;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

import died.guia06.util.CompararAlumnoCreditos;
import died.guia06.util.CompararAlumnoNombre;
import died.guia06.util.CompararAlumnosNroLibreta;
import died.guia06.util.CreditosInsuficientesException;
import died.guia06.util.CupoCubiertoException;
import died.guia06.util.CursosLimiteException;
import died.guia06.util.RegistroAuditoriaExcepcion;

public class App {

	public static void main(String[] args) {
		
				ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
				
				//SE CREAN LOS CURSOS
				Curso DIED =  new Curso(128, "DIED", 2020, 11, 6, 0);
				Curso MatematicaSuperior =  new Curso(129, "Matematica Superior", 2020, 8, 5, 20);
				Curso Fisica =  new Curso(211, "Fisica", 2019, 15, 8, 0);
				Curso Quimica =  new Curso(98, "Quimica", 2020, 3, 7, 5);
				Curso Algebra =  new Curso(51, "Algebra", 2019, 7, 10, 25);
				// SE CREAN lOS ALUMNOS
				Alumno al1 = new Alumno("Nicolas Springer", 25423);
				Alumno al2 = new Alumno("Juan Perez", 25351);
				Alumno al3 = new Alumno("Anabel Re", 25000);
				Alumno al4 = new Alumno("Marcelo Acuña", 27563);
				Alumno al5 = new Alumno("Francisco Manzo", 20896);
				Alumno al6 = new Alumno("Ruben Perez", 23132);
				Alumno al7 = new Alumno("Ramiro Rodriguez", 2371);
				Alumno al8 = new Alumno("Jorge Mercado", 21000);
				Alumno al9 = new Alumno("Leonel Gomez", 26987);
				Alumno al10 = new Alumno("Lucia Gonzales", 21873);
				//ALMACENO LOS ALUMNOS EN UN LISTA AUXILIAR
				listaAlumnos.add(al1);listaAlumnos.add(al6);
				listaAlumnos.add(al2);listaAlumnos.add(al7);
				listaAlumnos.add(al3);listaAlumnos.add(al8);
				listaAlumnos.add(al4);listaAlumnos.add(al9);
				listaAlumnos.add(al5);listaAlumnos.add(al10);
				// ASIGNANDO CREDITOS A LOS ALUMNOS
				al1.setCreditos(0);
				al2.setCreditos(11);
				al3.setCreditos(31);
				al4.setCreditos(4);
				al5.setCreditos(16);
				al6.setCreditos(30);
				al7.setCreditos(41);
				al8.setCreditos(11);
				al9.setCreditos(0);
				al10.setCreditos(2);		
				System.out.println("(+) Se crearon los siguientes Alumnos de ejemplo: ");
				for(Alumno a: listaAlumnos) {
					System.out.print(a.toString());
				}
				System.out.println("================================================================");
				// INSCRIBIENDO LOS ALUMNOS
				System.out.println("* Inscribiendo Alumnos a un Curso de ejemplo...");
				DIED.inscribir(al1);
				DIED.inscribir(al2);
				DIED.inscribir(al3);
				DIED.inscribir(al4);
				System.out.println("Cantidad Inscriptos en DIED: " + DIED.cantidadAlumnosInscriptos() +"\n");

				DIED.imprimirInscriptos();
				System.out.println("\n");
				System.out.println("================================================================");
				
				//NOTIFICACION A LOS ALUMNOS INSCRIPTOS
				System.out.println("* Ingresando los cursos a lista 'cursando' en los Alumnos (de manera manual): ");

				al1.inscripcionAceptada(Fisica);  //inscripcion manual
				// al2.inscripcionAceptada(Quimica);
				System.out.println("Por ejemplo el Alumno : " + al1.toString() + " sus cursos son : ");
				
				for(Curso c : al1.getCursando()) {
					System.out.println(c.toString());
				}
				System.out.println("================================================================");
				System.out.println("Cantidad de cursos para el Alumno: " +al1.toString() + "es de: "+ al1.cantidadCursos());
				int cicloEjemplo=2020;
				System.out.println("Cantidad de cursos en el ciclo lectivo <"+cicloEjemplo+"> para el Alumno: " +al1.toString() + "es de: "+ al1.cantidadCursos(cicloEjemplo));
				System.out.println("================================================================");
				//APROBACION DE UN CURSO PARA UN ALUMNO
				al1.aprobar(Fisica);
				System.out.println("Cursos aprobado para: "+al1.toString());
				for(Curso c: al1.getAprobados()) {
					System.out.println(c.toString());
				}
				System.out.println("================================================================");
				//HASTA AQUI PASO 06
				/////////////
				
				//FORZANDO LA EXCEPCION
				System.out.println("* Se forzara un mensaje de error, tratando de inscribir a :");
				System.out.print(al9.toString());
				System.out.println("Al curso: " + Algebra);
				System.out.println("");
				try {
					Algebra.inscribirAlumno(al9);
				} catch (CupoCubiertoException | CreditosInsuficientesException | CursosLimiteException| RegistroAuditoriaExcepcion e) { //multicatch
					// TODO Auto-generated catch block
					System.out.println(e.getMessage()); 
				}
				
	}
}
