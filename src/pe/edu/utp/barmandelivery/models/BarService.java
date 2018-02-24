package pe.edu.utp.barmandelivery.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BarService {
    private Connection connection;
    private BarmansEntity barmansEntity;

    private Connection getConnection() {
        if(connection == null) {
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSource2"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected BarmansEntity getBarmansEntity() {
        if(getConnection() != null) {
            if(barmansEntity == null) {
                barmansEntity = new BarmansEntity();
                barmansEntity.setConnection(getConnection());
            }
        }
        return barmansEntity;
    }


    public List<Barman> findAllBarmans() {
        return getBarmansEntity() != null ?
                getBarmansEntity().findAll() : null;
    }
    
    public Barman findBarmanById(int id) {
        return getBarmansEntity() != null ?
                getBarmansEntity().findById(id) : null;
    }

    public Barman findBarmanByName(String name) {
        return getBarmansEntity() != null ?
                getBarmansEntity().findByName(name) : null;
    }


    public boolean deleteBarman(int id) {
        return getBarmansEntity() != null ?
                getBarmansEntity().delete(id) : false;
    }
/*
    public boolean updateBarman(Barman barman) {
        return getBarmansEntity() != null ?
                getBarmansEntity().update(barman) : false;
    }*/
}
