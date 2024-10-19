package tarea_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Alumno {

	private int dni;
	private String nombre;
	private String apellidos;
	private String ciclo;
	private String curso;
	private String grupo;
	private char genero;
	private Date fechaNacimiento;

	public Alumno() {
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void pedirDatos(Scanner sc, int i) {
		boolean fechaValida = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Dime el NIA del alumno " + (i + 1));
			setDni(sc.nextInt());
		} catch (InputMismatchException ime) {
			System.out.println("Error: Debes ingresar un número entero para el NIA.");
			sc.nextLine();
		}
		sc.nextLine();

		System.out.println("Dime el nombre del alumno " + (i + 1));
		setNombre(sc.nextLine());

		System.out.println("Dime los apellidos del alumno " + (i + 1));
		setApellidos(sc.nextLine());

		System.out.println("Dime el genero del alumno " + (i + 1) + " (H/M)");
		do {
			setGenero(sc.next().charAt(0));
			if (getGenero() != 'H' && getGenero() != 'M') {
				System.out.println("Error: Debes ingresar 'H' para Hombre o 'M' para Mujer.");
			}
		} while (getGenero() != 'H' && getGenero() != 'M');
		sc.nextLine();

		do {
			try {
				System.out.println("Dime la fecha de nacimiento del alumno " + (i + 1) + " (formato: dd/MM/yyyy):");
				String fecha_text = sc.nextLine();
				Date fecha = sdf.parse(fecha_text);
				setFechaNacimiento(fecha);
				fechaValida = true;
			} catch (ParseException e) {
				System.out.println("Error: La fecha ingresada no es válida. Inténtalo de nuevo.");
			}
		} while (!fechaValida);

		System.out.println("Dime el ciclo del alumno " + (i + 1));
		setCiclo(sc.nextLine());

		System.out.println("Dime el curso del alumno " + (i + 1));
		setCurso(sc.nextLine());

		System.out.println("Dime el grupo del alumno " + (i + 1));
		setGrupo(sc.nextLine());
	}
}