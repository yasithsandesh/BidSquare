package core.dto;

import java.io.Serializable;

public class BidDTO implements Serializable {
    private long userId;
    private long productId;
    private double bidAmount;

    public BidDTO(){}
    public BidDTO(long userId, long productId, double bidAmount) {
        this.userId = userId;
        this.productId = productId;
        this.bidAmount = bidAmount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
