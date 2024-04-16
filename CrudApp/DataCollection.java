import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataCollection {
    //we make sure we have a txt file  called data.txt for the File Path.
    private static final String FILE_PATH = "data.txt";

    public List<UserData> getAllData() {
        List<UserData> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                UserData data = new UserData(parts[0], parts[1]);
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }


    public void addData(UserData data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(data.getId() + "," + data.getValue() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String id) {
        List<UserData> dataList = getAllData();
        dataList.removeIf(data -> data.getId().equals(id));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (UserData data : dataList) {
                writer.write(data.getId() + "," + data.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
