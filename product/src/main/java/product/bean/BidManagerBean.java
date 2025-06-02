package product.bean;

import core.dto.BidDTO;
import core.model.Product;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import product.model.ProductManager;
import product.remote.BidService;

import java.util.List;

@Stateless(mappedName = "com.yasithsandesh.bidsquare.product.remote.BidService")
public class BidManagerBean implements BidService {
    @Inject
    private ProductManager productManager;

    @Override
    @Lock(LockType.WRITE)
    public List<Product> placeBid(BidDTO bidDTO) {
        return productManager.addBid(bidDTO);
    }

}
