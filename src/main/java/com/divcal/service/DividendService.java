package com.divcal.service;

import java.util.Date;
import java.util.List;

import com.divcal.api.DividendApi;
import com.divcal.model.BatchDividendResponse;
import com.divcal.model.DividendResponse;

public class DividendService implements DividendApi {

    @Override public DividendResponse getDividend(String ticker) {
        return null;
    }

    @Override public BatchDividendResponse getDividends(List<String> tickers) {
        return null;
    }

    @Override public DividendResponse getDividend(Date date) {
        return null;
    }
}
