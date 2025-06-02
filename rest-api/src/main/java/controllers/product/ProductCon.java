package controllers.product;

import com.google.gson.Gson;
import core.dto.ProductDTO;
import core.dto.ResponseDTO;
import core.model.Product;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.remote.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductCon", urlPatterns = {"/ProductCon"})
public class ProductCon extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Gson gson = new Gson();
      ResponseDTO responseDTO = new ResponseDTO();
      ProductDTO productDTO = gson.fromJson(request.getReader(), ProductDTO.class);
     try {
         boolean status = productService.addProduct(productDTO);
         if(status){
             responseDTO.setMessage("Product added successfully");
             responseDTO.setStatus(status);
         }else{
             responseDTO.setStatus(false);
             responseDTO.setMessage("Product not added successfully");
         }
     }catch (Exception e){

     }
      response.setContentType("application/json");
      response.getWriter().print(gson.toJson(responseDTO));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson =  new Gson();
        List<Product> productList = productService.getProducts();
        resp.setContentType("application/json");
        resp.getWriter().print(gson.toJson(productList));
    }
}
