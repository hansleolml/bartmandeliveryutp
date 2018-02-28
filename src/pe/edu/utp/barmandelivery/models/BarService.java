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
    private ContractsEntity contractsEntity;

    private Connection getConnection() {
        if(connection == null) {
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSource1"))
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
    protected ContractsEntity getContractsEntity() {
        if(getConnection() != null) {
            if(contractsEntity == null) {
                contractsEntity = new ContractsEntity();
                contractsEntity.setConnection(getConnection());
            }
        }
        return contractsEntity;
    }


    public List<Barman> findAllBarmans() {
        return getBarmansEntity() != null ?
                getBarmansEntity().findAll() : null;
    }
    public List<Contract> findAllContracts() {
        return getContractsEntity() != null ?
                getContractsEntity().findAll() : null;
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
