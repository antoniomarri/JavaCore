package Lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static ArrayList<FIleObject> fIleObjectArrayList = new ArrayList<>();
    public static final String title = "value1"+ ";" + "value2"
            + ";" + "value3" + ";"+ System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        createFileObjects();
        writer();
        readToObject();
    }

    public static void createFileObjects(){

        // fIleObjectArrayList.add(new FIleObject(123,456,234));

        Random random = new Random();

        for(int i=1;i<10;i++){
            fIleObjectArrayList.add( new FIleObject(random.nextInt(100),
                    random.nextInt(100), random.nextInt(100)));
        }
    }

    public static void writer() throws IOException {
        try (FileWriter writer = new FileWriter("New_Test_HW5.csv");){
            writer.write(title);
            for(FIleObject fIleObject : fIleObjectArrayList) {
                writer.write(fIleObject.getValue() + ";" + fIleObject.getValueFrom()
                        + ";" + fIleObject.getValueFrom() + ";"+ System.getProperty("line.separator"));
            }
        }
    }

    public static AppData readToObject() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("New_Test_HW5.csv"))) {
            String line = br.readLine();
            appData.setHeader( line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        };

        int[][] resultData = new int[records.size()][3];

        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }
        appData.setData(resultData);
        return appData;

    }
}
