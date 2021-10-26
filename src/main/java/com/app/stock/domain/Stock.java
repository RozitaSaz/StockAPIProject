package com.app.stock.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rozita on 10/18/21.
 */
@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long ID;

    @Column(name = "quarter")
    private Integer quarter;

    @Column(name = "name")
    private String name;

    @Column(name = "log_date")
    private Date date;

    @Column(name = "open_value")
    private Double open;

    @Column(name = "high_value")
    private Double high;

    @Column(name = "low_value")
    private Double low;

    @Column(name = "close_value")
    private Double close;

    @Column(name = "volume")
    private Long volume;

    @Column(name = "percent_change_price")
    private Float percentChangePrice;

    @Column(name = "percent_change_volume_over_last_wk")
    private Float percentChangeVolumeOverLastWeek;

    @Column(name = "previous_weeks_volume")
    private Long previousWeeksVolume;

    @Column(name = "next_weeks_open_value")
    private Double nextWeeksOpen;

    @Column(name = "next_weeks_close_value")
    private Double nextWeeksClose;

    @Column(name = "percent_change_next_weeks_price")
    private Float percentChangeNextWeeksPrice;

    @Column(name = "days_to_next_dividend")
    private Integer daysToNextDividend;

    @Column(name = "percent_return_next_dividend")
    private Float percentReturnNextDividend;

    public Stock() {
    }

    public Stock(Integer quarter, String name, Date date, Double open, Double high, Double low, Double close,
                 Long volume, Float percentChangePrice, Float percentChangeVolumeOverLastWeek, Long previousWeeksVolume,
                 Double nextWeeksOpen, Double nextWeeksClose, Float percentChangeNextWeeksPrice, Integer daysToNextDividend,
                 Float percentReturnNextDividend) {
        this.quarter = quarter;
        this.name = name;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percentChangePrice = percentChangePrice;
        this.percentChangeVolumeOverLastWeek = percentChangeVolumeOverLastWeek;
        this.previousWeeksVolume = previousWeeksVolume;
        this.nextWeeksOpen = nextWeeksOpen;
        this.nextWeeksClose = nextWeeksClose;
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
        this.daysToNextDividend = daysToNextDividend;
        this.percentReturnNextDividend = percentReturnNextDividend;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Float getPercentChangePrice() {
        return percentChangePrice;
    }

    public void setPercentChangePrice(Float percentChangePrice) {
        this.percentChangePrice = percentChangePrice;
    }

    public Float getPercentChangeVolumeOverLastWeek() {
        return percentChangeVolumeOverLastWeek;
    }

    public void setPercentChangeVolumeOverLastWeek(Float percentChangeVolumeOverLastWeek) {
        this.percentChangeVolumeOverLastWeek = percentChangeVolumeOverLastWeek;
    }

    public Long getPreviousWeeksVolume() {
        return previousWeeksVolume;
    }

    public void setPreviousWeeksVolume(Long previousWeeksVolume) {
        this.previousWeeksVolume = previousWeeksVolume;
    }

    public Double getNextWeeksOpen() {
        return nextWeeksOpen;
    }

    public void setNextWeeksOpen(Double nextWeeksOpen) {
        this.nextWeeksOpen = nextWeeksOpen;
    }

    public Double getNextWeeksClose() {
        return nextWeeksClose;
    }

    public void setNextWeeksClose(Double nextWeeksClose) {
        this.nextWeeksClose = nextWeeksClose;
    }

    public Float getPercentChangeNextWeeksPrice() {
        return percentChangeNextWeeksPrice;
    }

    public void setPercentChangeNextWeeksPrice(Float percentChangeNextWeeksPrice) {
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
    }

    public Integer getDaysToNextDividend() {
        return daysToNextDividend;
    }

    public void setDaysToNextDividend(Integer daysToNextDividend) {
        this.daysToNextDividend = daysToNextDividend;
    }

    public Float getPercentReturnNextDividend() {
        return percentReturnNextDividend;
    }

    public void setPercentReturnNextDividend(Float percentReturnNextDividend) {
        this.percentReturnNextDividend = percentReturnNextDividend;
    }

    @Override
    public String toString() {
        return "Stock [name=" + getName() + ", quarter=" + getQuarter() + ", date=" + getDate();
    }
}