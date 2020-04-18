package died.guia06.util;

import java.util.Comparator;

import died.guia06.Alumno;

public class CompararAlumnoCreditos implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		
		if(o1.getCreditos() < o2.getCreditos()) {
			return -1;
		}
		else if(o1.getCreditos() > o2.getCreditos()) {
			return 1;
		}
			else return 0;
	}
	

	
	
}
