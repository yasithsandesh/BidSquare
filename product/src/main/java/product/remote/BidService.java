package product.remote;

import core.dto.BidDTO;
import core.model.Product;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface BidService {
    List<Product> placeBid(BidDTO bidDTO);
}
