package ejercicio1;

import java.io.*;
import java.util.Arrays;

public class MensajeCifrado {

    public static void main(String[] args) {

        //Creamos los archivo
        File archivo = new File("src/main/java/ejercicio1/resources/archivo.txt");
        File ascii = new File("src/main/java/ejercicio1/resources/ascii.txt");
        //Creamos los elementos para la escritura y la lectura
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        BufferedReader reader = null;
        FileReader fileReader = null;

        try {

            fileWriter = new FileWriter(archivo, true);
            writer = new BufferedWriter(fileWriter);
//            writer.write("La contraseña de la caja fuerte es " + "Alejandra");

            //Leemos el archivo. Usamos un FileReader para leer los caracteres como enteros.
            fileReader = new FileReader(archivo);
            StringBuilder texto = new StringBuilder();
            int letras = 0;
            //String que contendra los numeros leidos.
            String codigo = "";
            //Preparamos el archivo ascci para escribir en el.
//            fileWriter = new FileWriter(ascii);
//            writer = new BufferedWriter(fileWriter);
//            while (letras > -1) {
//                //Mostramos por consola el valor de las letras que corresponden a un entero
//                System.out.println(letras);
//                //Codificamos el mensaje multiplicando el valor del entero por 2.
//                letras = fileReader.read() * 2;
//                //TODO EL codigo vale -1 que al mutiplicarlo por 2 vale -2.
//                if (letras > -1) {
//                    //Asignamos las letras a un String para poderlo escribir en otro fichero.
//                    codigo += Integer.toString(letras) + " ";
//                }
//            }
//            writer.write(codigo);

//Desciframos el mensaje

            //Leemos el archivo ascii que actualmente es un String.
            reader = new BufferedReader(new FileReader(ascii));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] numeros = linea.trim().split(" ");
                for (String numero : numeros) {
                    int codigoDescodificado = Integer.parseInt(numero)/2;
//                    System.out.println(codigoDescodificado+ " ");
                    System.out.print((char) codigoDescodificado);

                }


            }
////            System.out.println(codigoDescodificado);
//            System.out.println("llegamos hasta aqui pero no hemos leido el fichero");


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("Error cerrando I/O" + e.getMessage());

            }
        }


    }


}
