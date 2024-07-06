package Application;

public final class CV {
    private final String fullName;
    private final String email;
    private final int phoneNumber;
    private final String education;
    private final String experience;
    private final String skills;
    private final int age;

    public CV(String fullName, String email, int phoneNumber, String background, String experience, String skills, int age) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.education = background;
        this.experience = experience;
        this.skills = skills;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEducation() {
        return education;
    }

    public String getExperience() {
        return experience;
    }

    public String getSkills() {
        return skills;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "CV{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", skills='" + skills + '\'' +
                ", age=" + age +
                '}';
    }
}
