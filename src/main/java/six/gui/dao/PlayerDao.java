package org.akademija.six.gui.dao;

import org.akademija.six.gui.dao.connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PlayerDao implements Dao<Player>{
    @Override
    public Player save(Player entity) {
        return null;
    }

    @Override
    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        String sqlQuery = "SELECT* FROM players p join sport s on p.sport=s.id_sport;";
        //1. konekcija s bazom
        Connection connection = ConnectionPool.getInstance().getConnection();
        //2. PreparedStatement ili Statement
        try(PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery)){
            //3. java.sql.Result
            //3.1 ResultSetMetada
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()){
                Player player = new Player();
                player.setId(resultSet.getLong(1));
                player.setName(resultSet.getString("name"));
                player.setSurname(resultSet.getString("surname"));
                player.setSport(resultSet.getString("sport_name"));
                player.setVegetarian(resultSet.getBoolean("vegetarian"));
                player.setOfYears(resultSet.getInt("of_years"));
                player.setFavouriteColor(resultSet.getString(7));
                players.add(player);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        ConnectionPool.getInstance().releaseConnection(connection);
        return players;
    }

    public List<String> getColumnNames(){
        List<String> columnNames = new ArrayList<>();
        String sqlQuery = "SELECT * FROM players";
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
                columnNames.add(columName);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return columnNames;
    }

    @Override
    public Player get(Long id) {
        return null;
    }

    @Override
    public Player update(Player entity) {
        System.out.println("Ovdje kući implementirajte update statement");
        System.out.println("Promjen se desila nad");
        System.out.println(entity);
        return null;
    }

    @Override
    public boolean delete(Player entity) {
        return false;
    }
}
