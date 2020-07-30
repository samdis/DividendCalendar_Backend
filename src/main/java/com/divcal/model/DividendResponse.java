package com.divcal.model;

import java.util.Date;
import java.util.List;

public class DividendResponse {

    private String ticker;

    private List<Date> dates;

    public DividendResponse() {

    }

    public DividendResponse(String ticker, List<Date> dates) {
        this.ticker = ticker;
        this.dates = dates;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
