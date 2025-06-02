package product.model;

import core.dto.BidDTO;
import core.model.Product;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ProductManager {
    private long productId;
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
        System.out.println("ProductManager initialized.");
        System.out.println(this+"+001");
    }


    public boolean addProduct(Product product) {
        this.products.add(product);
        return true;
    }


    public List<Product> getProducts() {
        return products;
    }


    public Long getNewProductId() {
        this.productId+=1;
        return this.productId;
    }




    public List<Product> addBid(BidDTO bidDTO){
        for(Product product : this.products){
            if(product.getId() == bidDTO.getProductId()){
                Map<Long,Double> bidMap =  product.getBidMap();
                bidMap.put(bidDTO.getUserId(),bidDTO.getBidAmount());
                if(product.getCurrentHighestBid()<bidDTO.getBidAmount()){
                    product.setCurrentHighestBid(bidDTO.getBidAmount());
                }
                return this.products;
            }
        }


        return this.products;
    }


    @PreDestroy
    public void destroy() {
        System.out.println("ProductManager is being destroyed.");
    }

}
