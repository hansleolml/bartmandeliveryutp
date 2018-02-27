package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserEntity extends BaseEntity {
    private static String DEFAULT_SQL="SELECT * FROM user";
    private List<User> findByCriteria(String sql){
        List<User > users;
        if(getConnection()!=null) {
            users = new ArrayList<>();
            try {
                ResultSet resultSet= getConnection().createStatement().executeQuery(sql);

                while(resultSet.next()){
                    User user= new User()
                            .setId(resultSet.getInt( "users_id" ))
                            .setName(resultSet.getString( "users_name" ));
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    public List<User> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }
    public  User findById(int id) {
        List<User> users = findByCriteria(
                DEFAULT_SQL +
                        "WHERE users_id =" +
                        String.valueOf(id));
        return (users != null ? users.get(0) : null);
    }
        public User findByName(String name){
            List<User> users = findByCriteria(
                    DEFAULT_SQL + "WHERE users_name=" + name + "'");
            return (users != null ? users.get(0) : null);

        }

            private int getMaxId(){
                String sql = "SELECT MAX(users_id) AS max_id FROM users";
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



        public User create(String name) {
            if (findByName(name) == null) {
                if (getConnection() != null) {
                    String sql = "INSER INTO user(user_id,user_name)" + "VALUES(" + String.valueOf(getMaxId() + 1) + ",'"
                            + name + "')";
                    int results = updatebyCriteria(sql);
                    if (results > 0) {
                       User user = new User(getMaxId(), name);
                        return user;
                    }
                }
            }
            return null;
        }



        public boolean delete(int id){
            return updatebyCriteria("DELETE FROM user WHERE user_id ="+String.valueOf(id)) > 0;

        }

        public boolean delete(String name){
            return updatebyCriteria("DELETE FROM user WHERE user_name ='"+name+"'")>0;
        }
/*
    public boolean update(Barman notification){
        return updatebyCriteria("UPDATE notification SET notification_name ='"+notification.getName()+"'WHERE notification_id="+
                String.valueOf(notification.getId()))>0;
    }
*/
    }
