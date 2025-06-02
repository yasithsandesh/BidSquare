package product.bean;

import core.dto.ProductDTO;
import core.model.Product;
import jakarta.ejb.Remote;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import product.model.ProductManager;
import product.remote.ProductService;

import java.util.List;

@Singleton
public class ProductServiceBean implements ProductService {

    @Inject
    private ProductManager productManager;

    @Override
    public boolean addProduct(ProductDTO productDTO) {
        return this.productManager.addProduct(new Product(productManager.getNewProductId(),productDTO.getName(),productDTO.getDescription(),productDTO.getStartingPrice(),productDTO.getCurrentHighestBid(),productDTO.getUrl()));

    }

    @Override
    public List<Product> getProducts() {
        return this.productManager.getProducts();
    }
}
