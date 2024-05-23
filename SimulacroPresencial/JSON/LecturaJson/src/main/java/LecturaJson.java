import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.ToDoubleBiFunction;

public class LecturaJson {

    public static void main(String[] args) {

        //Descargar las dependencias JSON para Maven y sincronizar el pom


        try {
            //Creamos la url donde vamos a conectar
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=4328&s=2020-2021");
            //Creamos la conexion y la abrimos
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            //Usamos un bufferReader para leer los datos.
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            //Lectura del JSON
            //Con el Stringbuffer garantizamos que el JSON esta bien formado al poder mostrarlo/
            StringBuilder builder = new StringBuilder();
            String linea = null;

            while ((linea = reader.readLine()) != null) {
                //Anexamos la linea al builder par poder mostrar el JSON por consola
                builder.append(linea);
            }
//            System.out.println(builder);

            //Iniciamos la lectura

            JSONObject response = new JSONObject(builder.toString());
            JSONArray equipos = response.getJSONArray("table");

            for(int i =0; i<equipos.length(); i++){
                JSONObject equipo = equipos.getJSONObject(i);
                String nombre = equipo.getString("strTeam");
                String liga = equipo.getString("strLeague");
                System.out.println((i + 1) + "-" + nombre + ": Liga: " + liga);

            }

        } catch (MalformedURLException e) {
            System.out.println("Error en la url " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No se puede realizar la conexion" + e.getMessage());
            throw new RuntimeException(e);
        }


    }


}
