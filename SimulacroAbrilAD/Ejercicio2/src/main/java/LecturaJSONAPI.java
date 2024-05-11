import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LecturaJSONAPI {


    /*2.	Realiza la lectura del JSON ubicado en la siguiente URL
     https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=4328&s=2020-2021*/

    //En este ejercicio hay que descargar la dependencia de JSON en el pom.xml
    public static void main(String[] args) {

        try {

            //1. Crear un objeto de tipo URL
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=4328&s=2020-2021");
            //2. Creamos la conexion y la igualamos a la url abriendo la conexion (casteando la url).
            //De esta manera solo tenemos la cabecera
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //3. Usamos un bufferedReader para la lectura del JSON pasandole por parametro un inputstream reader
            //que se encarga de coger el flujo que recibe la conexion/

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Podemos comprobar si hemos conectado recuperando el JSON completo
            //System.out.println(bufferedReader.readLine());

            //LECTURA DEL JSON COMPLETO
            //4. Creamos un StringBuffer para asegurar que cogemos el JSON de forma completa
            StringBuilder stringBuffer = new StringBuilder();

     /*       String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                //5. Anexamos la linea al stringbuffer
                stringBuffer.append(linea);
                System.out.println(stringBuffer.toString());
            }*/

            JSONObject reponse = new JSONObject(stringBuffer.toString());
            JSONArray teams = reponse.getJSONArray("table");
            for (int i = 0; i < teams.length(); i++) {
                JSONObject equipo = teams.getJSONObject(i);
                String nombre = equipo.getString("strTeam");

                System.out.println((i + 1) + "-" + nombre);
            }

        } catch (MalformedURLException e) {
            System.out.println("La url no es valida." + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en la conexion.");
        }

    }

}
