import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;

public class MongoDB {

    public static void main(String[] args) {

/*3.	Crea una colección en Mongo llamada examen y guarda un documento con los datos del examen de hoy.
 Estos datos serán nombre_asignatura, hora_realizacion, aula, profesor.
  Crea manualmente unos cuantos documentos más dentro de la colección y realiza las siguientes acciones:
-	Busca todos los exámenes de un aula concreta y muéstralos
-	Actualiza todos los exámenes del profesor Borja Martin y ponlos a la misma hora
*/
        //CONFIGURACION MONGODB

        //Conexion:
        String connectionString = "mongodb+srv://root:root@cluster0.ouifo0z.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
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


        //4. CRUD:


        //CREATE:


        //Importamos Document de bson.
  /*      Document insertarAsignatura1 = new Document();
        insertarAsignatura1.append("nombre_asignatura", "Acceso a datos");
        insertarAsignatura1.append("hora_examen", "18:30");
        insertarAsignatura1.append("aula", 306);
        insertarAsignatura1.append("profesor", "Borja Martin");
        collection.insertOne(insertarAsignatura1);

        Document insertarAsignatura2 = new Document();
        insertarAsignatura2.append("nombre_asignatura", "PMDP");
        insertarAsignatura2.append("hora_examen", "21:00");
        insertarAsignatura2.append("aula", 306);
        insertarAsignatura2.append("profesor", "Borja Martin");
        collection.insertOne(insertarAsignatura2);

        Document insertarAsignatura3 = new Document();
        insertarAsignatura3.append("nombre_asignatura", "PSP");
        insertarAsignatura3.append("hora_examen", "19:30");
        insertarAsignatura3.append("aula", 306);
        insertarAsignatura3.append("profesor", "Javier Navazo");
        collection.insertOne(insertarAsignatura3);

        Document insertarAsignatura4 = new Document();
        insertarAsignatura4.append("nombre_asignatura", "Desarrollo de interfaces");
        insertarAsignatura4.append("hora_examen", "20:30");
        insertarAsignatura4.append("aula", 306);
        insertarAsignatura4.append("profesor", "Javier Navazo");
        collection.insertOne(insertarAsignatura4);*/


        //READ:

        //$gt=graderthan/ Mayor que
        //$gte=mayor o igual que
        //$eq=igual
        //$lt=LessThan/ Menor que.
        //$lte=Menor o igual que.
        //$neq= not equal //Filtra todos los diferentes al resto de casos.

        Document documentoFiltro = new Document();
        documentoFiltro.append("aula", new Document().append("$eq", 306));
        FindIterable resultadoFiltrado = collection.find(documentoFiltro); // si no pongo nada en los parentesis me obtiene todos
// Todo: 1º Recorremos el resultado
        MongoCursor cursor = resultadoFiltrado.iterator(); // [r1, r2, r3, r4] -> como un array
// Todo: 2º Preguntamos si hay siguiente (si no hay) -> obtenemos el siguiente -> obtenemos un dato del siguiente
        System.out.println("\n=========RESULTADOS CON FILTRO=========");
        while (cursor.hasNext()) {
            Document documentActual = (Document) cursor.next(); // obtengo el siguiente.
            System.out.printf("Los examenes del aula %s son: %s a las %s horas. %n",
                    documentActual.getInteger("aula"),
                    documentActual.getString("nombre_asignatura"),
                    documentActual.getString("hora_examen"));
        }

        //UPDATE
        Document busqueda = new Document();
        busqueda.append("profesor", "Borja Martin");
        Document documentoNuevo = new Document();
        documentoNuevo.append("hora_examen", "16:00");
        Document cambio = new Document();
        cambio.append("$set", documentoNuevo);
        collection.updateMany(busqueda, cambio);


        //DELETE
        Document borrado = new Document();
        borrado.append("profesor", "Javier Navazo");
        collection.deleteOne(borrado);

    }
}


