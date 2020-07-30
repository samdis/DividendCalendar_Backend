package com.divcal.resource;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.divcal.api.DividendApi;
import com.divcal.model.DividendResponse;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DividendResource {

    private DividendApi dividendApi;

    @Inject
    public DividendResource(DividendApi dividendApi) {
        this.dividendApi = dividendApi;
    }

    @GET
    @Path("getDividendByDate")
    public DividendResponse makePrediction(@QueryParam("date") Date date) {
        return dividendApi.getDividend(date);
    }
}
