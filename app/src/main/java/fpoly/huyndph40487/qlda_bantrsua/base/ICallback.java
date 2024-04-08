package fpoly.huyndph40487.qlda_bantrsua.base;

import java.util.List;

import fpoly.huyndph40487.qlda_bantrsua.Model.Product;
import fpoly.huyndph40487.qlda_bantrsua.Model.ProductCart;

public interface ICallback{
    void callback(List<ProductCart> productCart);

    void insert(Product product);
}