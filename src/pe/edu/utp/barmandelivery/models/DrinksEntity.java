package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrinksEntity extends BaseEntity{
    private static String DEFAULT_SQL="SELECT * FROM bar.drinks_lists";

    private List<Drink> findByCriteria(String sql) {
        List<Drink> drinks;
        if(getConnection() != null) {
            drinks = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Drink drink = new Drink()
                            .setName(resultSet.getString("name"));
                    drinks.add(drink);
                }
                return drinks;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Drink> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }
    public  Drink findById(int id){
        List<Drink> drinks= findByCriteria(
                DEFAULT_SQL +
                        "WHERE drink_id =" +
                        String.valueOf(id));
        return  (drinks!= null ? drinks.get(0):null);
    }
    public Drink findByName(String name){
        List<Drink> drinks = findByCriteria(
                DEFAULT_SQL + "WHERE drink_name=" + name +"'");
        return(drinks !=null ? drinks.get(0):null);


    }

    private int getMaxId(){
        String sql = "SELECT MAX(drink_id) AS max_id FROM drinks";
        if(getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ? resultSet.getInt("max_id"):0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int updatebyCriteria(String sql){
        if (getConnection()!=null){
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /*
        public Drink create(String name) {
            if (findByName(name) == null) {
                if (getConnection() != null) {
                    String sql = "INSER INTO drinks(barman_id,barman_name)" + "VALUES(" + String.valueOf(getMaxId() + 1) + ",'"
                            + name + "')";
                    int results = updatebyCriteria(sql);
                    if (results > 0) {
                        Drink barman = new Drink(getMaxId(), name);
                        return barman;
                    }
                }
            }
            return null;
        }*/
    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM drinks WHERE barman_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM drinks WHERE barman_name ='"+name+"'")>0;
    }
/*
    public boolean update(Drink barman){
        return updatebyCriteria("UPDATE drinks SET barman_name ='"+barman.getName()+"'WHERE barman_id="+
                String.valueOf(barman.getId()))>0;
    }*/

}