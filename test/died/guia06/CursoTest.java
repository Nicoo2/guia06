package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	
}


