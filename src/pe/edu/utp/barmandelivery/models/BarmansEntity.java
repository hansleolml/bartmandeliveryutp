package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarmansEntity extends BaseEntity{
    private static String DEFAULT_SQL="SELECT * FROM bar.users LEFT JOIN bar.bartenders on bar.users.ID = bar.bartenders.users_id";

    private List<Barman> findByCriteria(String sql) {
        List<Barman> barmans;
        if(getConnection() != null) {
            barmans = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Barman barman = new Barman()
                            .setId(resultSet.getInt("bartenders.id"))
                            .setName(resultSet.getString("users.name"))
                            .setSur_names(resultSet.getString("users.sur_names"));
                    barmans.add(barman);
                }
                return barmans;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public List<Barman> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }
    public  Barman findById(int id){
        List<Barman> barmans= findByCriteria(
                DEFAULT_SQL +
                        "WHERE barman_id =" +
                        String.valueOf(id));
        return  (barmans!= null ? barmans.get(0):null);
    }
    public Barman findByName(String name){
        List<Barman> barmans = findByCriteria(
                DEFAULT_SQL + "WHERE barman_name=" + name +"'");
        return(barmans !=null ? barmans.get(0):null);


    }

    private int getMaxId(){
        String sql = "SELECT MAX(barman_id) AS max_id FROM barmans";
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
    public Barman create(String name) {
        if (findByName(name) == null) {
            if (getConnection() != null) {
                String sql = "INSER INTO barmans(barman_id,barman_name)" + "VALUES(" + String.valueOf(getMaxId() + 1) + ",'"
                        + name + "')";
                int results = updatebyCriteria(sql);
                if (results > 0) {
                    Barman barman = new Barman(getMaxId(), name);
                    return barman;
                }
            }
        }
        return null;
    }*/
    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM barmans WHERE barman_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM barmans WHERE barman_name ='"+name+"'")>0;
    }
/*
    public boolean update(Barman barman){
        return updatebyCriteria("UPDATE barmans SET barman_name ='"+barman.getName()+"'WHERE barman_id="+
                String.valueOf(barman.getId()))>0;
    }*/

}
