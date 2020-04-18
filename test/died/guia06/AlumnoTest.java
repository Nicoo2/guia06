package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	public void testCreditosObtenidos() {
		//fail("Not yet implemented");
		// setup:
		Alumno alumno1 = new Alumno("Nicolas Springer", 25423);
		// ejecucion:
		Integer resultado =  alumno1.creditosObtenidos();
		// verificacion:
		Integer esperado = 0;
		assertEquals(esperado, resultado, "Deberian ser guales");
		// tearDown
	}

	
	
	@Test
	void testAprobar() {
		//setup
		Alumno alumno1  =new Alumno("Nicolas Springer", 25423);
		alumno1.aprobar(new Curso(0 ,"Test", 2020, 10, 5, 0));
		//
		Integer resultado = alumno1.getAprobados().size();
		//
		Integer esperado = 1; // longitud de la lista
		//
		assertEquals(esperado, resultado, "Deberian ser iguales.");
	}

	@Test
	void testInscripcionAceptada() {
		
		Alumno alumno1  =new Alumno("Nicolas Springer", 25423);
		alumno1.inscripcionAceptada(new Curso(0 ,"Test", 2020, 10, 5, 0));
		//
		Integer resultado = alumno1.cantidadCursos(); 
		//
		Integer esperado = 1;
		//
		assertEquals(esperado, resultado, "Deberian ser iguales.");
	}
	@Test
	void testCantidadCursosEnMismoCicloLectivo() {
		
		Alumno alumno1  =new Alumno("Nicolas Springer", 25423);
		alumno1.inscripcionAceptada(new Curso(0 ,"Test1", 2020, 10, 5, 0));
		alumno1.inscripcionAceptada(new Curso(1 ,"Test2", 2019, 11, 6, 0));
		alumno1.inscripcionAceptada(new Curso(2 ,"Test3", 2019, 12, 7, 0));
		alumno1.inscripcionAceptada(new Curso(3, "Test4", 2020, 10, 0, 0));
		//
		Integer resultado = alumno1.cantidadCursos(2020); 
		//
		Integer esperado = 2;
		//
		assertEquals(esperado, resultado, "Deberian ser iguales.");
	}
	
}
