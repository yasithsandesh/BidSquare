package product.remote;

import core.dto.ProductDTO;
import core.model.Product;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ProductService {
   public boolean addProduct(ProductDTO productDTO);
   public List<Product> getProducts();
}
