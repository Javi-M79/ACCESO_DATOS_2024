package ejercicio1;


/*1.	Crea un sistema de cifrado / descifrado en java. Para ello el sistema guardará en un fichero .txt un mensaje
 con caracteres cifrados. De la misma forma realizar una lectura de dicho mensaje mostrándolo descifrado
 *** Para cifrar un mensaje se guardará en el archivo con código asci del carácter que se quiera guardar pero multiplicado por 2
 *** Para descifrar el mensaje habrá que hacer el proceso contrario
 */

import java.io.*;

public class Ejercicio1Cifrado {

    public static void main(String[] args) {

        //Creamos el archivo de lectura
        File file = new File("src/main/java/ejercicio1/resources/archivo.txt");
        String texto = "La contraseña es Segundo de Dam";

        Ejercicio1Cifrado ejercicio1Cifrado = new Ejercicio1Cifrado();
        //Accedo a los metodos.
//        ejercicio1Cifrado.lectura(file);
//        ejercicio1Cifrado.escribirTextoCifrado(file, texto);
        ejercicio1Cifrado.lecturaTextoCifrado(file);

    }


    public void lecturaTextoCifrado(File file) {
        BufferedReader reader = null;
        try {
            //Cuando leemos con FileReader, leemos enteros correspondiente al codigo ascci de la letra.
            reader = new BufferedReader(new FileReader(file));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] codigoAscii = linea.split(" ");
                StringBuilder textoDescifrado = new StringBuilder();
                for (String valor : codigoAscii) {
                    if (!valor.trim().isEmpty()) {
                        int letra = Integer.parseInt(valor) / 2;
                        textoDescifrado.append((char) letra);
                    }
                }
                System.out.println(textoDescifrado);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void escribirTextoCifrado(File file, String texto) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            //Escritura:
            fileWriter = new FileWriter(file, true); //true agreaga lineas al contenido existente.
            bufferedWriter = new BufferedWriter(fileWriter);


//Recorremos el texto como un Array de Char.
            for (char c : texto.toCharArray()) {
                //Casteamos los caracteres a int.
                int ascii = (int) c * 2;
                bufferedWriter.write(ascii + " ");

            }
            bufferedWriter.newLine();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado." + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de I/O" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error cerrando el bufferedWriter" + e.getMessage());
                throw new RuntimeException(e);
            }

        }


    }


}

