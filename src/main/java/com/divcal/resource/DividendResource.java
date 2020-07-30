package com.divcal.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.divcal.api.DividendApi;
import com.divcal.model.BatchDividendResponse;

@Path("dividends")
@Produces(MediaType.APPLICATION_JSON)
public class DividendResource {

    // We are given the interface DividendApi instead of constructing the concrete implementation DividendService
    // This is called inversion of control. This object is supplied through dependency injection
    // https://dzone.com/articles/ioc-vs-di
    private DividendApi dividendApi;

    @Inject
    public DividendResource(DividendApi dividendApi) {
        this.dividendApi = dividendApi;
    }

    @GET
    @Path("getByDate")
    public BatchDividendResponse makePrediction(@QueryParam("date") String date) {
        return dividendApi.getDividends(date);
    }
}
