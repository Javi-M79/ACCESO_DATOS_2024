import java.io.*;

public class Entrada {

    public static void main(String[] args) {

        //Creamos el archivo con la ruta por parametro.
        File file = new File("src/resources/archivo.txt");

        try {
            //Creamos los flujos de lectura.
            //1. File reader. Leemos enteros en codigo Ascii
            FileReader fileReader = new FileReader(file);
            int ascii;
            String texto = "";
            while ((ascii = fileReader.read()) != -1) {
                System.out.print(ascii);
                texto += (char) ascii;
            }
            System.out.println("\n");
            System.out.println("Traduccion del codigo ASCII: " + texto);

            //2. Con BufferReader. Leemos cadenas
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String linea = "";
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println("Lectura con BufferedReader: " + linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado." + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
