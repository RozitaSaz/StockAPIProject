package com.app.stock.controller;

import com.app.stock.dto.StockDto;
import com.app.stock.message.ResponseMessage;
import com.app.stock.service.StockService;
import com.app.stock.service.file.CSVConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Rozita on 10/18/21.
 */
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/stocks-management")
public class StockController {

    private final Logger log = LoggerFactory.getLogger(StockController.class);

    @Autowired
    StockService stockService;

    @PostMapping("/uploadStocks")
    public ResponseEntity<ResponseMessage> saveBulkStocks(@RequestParam("file") MultipartFile file) {
        String message;

        if (CSVConverter.hasCSVFormat(file)) {
            try {
                stockService.saveBulkStocks(file);

                message = "File " + file.getOriginalFilename() + " saved successfully.";
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not save the file " + file.getOriginalFilename() + "!";
                log.error("Could not save the file " + file.getOriginalFilename() + "!");
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


    @PostMapping("/saveStock")
    public ResponseEntity<ResponseMessage> addStock(@RequestBody StockDto stockDto) {
        try {
            stockService.saveStock(stockDto);
            String message = "stock " + stockDto.getName() + " saved successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            String message = "Could not save stock: " + stockDto.getName();
            log.error("Could not save stock: " + stockDto.getName());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/findStocks")
    public ResponseEntity<List<StockDto>> findStock(String stockName) {
        try {
            List<StockDto> stocks = stockService.findStock(stockName);

            if (stocks.isEmpty()) {
                log.debug("Could not find any Stock");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {

                return new ResponseEntity<>(stocks, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Could not find Stock for this exception: " + e.getCause().getMessage());
            return new ResponseEntity<>((List<StockDto>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
