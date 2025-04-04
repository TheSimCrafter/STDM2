import java.sql.*;

public class ProduktDAO {

    public static List<Produkt> getAllProdukte() {
        List<Produkt> produkte = new ArrayList<>();
        String sql = "SELECT * FROM produkt";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produkt produkt = new Produkt();
                produkt.setId(rs.getInt("id"));
                produkt.setName(rs.getString("name"));
                produkt.setVerkaufspreis(rs.getDouble("verkaufspreis"));
                produkte.add(produkt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkte;
    }
}
