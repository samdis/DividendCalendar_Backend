package com.divcal.service;

import java.util.*;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.Document;

import com.divcal.api.DividendApi;
import com.divcal.model.BatchDividendResponse;
import com.divcal.model.DividendResponse;
import com.divcal.utils.DividendUtil;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

public class DividendService implements DividendApi {

    private MongoCollection collection;

    @Inject
    public DividendService(@Named("financeCollection") MongoCollection collection) {
        this.collection = collection;
    }

    @Override public DividendResponse getDividend(String ticker) {
        DividendResponse dividendResponse = new DividendResponse();
        dividendResponse.setTicker(ticker);
        List<Date> dateList = new ArrayList<Date>();
        for(Object result : collection.find(eq("symbol", ticker))) {
            Document docResult = (Document) result;

            dateList.add(DividendUtil.stringToDate(docResult.getString(("exdate"))));
        }
        dividendResponse.setDates(dateList);
        return dividendResponse;
    }

    @Override public BatchDividendResponse getDividends(List<String> tickers) {
        BatchDividendResponse batchDividendResponse = new BatchDividendResponse();
        List<DividendResponse> dividends = new ArrayList<>();
        batchDividendResponse.setDividends(dividends);
        ListIterator<String> tickersIterator = tickers.listIterator();

        while (tickersIterator.hasNext()) {
            dividends.add(getDividend(tickersIterator.next()));
        }

        return batchDividendResponse;
    }

    @Override public BatchDividendResponse getDividends(String date) {
        BatchDividendResponse batchDividendResponse = new BatchDividendResponse();
        List<DividendResponse> dividends = new ArrayList<>();
        batchDividendResponse.setDividends(dividends);

        for (Object result : collection.find(eq("exdate", date))) {
            Document docResult = (Document) result;

            DividendResponse dividendResponse = new DividendResponse();
            dividendResponse.setTicker(docResult.getString("symbol"));
            dividendResponse.setDates(Collections.singletonList(DividendUtil.stringToDate(date)));

            dividends.add(dividendResponse);
        }

        return batchDividendResponse;
    }
}
