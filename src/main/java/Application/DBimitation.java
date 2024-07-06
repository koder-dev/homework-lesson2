package Application;

import Application.Exceptions.DBLoadFailException;
import Application.Exceptions.DBUploadFailException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBimitation {
    private List<CV> db;
    private File saveFile;

    private DBimitation(File saveFile) {
        this.saveFile = saveFile;
        this.db = new ArrayList<>();
    }

    private DBimitation(File saveFile, List<CV> db) {
        this.saveFile = saveFile;
        this.db = db;
    }

    private DBimitation() {};

    public static DBimitation getInstance(File file) {
        DBimitation db = new DBimitation(file);
        try {
            db.synchronizeFromFile();
        } catch (DBLoadFailException e) {
            System.out.println(e.getMessage());
        }
        return db;
    }

    public boolean addCv(CV cv) {
        return db.add(cv);
    }

    public boolean removeCvByName(String fullName) {
        return db.removeIf(cv -> cv.getFullName().equals(fullName));
    }

    public List<CV> getDb() {
        return List.copyOf(db);
    }

    public void synchronizeToFile() throws DBUploadFailException {  //method uploads db to file
        try(FileWriter fw = new FileWriter(saveFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(db);
            fw.write(json);
        } catch (IOException e) {
            throw new DBUploadFailException("Uploading database to file failed!\nReason: " + e);
        }
    }

    public void synchronizeFromFile() throws DBLoadFailException {
        try(FileReader fr = new FileReader(saveFile);
        BufferedReader br = new BufferedReader(fr)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = br.lines().reduce("", (acc, str) -> acc + str);
            CV[] dbArray = gson.fromJson(json, CV[].class);
            db = new ArrayList<>(Arrays.asList(dbArray));
        } catch (IOException e) {
            throw new DBLoadFailException("Loading database from file failed!\nReason: " + e);
        }
    }

    @Override
    public String toString() {
        return "DBimitation{" +
                "db=" + db +
                '}';
    }
}
