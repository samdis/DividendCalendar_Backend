package com.divcal.hk2;

import javax.inject.Singleton;

import org.bson.Document;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.divcal.api.DividendApi;
import com.divcal.service.DividendService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DiviCalBinder extends AbstractBinder {

    public DiviCalBinder() {
    }

    @Override protected void configure() {
        System.out.println("i suck");
        MongoClient mongoClient = new MongoClient();
        MongoDatabase development = mongoClient.getDatabase("development");
        MongoCollection<Document> collection = development.getCollection("finance");

        // https://www.freecodecamp.org/news/a-quick-intro-to-dependency-injection-what-it-is-and-when-to-use-it-7578c84fa88f/
        bind(collection).to(MongoCollection.class).named("financeCollection");
        bind(DividendService.class).to(DividendApi.class).in(Singleton.class);
    }

}
