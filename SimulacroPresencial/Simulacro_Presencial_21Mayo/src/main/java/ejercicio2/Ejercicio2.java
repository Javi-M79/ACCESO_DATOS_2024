package ejercicio2;

import ejercicio2.controller.DAOAlumno;
import ejercicio2.model.Alumno;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Ejercicio2 {


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los datos del alumno:");
        System.out.println("Nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Apellido:");
        String apellido = teclado.nextLine();
        System.out.println("Correo:");
        String correo = teclado.nextLine();

        Alumno alumno = new Alumno(nombre, apellido, correo);
        DAOAlumno operacionesAlumno = new DAOAlumno();
        operacionesAlumno.insertarAlumno(alumno);

    }


}
