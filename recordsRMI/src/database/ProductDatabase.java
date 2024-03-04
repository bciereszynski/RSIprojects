package database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDatabase {
    private List<Product> list;
    public ProductDatabase(){
        list = new ArrayList<Product>();
        Product p1 = new Product(1, 20, "pierwszy");
        list.add(p1);
        Product p2 = new Product(2, 25, "pierwszy2");
        list.add(p2);
    }
    public List<Product> getAll(){
        return list;
    }
    public Product get(int id){
        return list.stream().filter(k -> k.id == id).findAny().get();
    }
}
