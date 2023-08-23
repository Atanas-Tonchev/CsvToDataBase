package Tools;

import java.sql.*;

public class ConnectionDataBase {

    private static Connection connection = null;
    private static final String url = "jdbc:mysql://localhost:3306/csv_cars_db";
    private static final String username = "root";
    private static final String password = "nasko";
    int dimensionId = 0;
    int fuelId = 0;
    int identificationId = 0;
    int engineId = 0;
    int engineStaticId = 0;



    public void connectionDataBase() throws SQLException {

        connection = DriverManager.getConnection(url,username,password);
        if(connection != null){
            System.out.println("Successfully connected.");
        }else{
            System.out.println("Failed to connect.");
        }
    }

    public void insertDataBaseDimensions (int Height,int Length,int Width) throws SQLException {

        String sqlDimensions = "INSERT INTO csv_cars_db.dimensions (height,length,width) VALUES( ?,?,? )";
        PreparedStatement statement = connection.prepareStatement(sqlDimensions,
                PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, Height);
        statement.setInt(2, Length);
        statement.setInt(3, Width);
        statement.executeUpdate();
        ResultSet resultDimensions = statement.getGeneratedKeys();

        if (resultDimensions.next()) {
            dimensionId = resultDimensions.getInt(1);
            System.out.println("Table 'Dimensions' is created with ID: " + dimensionId);
        } else {
            System.out.println("No data inserted.");
        }
        statement.close();
    }

    public void insertDataBaseFuel (String FuelType,int CityMpg,int HighwayMpg) throws SQLException {

        String sqlFuel = "INSERT INTO csv_cars_db.fuel_information (fuel_type,city_mpg,highway_mpg) VALUES( ?,?,? )";
        PreparedStatement statement = connection.prepareStatement(sqlFuel, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, FuelType);
        statement.setInt(2, CityMpg);
        statement.setInt(3, HighwayMpg);
        statement.executeUpdate();
        ResultSet resultFuel = statement.getGeneratedKeys();

        if (resultFuel.next()) {
            System.out.println("Table 'Fuel Information' is created with ID: " + resultFuel.getInt(1));
            fuelId = resultFuel.getInt(1);
        } else {
            System.out.println("No data inserted.");
        }
        statement.close();
    }


    public void insertDataBaseEngineInfo (String DriveLine,String EngineType,
                                          String Hybrid,String Transmission,
                                          int NumberOfForwardGears) throws SQLException {

        String sqlEngineInfo = "INSERT INTO csv_cars_db.engine_information (drive_line,engine_type,hybrid," +
                "transmission,number_of_forward_gears,engine_statistics_engine_statistics_id)" +
                " VALUES( ?,?,?,?,?,? )";

        PreparedStatement statement = connection.prepareStatement(sqlEngineInfo,
                PreparedStatement.RETURN_GENERATED_KEYS);

        statement.setString(1,DriveLine);
        statement.setString(2,EngineType);
        statement.setString(3,Hybrid);
        statement.setString(4,Transmission);
        statement.setInt(5,NumberOfForwardGears);
        statement.setInt(6,engineStaticId);
        statement.executeUpdate();
        ResultSet resultEngineInfo = statement.getGeneratedKeys();

        if (resultEngineInfo.next()) {
            System.out.println("Table 'Engine Information' is created with ID: "
                    +resultEngineInfo.getInt(1));
            engineId = resultEngineInfo.getInt(1);
        } else {
            System.out.println("No data inserted.");
        }
        statement.close();
    }

    public void insertDataBaseEngineStatic (int Horsepower,int Torque) throws SQLException {

        String sqlStatic = "INSERT INTO csv_cars_db.engine_statistics (horsepower,torque) VALUES( ?,? )";
        PreparedStatement statement = connection.prepareStatement(sqlStatic, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, Horsepower);
        statement.setInt(2, Torque);
        statement.executeUpdate();
        ResultSet resultStatic = statement.getGeneratedKeys();

        if (resultStatic.next()) {
            System.out.println("Table 'Engine Static' is created with ID: " + resultStatic.getInt(1));
            engineStaticId = resultStatic.getInt(1);
        } else {
            System.out.println("No data inserted.");
        }
        statement.close();
    }

    public void insertDataBaseIdentification (String Classification,String ID,
                                              String Make,String ModelYear,int Year) throws SQLException {

        String sqlIdentification = "INSERT INTO csv_cars_db.identification (classification,id,make,model_year,year)" +
                " VALUES( ?,?,?,?,? )";

        PreparedStatement statement = connection.prepareStatement(sqlIdentification,
                PreparedStatement.RETURN_GENERATED_KEYS);

        statement.setString(1,Classification);
        statement.setString(2,ID);
        statement.setString(3,Make);
        statement.setString(4,ModelYear);
        statement.setInt(5, Year);
        statement.executeUpdate();

        ResultSet resultIdentification = statement.getGeneratedKeys();

        if (resultIdentification.next()) {
            System.out.println("Table 'Identification' is created with ID: "
                    + resultIdentification.getInt(1));
            identificationId = resultIdentification.getInt(1);

        } else {
            System.out.println("No data inserted.");
        }

        statement.close();
    }
}
