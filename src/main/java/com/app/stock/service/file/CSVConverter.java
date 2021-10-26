package com.app.stock.service.file;

import com.app.stock.domain.Stock;
import com.app.stock.util.DateUtil;
import com.app.stock.util.StringUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rozita on 10/18/21.
 */
public class CSVConverter {

    public static String TYPE = "text/csv";
    public static final String DOLLAR_SIGN = "$";
    private static String PARSE_EXCEPTION = "failed to parse CSV file: ";
    private static String INVALID_DATE = "failed to parse CSV file cause of invalid date values.";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Stock> csvToStocks(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Stock> stocks = new ArrayList<Stock>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Stock stock = new Stock(
                        Integer.valueOf(csvRecord.get(0)),
                        csvRecord.get(1),
                        DateUtil.convertStringToDate(DateUtil.STOCK_DATE_PATTERN, csvRecord.get(2)),
                        Double.valueOf(StringUtil.removeRedundantCharacters(csvRecord.get(3), DOLLAR_SIGN)), //remove $ character at the begining of amount
                        Double.valueOf(StringUtil.removeRedundantCharacters(csvRecord.get(4), DOLLAR_SIGN)), //remove $ character at the begining of amount
                        Double.valueOf(StringUtil.removeRedundantCharacters(csvRecord.get(5), DOLLAR_SIGN)), //remove $ character at the begining of amount
                        Double.valueOf(StringUtil.removeRedundantCharacters(csvRecord.get(6), DOLLAR_SIGN)), //remove $ character at the begining of amount
                        Long.valueOf(csvRecord.get(7)),
                        Float.valueOf(csvRecord.get(8)),
                        //Check to see if percent_change_volume_over_last_wk has value
                        StringUtil.hasText(csvRecord.get(9)) ?
                                Float.valueOf(csvRecord.get(9)) : null,
                        //Check to see if previous_weeks_volume has value
                        StringUtil.hasText(csvRecord.get(10)) ?
                                Long.valueOf(csvRecord.get(10)) : null,
                        Double.valueOf(StringUtil.removeRedundantCharacters(csvRecord.get(11), DOLLAR_SIGN)), //remove $ character at the begining of amount
                        Double.valueOf(StringUtil.removeRedundantCharacters(csvRecord.get(12), DOLLAR_SIGN)), //remove $ character at the begining of amount
                        Float.valueOf(csvRecord.get(13)),
                        Integer.valueOf(csvRecord.get(14)),
                        Float.valueOf(csvRecord.get(15))
                );
                stocks.add(stock);
            }

            return stocks;
        } catch (IOException e) {
            throw new RuntimeException(PARSE_EXCEPTION + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(INVALID_DATE);
        }
    }

}
