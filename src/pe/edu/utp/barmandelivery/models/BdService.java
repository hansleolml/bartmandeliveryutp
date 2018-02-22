package pe.edu.utp.barmandelivery.models;

import java.sql.Connection;
import java.util.List;

public class BdService {
    private Connection connection;
    private BarmansEntity barmansEntity;//debe retornar una instancia de region entity, pero no es necesario visualizarlo


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public BarmansEntity getBarmansEntity() {
        if (getConnection()!=null){
            if (barmansEntity==null){
                barmansEntity=new BarmansEntity();
                barmansEntity.setConnection(getConnection());
            }
        }
        return barmansEntity;
    }


    public List<Barman> findAllBarman(){
        return getBarmansEntity() !=null ?
                getBarmansEntity().findAll():null;
    }

    public Barman findBarmanById(int id){
        return getBarmansEntity()!=null ?
                getBarmansEntity().findById(id):null;
    }

    public Barman findBarmanByName(String name) {
        return getBarmansEntity() != null ?
                getBarmansEntity().findByName(name) : null;
    }

    public Barman createBarman(String name){
        return getBarmansEntity()!=null?
                getBarmansEntity().create(name):null;
    }

    public boolean deleteBarman(int id){
        return getBarmansEntity()!= null ?
                getBarmansEntity().delete(id):false;
    }
    public  boolean updateBarman(Barman region){
        return getBarmansEntity() != null ?
                getBarmansEntity().update(region) : false;
    }




}
