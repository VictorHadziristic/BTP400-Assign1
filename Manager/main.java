import Assign1.Job;
import Assign1.Part;
import Assign1.Station;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String args[]){
        ArrayList<Job> jobQueue;
        ArrayList<Station> stationQueue;

        //Read in inventory file here

        Map<Part, Integer> partRegistry = new HashMap<>();
        partRegistry = readPartsFromCSV("inventory.csv");



    }

    private static Map<Part, Integer> readPartsFromCSV(String fileName) {
        Map<Part, Integer> parts = new HashMap<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            String[] partNames = line.split(",");
            line = br.readLine();
            String[] partStrQuan = line.split(",");
            ArrayList<Integer> partQuantities = new ArrayList<>();

            for(int i = 0; i < partStrQuan.length; i++){
                partQuantities.add(Integer.parseInt(partStrQuan[i]));
            }

            for(int i = 0; i < partQuantities.size(); i++){
                parts.put(new Part(i, partNames[i]), partQuantities.get(i));
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return parts;
    }

    private static ArrayList<Job> readJobFromCSV(String fileName) {
        ArrayList<Job> jobs = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            String[] taskNames = line.split(",");
            int numberOfTasks = taskNames.length;

            line = br.readLine();
            String[] taskType = line.split(",");

            ArrayList<String[]> jobOptions = new ArrayList<>();
            line = br.readLine();
            while(line != null){
                jobOptions.add(line.split(","));
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return jobs;
    }
}
