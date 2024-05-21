package ejercicio3;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


/*3.	Crea una colección en Mongo llamada examen y guarda un documento con los datos del examen de hoy.
 Estos datos serán nombre_asignatura, hora_realizacion, aula, profesor.
  Crea manualmente unos cuantos documentos más dentro de la colección y realiza las siguientes acciones:
-	Busca todos los exámenes de un aula concreta y muéstralos
-	Actualiza todos los exámenes del profesor Borja Martin y ponlos a la misma hora
*/

public class Mongo {

    public static void main(String[] args) {


        //CONFIGURACION MONGODB

        //Conexion:
        String connectionString = "mongodb+srv://admin:admin@cluster0.ouifo0z.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        //Crea un server para realizar la conexion:
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        //Driver para Mongo. Nos permite conectar con el cluster (no con la DB):
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        //1. Conectar con el servidor:
        MongoClient mongoClient = MongoClients.create(connectionString);
        //2. Crear la DB. Si no esta creada la crea. Para que la cree minimo tiene que tener una coleccion:
        MongoDatabase mongoDatabase = mongoClient.getDatabase("academia");
        //2.1 Creamos la coleccion de la DB.
//        mongoDatabase.createCollection("examen");
        //3. Obtener la coleccion de la DB:
        MongoCollection collection = mongoDatabase.getCollection("examen");

        //4. INSERTAR DOCUMENTOS:
        //create:

        Document insertarAsignatura1 = new Document();
        insertarAsignatura1.append("Nombre_asignatura: ", "Acceso a datos");
        insertarAsignatura1.append("Hora_examen: ", "18:30");
        insertarAsignatura1.append("Aula: ", 306);
        insertarAsignatura1.append("Profesor: ", "Borja Martin");
        collection.insertOne(insertarAsignatura1);

        Document insertarAsignatura2 = new Document();
        insertarAsignatura2.append("Nombre_asignatura: ", "PMDP");
        insertarAsignatura2.append("Hora_examen: ", "21:00");
        insertarAsignatura2.append("Aula: ", 306);
        insertarAsignatura2.append("Profesor: ", "Borja Martin");
        collection.insertOne(insertarAsignatura2);

        Document insertarAsignatura3 = new Document();
        insertarAsignatura3.append("Nombre_asignatura: ", "PSP");
        insertarAsignatura3.append("Hora_examen: ", "19:30");
        insertarAsignatura3.append("Aula: ", 306);
        insertarAsignatura3.append("Profesor: ", "Javier Navazo");
        collection.insertOne(insertarAsignatura3);

        Document insertarAsignatura4 = new Document();
        insertarAsignatura4.append("Nombre_asignatura: ", "Desarrollo de interfaces");
        insertarAsignatura4.append("Hora_examen: ", "20:30");
        insertarAsignatura4.append("Aula: ", 306);
        insertarAsignatura4.append("Profesor: ", "Javier Navazo");
        collection.insertOne(insertarAsignatura4);


    }
}
