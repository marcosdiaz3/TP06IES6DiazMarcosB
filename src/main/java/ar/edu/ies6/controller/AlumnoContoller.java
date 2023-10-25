package ar.edu.ies6.controller;

public class AlumnoContoller {
	@GetMapping({"/index", "/", "/home", "/alumno"})
	public ModelAndView cargarAlumno() {
		
		Alumno alu = new Alumno ();
		
		alu.setFechaNac(LocalDate.of(1988, 8, 20));
		System.out.println("Edad: "+alu.obtenerEdad());
		
		ModelAndView modelView = new ModelAndView ("index");
		
		modelView.addObject("alumno", alu);
		
		return modelView;	
	}
	
	@PostMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		ListadoAlumnos.getListado().add(alumno);
 	
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		modelView.addObject("listado", ListadoAlumnos.getListado());
		
		return modelView;	
	}
	
}
}
