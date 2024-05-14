package ejercicio1;

import java.io.*;

public class MensajeCifrado {

    public static void main(String[] args) {

        //Creamos el archivo
        File file = new File("src/main/java/ejercicio1/resources/archivo.txt");
        //Creamos los elementos para la escritura y la lectura
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        BufferedReader reader = null;
        FileReader fileReader = null;

        try {
            fileWriter = new FileWriter(file, true);
            writer = new BufferedWriter(fileWriter);
//            writer.write("La contraseña de la caja fuerte es" + "Alejandra");
//            writer.newLine();

            //Leemos el archivo. Usamos un FileReader para leer los caracteres como enteros.
            fileReader = new FileReader(file);
            int letras = (fileReader.read()) * 2;
            StringBuilder texto = new StringBuilder();
            while (letras > -1) {
                System.out.println(letras);
                letras = (fileReader.read() * 2);
                texto.append((char) letras);
            }




//            reader = new BufferedReader(fileReader);
//            String linea = "";
//            while ((linea = reader.readLine()) != null) {
//                letras = fileReader.read()/2;
//
//                texto.append(linea);
//                linea = reader.readLine();
//            }
//
//            System.out.println(texto);
            //Desciframos mensaje
//            int descifrado = (fileReader.read() / 2);
//            while (descifrado > -1) {
//                System.out.println(descifrado);
//                descifrado = (fileReader.read() / 2);
//                texto.append((char) descifrado);
//            }
//            System.out.println("Mensaje descifrado" + texto);

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
