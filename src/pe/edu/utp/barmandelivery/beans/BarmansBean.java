package pe.edu.utp.barmandelivery.beans;

import pe.edu.utp.barmandelivery.models.Barman;
import pe.edu.utp.barmandelivery.models.BarService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BarmansBean implements Serializable{

    private BarService service;
    private Barman barman;

    public BarmansBean(){
        service= new BarService();
    }

    public List<Barman> getBarmans(){

        return service.findAllBarmans();
    }
    public Barman getBarman(){
        return barman;
    }

    public void setBarman(Barman barman){
        this.barman =barman;
    }
    /*
    public String getName(){

        return this.getBarman().getName();
    }
    public void setName(String name){
        this.getBarman().setName(name);
    }*/
    public String newBarman(){
        this.setBarman(new Barman());
        return "success";
    }
    /*
    public String createBarman(){

        service.createBarman(this.getName());
        return "success";
    }*/
    public String editBarman(Barman barman){
        this.setBarman(barman);
        return "success";
    }
    /*
    public String updateBarman(){
        service.updateBarman(this.getBarman());
        return "success";
    }*/
    public String contractBarman(Barman barman){
        //service.updateBarman(this.getBarman());
        return "success";
    }
    public String deleteBarman(Barman barman){
        service.deleteBarman(barman.getId());
        return "success";
    }


}
