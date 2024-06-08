package backend;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LoadGymLeaderBadges {
    private Connection connection;
    public Map<String, String> gymLeaderBadges = new HashMap<String, String>();

    public LoadGymLeaderBadges() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:GymLeaderBadges.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select * from badges");

            while(rs.next())
            {
                gymLeaderBadges.put(rs.getString("name"), rs.getString("badge"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoadGymLeaderBadges loadGymLeaderBadges = new LoadGymLeaderBadges();
        loadGymLeaderBadges.updateTable();
    }

    public void updateTable() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:GymLeaderBadges.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists badges");
            statement.executeUpdate("create table if not exists badges(name string, badge string)");

            statement.executeUpdate("insert into badges values('Brock', 'Boulder Badge')");
            statement.executeUpdate("insert into badges values('Misty', 'Cadcade Badge')");
            statement.executeUpdate("insert into badges values('Surge', 'Thunder Badge')");
            statement.executeUpdate("insert into badges values('Erika', 'Rainbow Badge')");
            statement.executeUpdate("insert into badges values('Koga', 'Soul Badge')");
            statement.executeUpdate("insert into badges values('Sabrina', 'Marsh Badge')");
            statement.executeUpdate("insert into badges values('Blaine', 'Volcano Badge')");
            statement.executeUpdate("insert into badges values('Giovani', 'Earth Badge')");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
