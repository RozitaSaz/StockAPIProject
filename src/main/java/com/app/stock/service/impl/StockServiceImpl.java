package com.app.stock.service.impl;

import com.app.stock.domain.Stock;
import com.app.stock.dto.StockDto;
import com.app.stock.repository.StockRepository;
import com.app.stock.service.StockService;
import com.app.stock.service.file.CSVConverter;
import com.app.stock.service.mapper.StockMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rozita on 10/18/21.
 */
public class StockServiceImpl implements StockService {

    private final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockMapper stockMapper;

    @Transactional
    public void saveBulkStocks(MultipartFile file) {
        try {
            List<Stock> stocks = CSVConverter.csvToStocks(file.getInputStream());
            stockRepository.saveAll(stocks);
        } catch (IOException e) {
            log.error("Could not save the file " + file.getOriginalFilename() + "!" + " with this exception:" + e.getMessage());
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Transactional
    public void saveStock(StockDto stockDto) throws ParseException {
        stockRepository.save(stockMapper.convertToEntity(stockDto));
    }

    public List<StockDto> findStock(String name) {
        Stock stock = new Stock();
        stock.setName(name);
        Example<Stock> example = Example.of(stock);
        List<Stock> stockList = stockRepository.findAll(example);
        return stockList.stream().map(stockMapper::convertToDto).collect(Collectors.toList());
    }
}