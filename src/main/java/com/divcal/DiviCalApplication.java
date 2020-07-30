package com.divcal;

import java.text.SimpleDateFormat;

import com.divcal.hk2.DiviCalBinder;
import com.divcal.resource.DividendResource;

import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
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

        environment.getObjectMapper().setDateFormat(new SimpleDateFormat("MM/dd/yyyy"));

        // Configure HTTP filters and mappers
        JerseyEnvironment jersey = environment.jersey();

        jersey.register(new DiviCalBinder());

        // Expose the HTTP endpoint
        jersey.register(DividendResource.class);

    }

}
