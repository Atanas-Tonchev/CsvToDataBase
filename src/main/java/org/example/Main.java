package org.example;
import Tools.ConnectionDataBase;
import Tools.ReadCsvFile;
import java.io.IOException;
import java.sql.SQLException;


public class Main {


    public static void main(String[] args) throws SQLException, IOException {





       // System.out.println(car.getDimensions().getHeight());

        //Connection to the Data Base
       ConnectionDataBase connection = new ConnectionDataBase();
       connection.connectionDataBase();




        //Read CSV file
        ReadCsvFile readCsvFile = new ReadCsvFile();
        readCsvFile.readCsvFile();

        //System.out.println(c.getDimensions().getHeight());


        //Insert into Data Base


        //Select from Data Base

    }

}