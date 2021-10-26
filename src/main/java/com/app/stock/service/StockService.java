package com.app.stock.service;

import com.app.stock.dto.StockDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Rozita on 10/18/21.
 */
@Service
public interface StockService {

    void saveBulkStocks(MultipartFile file);

    void saveStock(StockDto stockDto) throws ParseException;

    List<StockDto> findStock(String name);

}
