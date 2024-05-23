package json;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LecturaJson {

    public static void main(String[] args) {


        try {
            //Creamos la URL
            URL url = new URL("https://dummyjson.com/products");
            //Creamos la conexion
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Creamnos la lectura de datos
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Creamos un StringBuilder para reacoger todo el JSON
            StringBuffer builder = new StringBuffer();
            String linea = null;
            while ((linea = reader.readLine()) != null) {
                builder.append(linea);
            }
//            System.out.println(builder.toString());


            JSONObject response = new JSONObject(builder.toString());
            JSONArray productos = response.getJSONArray("products");
            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);
                String nommbreProducto = producto.getString("title");
                String categoria = producto.getString("category");
                System.out.println("- " + nommbreProducto + "- Categoria: " + categoria);
            }


        } catch (MalformedURLException e) {
            System.out.println("Error en la url");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
