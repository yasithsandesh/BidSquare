package controllers.bid;

import com.google.gson.Gson;
import core.dto.BidDTO;
import core.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.remote.BidService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Bid", urlPatterns = {"/Bid"})
public class Bid extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Gson gson = new Gson();
       BidDTO bidDTO = gson.fromJson(request.getReader(), BidDTO.class);
        try {
            InitialContext ctx = new InitialContext();
            BidService bidService = (BidService) ctx.lookup("com.yasithsandesh.bidsquare.product.remote.BidService");
            List<Product> productList =  bidService.placeBid(bidDTO);

            response.setContentType("application/json");
            response.getWriter().print(gson.toJson(productList));
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
