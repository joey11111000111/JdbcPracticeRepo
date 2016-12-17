package hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto;

public class ParticipantDTO {

    private int id;
    private String name;
    private String email;

    public ParticipantDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ParticipantDTO{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }

}
