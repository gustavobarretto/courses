package model;

public class Dentist {

    private Integer id;
    private String registration;
    private String name;
    private String lastname;

    public Dentist(Integer id, String registration, String name, String lastname) {
        this.id = id;
        this.registration = registration;
        this.name = name;
        this.lastname = lastname;
    }

    public Dentist(String registration, String name, String lastname) {
        this.registration = registration;
        this.name = name;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "registration='" + registration + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
