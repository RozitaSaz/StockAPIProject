package com.app.stock.dto;

/**
 * Created by Rozita on 10/21/21.
 */
public class StockDto {

    private String quarter;

    private String name;

    private String logDate;

    private String open;

    private String high;

    private String low;

    private String close;

    private String volume;

    private String percentChangePrice;

    private String percentChangeVolumeOverLastWeek;

    private String previousWeeksVolume;

    private String nextWeeksOpen;

    private String nextWeeksClose;

    private String percentChangeNextWeeksPrice;

    private String daysToNextDividend;

    private String percentReturnNextDividend;

    public StockDto() {
    }

    public StockDto(String quarter, String name, String date, String open, String high, String low, String close,
                    String volume, String percentChangePrice, String percentChangeVolumeOverLastWeek,
                    String previousWeeksVolume, String nextWeeksOpen, String nextWeeksClose, String percentChangeNextWeeksPrice,
                    String daysToNextDividend, String percentReturnNextDividend) {
        this.quarter = quarter;
        this.name = name;
        this.logDate = date;
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

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String date) {
        this.logDate = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPercentChangePrice() {
        return percentChangePrice;
    }

    public void setPercentChangePrice(String percentChangePrice) {
        this.percentChangePrice = percentChangePrice;
    }

    public String getPercentChangeVolumeOverLastWeek() {
        return percentChangeVolumeOverLastWeek;
    }

    public void setPercentChangeVolumeOverLastWeek(String percentChangeVolumeOverLastWeek) {
        this.percentChangeVolumeOverLastWeek = percentChangeVolumeOverLastWeek;
    }

    public String getPreviousWeeksVolume() {
        return previousWeeksVolume;
    }

    public void setPreviousWeeksVolume(String previousWeeksVolume) {
        this.previousWeeksVolume = previousWeeksVolume;
    }

    public String getNextWeeksOpen() {
        return nextWeeksOpen;
    }

    public void setNextWeeksOpen(String nextWeeksOpen) {
        this.nextWeeksOpen = nextWeeksOpen;
    }

    public String getNextWeeksClose() {
        return nextWeeksClose;
    }

    public void setNextWeeksClose(String nextWeeksClose) {
        this.nextWeeksClose = nextWeeksClose;
    }

    public String getPercentChangeNextWeeksPrice() {
        return percentChangeNextWeeksPrice;
    }

    public void setPercentChangeNextWeeksPrice(String percentChangeNextWeeksPrice) {
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
    }

    public String getDaysToNextDividend() {
        return daysToNextDividend;
    }

    public void setDaysToNextDividend(String daysToNextDividend) {
        this.daysToNextDividend = daysToNextDividend;
    }

    public String getPercentReturnNextDividend() {
        return percentReturnNextDividend;
    }

    public void setPercentReturnNextDividend(String percentReturnNextDividend) {
        this.percentReturnNextDividend = percentReturnNextDividend;
    }

    @Override
    public String toString() {
        return "Stock [name=" + getName() + ", quarter=" + getQuarter() + ", date=" + getLogDate();
    }
}
