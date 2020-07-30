package com.divcal.api;

import java.util.Date;
import java.util.List;

import com.divcal.model.BatchDividendResponse;
import com.divcal.model.DividendResponse;

public interface DividendApi {

    DividendResponse getDividend(String ticker);

    BatchDividendResponse getDividends(List<String> tickers);

    DividendResponse getDividend(Date date);

}
