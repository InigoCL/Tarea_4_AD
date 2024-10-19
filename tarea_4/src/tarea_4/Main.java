package tarea_4;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int NUMERO_ALUMNOS = 5;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el nombre del fichero en el que quieres guardar la información");
		String nombre = sc.nextLine();

		System.out.println("Dime la ruta donde quieres guardar el archivo");
		String ruta = sc.nextLine();

		if (ruta.equalsIgnoreCase("")) {
			ruta = "src";
		}

		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(ruta + "\\" + nombre + ".bin"));
			for (int i = 0; i < NUMERO_ALUMNOS; i++) {
				Alumno a = new Alumno();
				a.pedirDatos(sc, i);
				dos.writeInt(a.getDni());
				dos.writeUTF(a.getNombre());
				dos.writeUTF(a.getApellidos());
				dos.writeChar(a.getGenero());
				dos.writeLong(a.getFechaNacimiento().getTime());
				dos.writeUTF(a.getCiclo());
				dos.writeUTF(a.getCurso());
				dos.writeUTF(a.getGrupo());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			sc.close();
		}
	}

}
