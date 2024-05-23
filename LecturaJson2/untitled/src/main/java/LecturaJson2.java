import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LecturaJson2 {


    public static void main(String[] args) {

        //Creamos la url de conexion
        //Creamos la conexion
        try {
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=4328&s=2020-2021");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Creamos el buffer que leera los datos:

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Creamos un SrtingBuider para recoger todo el contenido del JSON

            StringBuilder builder = new StringBuilder();
            //Creamos un String para ir guardando linea a linea y agregarlo al builder
            String linea = null;

            while ((linea = reader.readLine()) != null) {
                builder.append(linea);
            }


            //Comenzamos a obtener datos del JSON


            JSONObject response = new JSONObject(builder.toString());
            JSONArray equipos = response.getJSONArray("table");
            //Recorremos el JSONArray
            for (int i = 0; i < equipos.length(); i++) {
                JSONObject equipo = equipos.getJSONObject(i);
                String clasificacion = equipo.getString("intRank");
                String nombre = equipo.getString("strTeam");
                String goles = equipo.getString("intGoalsAgainst");
                System.out.println(clasificacion + "-" + nombre + "\nGoles: " + goles);
            }


        } catch (MalformedURLException e) {
            System.out.println("Error en la url" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en la conexion");
            throw new RuntimeException(e);
        }


    }


}
