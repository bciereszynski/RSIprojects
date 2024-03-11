package database;

import java.io.Serializable;

public class Product implements Serializable {
    public int id;
    public int value;
    public String name;

    public Product(int _id, int _value, String _name){
        id=_id;
        value=_value;
        name=_name;
    }

}
