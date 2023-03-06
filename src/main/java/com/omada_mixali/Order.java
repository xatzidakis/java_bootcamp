
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {


    @Id
    @GeneratedValue
    private Integer id;
    private List<Product> orderList;
    private String orderDescription;

    public Order(){

        this.orderList = new ArrayList<Product>();

    }

    public void setOrderList(Product person ){
        orderList.add(person);

    }

    public List<Product> getOrderlist(){
        return orderList;

    }

    public void setOrderDescription(String description){

        this.orderDescription = description;

    }

    public String getOrderDescription(){
        return this.orderDescription;
    }



}
