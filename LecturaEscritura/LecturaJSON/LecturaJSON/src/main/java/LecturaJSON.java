import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LecturaJSON {

    public static void main(String[] args) {

        //URL de consulta
        try {
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=4328&s=2020-2021");
            //Creamos la conexion
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Creamos un BufferReader para recoger los datos que llegan de la conexion
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Recogemos en un StringBuilder el contenido del JSON
            StringBuilder stringBuilder = new StringBuilder();
            String linea = null;
            while ((linea = reader.readLine()) != null) {
                stringBuilder.append(linea);
            }

            //JSON general. Tiene el contenido del StringBuilder
            JSONObject response = new JSONObject(stringBuilder.toString());
            //Acceso al array con su clave.
            JSONArray equipos = response.getJSONArray("table");
            //Recorremos el array
            for (int i = 0; i < equipos.length(); i++) {
                //Objetos de cada posicion del array
                JSONObject equipo = equipos.getJSONObject(i);
                String clasificacion = equipo.getString("intRank");
                String nombre = equipo.getString("strTeam");
                System.out.println(clasificacion + "-" + nombre);
            }


        } catch (MalformedURLException e) {
            System.out.println("Error en la URL de consulta " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en la conexion " + e.getMessage());
            throw new RuntimeException(e);
        }


    }


}
