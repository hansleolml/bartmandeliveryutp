package pe.edu.utp.barmandelivery.beans;

import pe.edu.utp.barmandelivery.models.BarService;
import pe.edu.utp.barmandelivery.models.Drink;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DrinksBean implements Serializable {

    private BarService service;
    private Drink drink;

    public DrinksBean(){
        service= new BarService();
    }

    public List<Drink> getDrinks(){

        return service.findAllDrinks();
    }
    public Drink getDrink(){
        return drink;
    }

    public void setDrink(Drink drink){
        this.drink =drink;
    }

    public String getName(){

        return this.getDrink().getName();
    }
    public void setName(String name){
        this.getDrink().setName(name);
    }
    public String newDrink(){
        this.setDrink(new Drink());
        return "success";
    }

    public String editDrink(Drink drink){
        this.setDrink(drink);
        return "success";
    }

    public String contractDrink(Drink drink){
        this.setDrink(drink);
        return "success";
    }



}