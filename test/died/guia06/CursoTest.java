package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import died.guia06.util.CreditosInsuficientesException;
import died.guia06.util.CupoCubiertoException;
import died.guia06.util.CursosLimiteException;
import died.guia06.util.RegistroAuditoriaExcepcion;

class CursoTest {

	@Test
	void testInscribir() {

		Curso curso1  = new Curso(0, "TEST", 2020, 10, 5, 10);
		
		Alumno alumno1 = new Alumno("Nicolas Springer", 25423);
		Alumno alumno2 = new Alumno("Test Alumno", 20000); // tiene 0 creditos
		
		alumno1.setCreditos(10);
		//alumno2.setCreditos(15);
		//
		curso1.inscribir(alumno1);
		curso1.inscribir(alumno2);
		//
		Integer resultado = curso1.cantidadAlumnosInscriptos();
		//
		Integer esperado = 1; // puesto que de los dos alumnos
								// solo inscribe 1
		
		assertEquals(esperado, resultado, "Deberian ser iguales.");
		
	}
	
	@Test
	void testImprimirInscriptos() {
		Curso curso1  = new Curso(0, "TEST", 2020, 10, 5, 0);
		
		Alumno alumno1 = new Alumno("Nicolas Springer", 25423);
		Alumno alumno2 = new Alumno("Test Alumno", 20000); 
		curso1.inscribir(alumno1);
		curso1.inscribir(alumno2);
		//
		boolean resultado = curso1.imprimirInscriptos();
		//
		//boolean esperado = true;
		//
		assertTrue(resultado);
	}
	
	@Test
	void testInscribirAlumnosCreditosInsuficientesException() {
		Curso curso1  = new Curso(0, "TEST", 2020, 10, 5, 99);
		
		Alumno alumno1 = new Alumno("Nicolas Springer", 25423);
		
		alumno1.setCreditos(50); //Los crditos seran insuficientes
		boolean esperado = false;
			try {
				curso1.inscribirAlumno(alumno1);				
			} catch (CupoCubiertoException e) {	
			} catch (CreditosInsuficientesException e) {
				//Excepcion esperada
				esperado  = true;		
			} catch (CursosLimiteException e) {	
			} catch (RegistroAuditoriaExcepcion e) {	
			}
		
			assertTrue(esperado);
	
	}
	@Test
	void testInscribirAlumnosCupoCubiertoException() {
		Curso curso1  = new Curso(0, "TEST", 2020, 2, 5, 0);
		
		Alumno alumno1 = new Alumno("Nicolas Springer", 25423);
		Alumno alumno2 = new Alumno("Alumno 1", 25423);
		Alumno alumnoExcepcion = new Alumno("Alumno Excepcion", 25423);

		curso1.inscribir(alumno1);
		curso1.inscribir(alumno2);
		
		boolean esperado = false;
		
			try {
				curso1.inscribirAlumno(alumnoExcepcion);				
			} catch (CupoCubiertoException e) {	
				//Excepcion esperada
				esperado  = true;	
			} catch (CreditosInsuficientesException e) {	
			} catch (CursosLimiteException e) {	
			} catch (RegistroAuditoriaExcepcion e) {	
			}
		
			assertTrue(esperado);
	
	}
	@Test
	void testInscribirAlumnosCursosLimiteException() {
		Curso curso1  = new Curso(0, "TEST", 2020, 10, 5, 0);
		Curso curso2  = new Curso(0, "TEST2", 2020, 10, 5, 0);
		Curso curso3  = new Curso(0, "TEST3", 2020, 10, 5, 0);
		Curso cursoExcepcion  = new Curso(0, "TEST-excepcion", 2020, 10, 5, 0);
		
		Alumno alumno1 = new Alumno("Nicolas Springer", 25423);		
		alumno1.setCreditos(50); 
		
		//Alcanza el limite de cursos para 2020
		curso1.inscribir(alumno1);
		curso2.inscribir(alumno1);
		curso3.inscribir(alumno1);
		
		boolean esperado = false;
		
			try {
				cursoExcepcion.inscribirAlumno(alumno1);				
			} catch (CupoCubiertoException e) {	
			} catch (CreditosInsuficientesException e) {					
			} catch (CursosLimiteException e) {	
				//Excepcion esperada
				esperado  = true;
			} catch (RegistroAuditoriaExcepcion e) {	
			}
		
			assertTrue(esperado);
	
	}
	
}


