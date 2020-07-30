package com.divcal.model;

import java.util.List;

public class BatchDividendResponse {

    private List<DividendResponse> dividends;

    public BatchDividendResponse() {
    }

    public BatchDividendResponse(List<DividendResponse> dividends) {
        this.dividends = dividends;
    }

    public List<DividendResponse> getDividends() {
        return dividends;
    }

    public void setDividends(List<DividendResponse> dividends) {
        this.dividends = dividends;
    }
}
