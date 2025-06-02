package core.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Product implements Serializable {
    private long id;
    private String name;
    private String description;
    private double startingPrice;
    private double currentHighestBid;
    private String url;
    private boolean isSold;
    private Map<Long, Double> bidMap;

    {
        this.bidMap = new LinkedHashMap<>();
    }
    public Product() {}

    public Product(long id, String name, String description, double startingPrice, double currentHighestBid, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentHighestBid = currentHighestBid;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getCurrentHighestBid() {
        return currentHighestBid;
    }

    public void setCurrentHighestBid(double currentHighestBid) {
        this.currentHighestBid = currentHighestBid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public Map<Long, Double> getBidMap() {
        return bidMap;
    }

    public void setBidMap(Map<Long, Double> bidMap) {
        this.bidMap = bidMap;
    }
}
