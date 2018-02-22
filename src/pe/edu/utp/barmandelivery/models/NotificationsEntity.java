package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationsEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM notifications";
    private List<Notification> findByCriteria(String sql, NotificationsEntity notificationsEntity) {
        List<Notification> notifications = new ArrayList<>();
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while(resultSet.next()) {
                    Notification notification = new Notification(
                            resultSet.getString("notification_id"),
                            resultSet.getString("notification_name"),
                            notificationsEntity
                                    .findById(resultSet
                                            .getInt("notification_id"))
                    );
                    notifications.add(notification);
                }
                return notifications;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public List<Notification> findAll(NotificationsEntity notificationsEntity) {return findByCriteria(DEFAULT_SQL, notificationsEntity);
    }

}
