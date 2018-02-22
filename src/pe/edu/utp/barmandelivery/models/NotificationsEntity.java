package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationsEntity extends BaseEntity{
    private static String DEFAULT_SQL="SELECT * FROM notifications";
    private List<Notification> findByCriteria(String sql){
        List<Notification > notifications;
        if(getConnection()!=null) {
            notifications = new ArrayList<>();
            try {
                ResultSet resultSet= getConnection().createStatement().executeQuery(sql);

                while(resultSet.next()){
                   Notification notification= new Notification()
                            .setId(resultSet.getInt( "notifications_id" ))
                            .setName(resultSet.getString( "notifications_name" ));
                    notifications.add(notification);
                }
                return notifications;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    public List<Notification> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }
    public  Notification findById(int id){
        List<Notification> notifications= findByCriteria(
                DEFAULT_SQL +
                        "WHERE notifications_id =" +
                        String.valueOf(id));
        return  (notifications != null ? notifications.get(0):null);
    }
    public Notification findByName(String name){
        List<Notification> notifications = findByCriteria(
                DEFAULT_SQL + "WHERE notifications_name=" + name +"'");
        return(notifications !=null ? notifications.get(0):null);


    }

    private int getMaxId(){
        String sql = "SELECT MAX(notifications_id) AS max_id FROM notifications";
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

    public Notification create(String name) {
        if (findByName(name) == null) {
            if (getConnection() != null) {
                String sql = "INSER INTO notification(notification_id,notification_name)" + "VALUES(" + String.valueOf(getMaxId() + 1) + ",'"
                        + name + "')";
                int results = updatebyCriteria(sql);
                if (results > 0) {
                    Notification notification = new Notification(getMaxId(), name);
                    return notification;
                }
            }
        }
        return null;
    }

    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM notification WHERE notification_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM notification WHERE notification_name ='"+name+"'")>0;
    }

    public boolean update(Barman notification){
        return updatebyCriteria("UPDATE notification SET notification_name ='"+notification.getName()+"'WHERE notification_id="+
                String.valueOf(notification.getId()))>0;
    }

}














