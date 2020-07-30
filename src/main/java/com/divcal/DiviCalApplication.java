package com.divcal;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DiviCalApplication extends Application<DiviCalConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DiviCalApplication().run(args);
    }

    @Override
    public String getName() {
        return "DiviCal";
    }

    @Override
    public void initialize(final Bootstrap<DiviCalConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DiviCalConfiguration configuration,
        final Environment environment) {
        System.out.println("i suck");
        MongoClient mongoClient = new MongoClient();
        MongoDatabase development = mongoClient.getDatabase("development");
        MongoCollection<Document> collection = development.getCollection("finance");
    }

}
