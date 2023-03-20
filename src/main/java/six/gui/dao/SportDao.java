package six.gui.dao;

import six.gui.dao.connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportDao implements Dao<Sport> {
    @Override
    public Sport save(Sport entity) {
            return null;
    }

    @Override
    public List<Sport> getAll() {
        List<Sport> sports = new ArrayList<>();
        String sqlQuery = "SELECT * FROM sport";
        //1. konekcija s bazom
        Connection connection = ConnectionPool.getInstance().getConnection();
        //2. PreparedStatement ili Statement
        try(PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery)){
            //3. java.sql.Result
            //3.1 ResultSetMetada
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()){
                Sport sport = new Sport();
                sport.setId_sport(resultSet.getLong(1));

                sport.setSport_name(resultSet.getString(2));
                sport.setDesciption(resultSet.getString(3));
                sports.add(sport);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        ConnectionPool.getInstance().releaseConnection(connection);
        return sports;
    }

    @Override
    public Sport get(Long id) {
        return null;
    }

    @Override
    public Sport update(Sport entity) {
        return null;
    }

    @Override
    public boolean delete(Sport entity) {
        return false;
    }
    public List<String> getColumnNamesSport(){
        List<String> columnNamesSport = new ArrayList<>();
        String sqlQuery = "SELECT * FROM sport";
        //1. konekcija s bazom
        Connection connection = ConnectionPool.getInstance().getConnection();
        //2. PreparedStatement ili Statement
        try(PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery)){
            //3. java.sql.Result
            //3.1 ResultSetMetada
            ResultSet resultSet = prepareStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for(int i = 1; i<=columnCount; i++){
                String columName = resultSetMetaData.getColumnName(i);
                columnNamesSport.add(columName);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return columnNamesSport;
    }

}
