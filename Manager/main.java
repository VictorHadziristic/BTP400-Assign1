import Assign1.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class main {
    static Map<Part, Integer> inventory = new HashMap<>();

    List<Job> jobQueue = Collections.synchronizedList(new ArrayList<>());
    List<Station> stationQueue = Collections.synchronizedList(new ArrayList<>());

    Runnable jobResolver = ()-> {
        ObjectOutputStream objectOutputStream;
        while (true){
            for (int i = 0; i < jobQueue.size(); i++){
                for(int j = 0; j < stationQueue.size(); j++){
                    if(jobQueue.get(i).getCurrentTask().equals(stationQueue.get(j).getTask())){
                        try {
                            objectOutputStream = new ObjectOutputStream(stationQueue.get(j).getSocket().getOutputStream());
                            objectOutputStream.writeObject(jobQueue.get(i));
                            stationQueue.remove(j);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    };
    public static void main(String args[]){
        inventory = readPartsFromCSV("inventory.csv");

        ArrayList<Part> partRegistry = new ArrayList<>(inventory.keySet());

        ArrayList<Station> assemblyLine = createAssemblyLine(partRegistry);

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
    // TO DO: REVAMP Job ID
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

    private static ArrayList<Station> createAssemblyLine(ArrayList<Part> partRegistry){

        Map<Part, Integer> chassisPartList = new HashMap();
        chassisPartList.put(partRegistry.get(4), 20);
        chassisPartList.put(partRegistry.get(0), 4);
        chassisPartList.put(partRegistry.get(1), 4);
        Map<Part, Integer> drivetrainPartList = new HashMap();
        drivetrainPartList.put(partRegistry.get(1), 7);
        drivetrainPartList.put(partRegistry.get(9), 1);
        drivetrainPartList.put(partRegistry.get(10), 2);
        Map<Part, Integer> bodyPartList = new HashMap();
        bodyPartList.put(partRegistry.get(2), 2);
        bodyPartList.put(partRegistry.get(3), 4);
        bodyPartList.put(partRegistry.get(4), 10);
        Map<Part, Integer> wheelPartList = new HashMap();
        wheelPartList.put(partRegistry.get(6), 4);
        wheelPartList.put(partRegistry.get(5), 4);
        wheelPartList.put(partRegistry.get(1), 24);
        Map<Part, Integer> collisionSensorPartList = new HashMap();
        collisionSensorPartList.put(partRegistry.get(9), 1);
        collisionSensorPartList.put(partRegistry.get(10), 1);
        Map<Part, Integer> paintPartList = new HashMap();
        paintPartList.put(partRegistry.get(7), 2);
        Map<Part, Integer> leatherSeatPartList = new HashMap();
        leatherSeatPartList.put(partRegistry.get(8), 4);
        leatherSeatPartList.put(partRegistry.get(2), 2);
        Map<Part, Integer> sportPartList = new HashMap();
        sportPartList.put(partRegistry.get(7), 4);
        sportPartList.put(partRegistry.get(0), 1);
        sportPartList.put(partRegistry.get(4), 7);
        Map<Part, Integer> VINPartList = new HashMap();
        VINPartList.put(partRegistry.get(10), 2);

        Task chassis = new initialTask(5000, chassisPartList, "Installing Chassis");
        Task drivetrain = new intermediateTask(true, 7000, drivetrainPartList, "Installing Drivetrain");
        Task body = new intermediateTask(true, 2500, bodyPartList, "Installing Body");
        Task wheels = new intermediateTask(true, 5000, wheelPartList, "Installing wheels and brakes");
        Task collision = new intermediateTask(false, 2000, collisionSensorPartList, "Installing Collision Sensors (Optional)");
        Task paint = new intermediateTask(true, 5000, paintPartList, "Painting car");
        Task leatherSeat = new intermediateTask(false, 6000, leatherSeatPartList, "Installing Leather seats");
        Task sportPackage = new intermediateTask(false, 10000, sportPartList, "Installing Sport Package");
        Task VIN = new finalTask(5000, VINPartList, "Engraving VIN");

        ArrayList<Station> allStations = new ArrayList<>();

        Station chassisStation = new Station(1, chassis);
        Station drivetrainStation = new Station(2, drivetrain);
        Station bodyStation = new Station(3,body);
        Station wheelStation1 = new Station(4,wheels);
        Station wheelStation2 = new Station(5,wheels);
        Station collisionStation = new Station(6,collision);
        Station paintStation = new Station(7, paint);
        Station leatherSeatStation = new Station(8, leatherSeat);
        Station sportPackageStation = new Station(9, sportPackage);
        Station VINStation = new Station(10,VIN);

        allStations.add(chassisStation);
        allStations.add(drivetrainStation);
        allStations.add(bodyStation);
        allStations.add(wheelStation1);
        allStations.add(wheelStation2);
        allStations.add(collisionStation);
        allStations.add(paintStation);
        allStations.add(leatherSeatStation);
        allStations.add(sportPackageStation);
        allStations.add(VINStation);

        return allStations;
    }

    public static Map<Part, Integer> getInventory() {
        return inventory;
    }

    public static void setInventory(Map<Part, Integer> inventory) {
        main.inventory = inventory;
    }
}
