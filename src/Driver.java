import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Cereal> cerealDataset = retrieveCereal();
        CerealDataProcessor cerealDataProcessor = new CerealDataProcessor(cerealDataset);
        System.out.println(cerealDataProcessor.getMedianValue(Constants.CEREAL_PROPERTIES.RATING));
    }

    /***
     * Pulls the cereal data from the csv file and loads it into a set of Cereal objects
     * @return a set containing cereal objects
     */
    public static List<Cereal> retrieveCereal() {
        List<Cereal> cereals = new ArrayList<>();
        String cerealFile = "cereal.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(cerealFile));
            while ((line = br.readLine()) != null) {
                String[] cerealLine = line.split(csvSplitBy);
                Cereal c = new Cereal(cerealLine[Constants.CEREAL_INDEX],
                                      Float.parseFloat(cerealLine[Constants.RATING_INDEX]));
                cereals.add(c);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return cereals;
    }
}
