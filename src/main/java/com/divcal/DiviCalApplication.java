package com.divcal;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

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
