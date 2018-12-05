package com.curso.app;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  
        System.out.println( "Hello World!" );
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:Formacion2018@ds161316.mlab.com:61316/bdcursoangel"); 

        MongoClient client = new MongoClient(uri);

        MongoDatabase db = client.getDatabase(uri.getDatabase());

           MongoCollection<Document> pelis = db.getCollection("peliculas");
        FindIterable<Document> lista = pelis.find();
        for (Document peli : lista)
        {
            System.out.println(peli.toJson());
        }
        client.close();
/*        MongoCredential credencial = MongoCredential.createCredential("admin", "bdcursoangel", "Formacion2018@".toCharArray());
        MongoClient mongo = MongoClients.create(
        MongoClientSettings.builder()
                .applyToClusterSettings(builder -> 
                        builder.hosts(Arrays.asList(new ServerAddress("ds161316.mlab.com", 61316))))
                .credential(credencial)
                .build());
        MongoDatabase baseDatos = mongo.getDatabase("bdcursoangel");
        MongoCollection<Document> pelis = baseDatos.getCollection("pelis");
        FindIterable<Document> lista = pelis.find();
        for (Document doc : lista)
        {
            System.out.println(doc.toJson());
        }*/
    }

}
