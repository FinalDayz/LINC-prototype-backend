package nl.lugus.development.backend.model;

public class User {

    private String name;
    private String profession;
    private String email;
    private String mobile;
    private boolean isPublic;

    public User(String name, String profession, String email, String mobile, boolean isPublic) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.mobile = mobile;
        this.isPublic = isPublic;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
