package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QualificationEntity extends BaseEntity{
    private static String DEFAULT_SQL="SELECT * FROM qualifications";
    private List<Qualification> findByCriteria(String sql){
        List<Qualification > qualifications;
        if(getConnection()!=null) {
            qualifications = new ArrayList<>();
            try {
                ResultSet resultSet= getConnection().createStatement().executeQuery(sql);

                while(resultSet.next()){
                    Qualification qualification= new Qualification()
                            .setId(resultSet.getInt( "qualification_id" ))
                            .setBarman(resultSet.getString( "qualification_barman" ));
                    qualifications.add(qualification);
                }
                return qualifications;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    public List<Qualification> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }
    public  Qualification findById(int id){
        List<Qualification> qualifications= findByCriteria(
                DEFAULT_SQL +
                        "WHERE qualifications_id =" +
                        String.valueOf(id));
        return  (qualifications != null ? qualifications.get(0):null);
    }
    public Qualification findByBarman(String barman){
        List<Qualification> qualifications = findByCriteria(
                DEFAULT_SQL + "WHERE qualification_names=" + barman +"'");
        return(qualifications !=null ? qualifications.get(0):null);

    }

    private int getMaxId(){
        String sql = "SELECT MAX(qualifications_id) AS max_id FROM qualifications";
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

    public Qualification create(String barman) {
        if (findByBarman(barman) == null) {
            if (getConnection() != null) {
                String sql = "INSER INTO qualification(qualification_id,qualification_barman)" + "VALUES(" + String.valueOf(getMaxId() + 1) + ",'"
                        + barman + "')";
                int results = updatebyCriteria(sql);
                if (results > 0) {
                    Qualification qualification = new Qualification(getMaxId(), barman);
                    return qualification;
                }
            }
        }
        return null;
    }


    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM qualification WHERE qualification_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String barman){
        return updatebyCriteria("DELETE FROM notification WHERE qualification_barman ='"+barman+"'")>0;
    }
/*
    public boolean update(Barman qualification){
        return updatebyCriteria("UPDATE qualification SET qualification_barman ='"+qualification.getName()+"'WHERE qualification_id="+
                String.valueOf(qualification.getId()))>0;
    } */

}

