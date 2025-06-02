package core.dto;

public class ProductDTO {
    private String name;
    private String description;
    private double startingPrice;
    private double currentHighestBid;
    private String url;
    private boolean isSold;

    public ProductDTO() {}

    public ProductDTO(String name, String description, double startingPrice, double currentHighestBid, String url, boolean isSold) {
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentHighestBid = currentHighestBid;
        this.url = url;
        this.isSold = isSold;
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
}
