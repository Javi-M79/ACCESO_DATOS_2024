import java.io.*;

public class Principal {

    public static void main(String[] args) {

        //LECTURA ARCHIVOS
        //Creamos el archivo con la ruta.
        File file = new File("src/resources/archivo.txt");

        String texto =("Practicando para el examen de acceso a datos");
        escritura(texto, file);
        lectura(file);
    }


    //FUNCION LECTURA
    public static void lectura(File file) {
        //Creamos un BufferReader para poder leerlo. Lo creamos fuera del try catch para cerrarlo posteriormente en el finally
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            //Usaremos la linea para recoger lo que tenemos en el archivo.
            String linea;
            String texto = "";
            while ((linea = reader.readLine()) != null) {
                //Agregamos las lineas al texto.
                texto += linea + "\n";
            }
            //Imprimimos el texto leido
            System.out.println(texto);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura (I/O " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();                }
            } catch (IOException e) {
                System.out.println("Error cerrando el bufferedReader" + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    //FUNCION ESCRITURA
    public static void escritura(String texto, File file) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(texto+"\n");
        } catch (IOException e) {
            System.out.println("Error creando los elementos de escritura" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error cerrando el Buffer " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
