import java.io.*;

public class LecturaEscritura2 {


    public static void main(String[] args) {

        File origen = new File("src/main/resources/archivo.txt");
        File destino = new File("src/main/resources/escritura.txt");
        File codigo = new File("src/main/resources/codigo.txt");
        LecturaEscritura2 lectutaArchivos = new LecturaEscritura2();
        lectutaArchivos.lectura(origen);
        lectutaArchivos.escritura(destino);
        lectutaArchivos.convertirCodigo(origen, codigo);

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
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void convertirCodigo(File origen, File codigo) {
        FileReader reader = null;
        BufferedWriter writer = null;
        try {
            //EL file reader devuelve enteros
            reader = new FileReader(origen);
            writer = new BufferedWriter(new FileWriter(codigo));
            int letras;
            StringBuilder builder = new StringBuilder();
            while (reader.read() > -1) {
                letras = (char) reader.read();
                builder.append(letras + " ");
            }
            System.out.println(builder);
            writer.write(String.valueOf(builder));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null || writer != null) {
                try {
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    public void escritura(File file) {

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(file));
            String texto = "Esta es la primera letra escrita en el archivo";
            writer.write(texto);
        } catch (IOException e) {
            System.out.println("Problema con la escritura" + e.getMessage());
            throw new RuntimeException(e);
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void lectura(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String linea = null;
            String texto = "";
            while ((linea = reader.readLine()) != null) {
                texto += linea + "\n";
            }
            System.out.println(texto);

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado." + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en la lectura.");
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
