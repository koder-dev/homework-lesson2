package Application;

import Application.Exceptions.DBUploadFailException;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class ApplicationService {
    private DBimitation db = DBimitation.getInstance(new File("db.json"));

    public ApplicationService() {}

    public CV createCV(String fullName, String email, String age, String phoneNumber, String education, String workExperience, String skills) {
        int intAge = Integer.parseInt(age);
        int intNumber = Integer.parseInt(phoneNumber);
        return new CV(fullName, email, intNumber, education, workExperience, skills, intAge);
    }

    public boolean saveCvToDatabase(CV cv) {
        boolean result = db.addCv(cv);
        try {
            db.synchronizeToFile();
        } catch (DBUploadFailException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int getTotalCountCVs() {
        return db.getDb().size();
    }

    public int getAverageAge() {
        List<CV> listDb = db.getDb();
        Optional<Integer> ageSum =  listDb.stream().map(CV::getAge).reduce(Integer::sum);
        return ageSum.map(integer -> integer / listDb.size()).orElse(0);
    }

}
