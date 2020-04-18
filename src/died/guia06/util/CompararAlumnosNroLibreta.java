package died.guia06.util;

import java.util.Comparator;

import died.guia06.Alumno;

public class CompararAlumnosNroLibreta implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		if(o1.getNroLibreta() < o2.getNroLibreta()) {
			return -1;
		}
		else if(o1.getNroLibreta() > o2.getNroLibreta()) {
			return 1;
		}
			else return 0;
	}	
	
}
		
