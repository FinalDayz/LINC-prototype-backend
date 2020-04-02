package nl.lugus.development.backend.model;

public class User {

    private String profession;
    private String email;
    private String mobile;
    private boolean isPublic;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
