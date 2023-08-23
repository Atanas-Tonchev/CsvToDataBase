package Tools;
import model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class ReadCsvFile {
    private static final String path = "C:\\Users\\User\\IdeaProjects\\CsvToDataBase\\src\\main\\java\\cars.csv";
    private static int lineNumber = 0;

    public void readCsvFile() throws IOException, SQLException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine(); //skip first line

        String line;
        while ((line = br.readLine()) != null) {
            if (lineNumber == 0) {
                lineNumber++;
                continue;
            }

            String lineNoQuotes = line.replaceAll("\"", "");
            String[] csvFile = lineNoQuotes.split(",");
            HashMap<Integer,Car> carHashMap = new HashMap<>();
            Car car = new Car();
            car.setDimensions(new Dimensions(Integer.parseInt(csvFile[0]),Integer.parseInt(csvFile[1]),
                    Integer.parseInt(csvFile[2])));

            car.setEngineInformation(new EngineInformation(csvFile[3], csvFile[4], csvFile[5],
                    csvFile[7], Integer.parseInt(csvFile[6]),
                    new EngineStatistics(Integer.parseInt(csvFile[16]),
                            Integer.parseInt(csvFile[17]))));

            car.setIdentification(new Identification(csvFile[11], csvFile[12], csvFile[13],
                    csvFile[14], Integer.parseInt(csvFile[15])));

            car.setFuelInformation(new FuelInformation(csvFile[9], Integer.parseInt(csvFile[8]),
                    Integer.parseInt(csvFile[10])));

            carHashMap.put(lineNumber,car);

            ConnectionDataBase insert = new ConnectionDataBase();

            insert.insertDataBaseDimensions(car.getDimensions().getHeight(),
                    car.getDimensions().getLength(),
                   car.getDimensions().getWidth());

             insert.insertDataBaseFuel(car.getFuelInformation().getFuelType(),car.getFuelInformation().getCityMpg(),
                    car.getFuelInformation().getHighwayMpg());

            insert.insertDataBaseEngineStatic(car.getEngineInformation().getEngineStatistics().getHorsepower(),
                   car.getEngineInformation().getEngineStatistics().getTorque());

            insert.insertDataBaseIdentification(car.getIdentification().getClassification(),
                    car.getIdentification().getID(),car.getIdentification().getMake(),
                    car.getIdentification().getModelYear(),car.getIdentification().getYear());

            insert.insertDataBaseEngineInfo(car.getEngineInformation().getDriveLine(),
                    car.getEngineInformation().getEngineType(),car.getEngineInformation().getHybrid(),
                    car.getEngineInformation().getTransmission(),car.getEngineInformation().getNumberOfForwardGears());

            lineNumber++;
        }
    }
}

