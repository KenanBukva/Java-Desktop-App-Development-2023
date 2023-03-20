package six.gui.dao;

public class Sport {

    private Long id_sport;
    private String sport_name;
    private String desciption;

    public Sport() {
    }

    public Sport(Long id_sport, String sport_name, String desciption) {
        this.id_sport = id_sport;
        this.sport_name = sport_name;
        this.desciption = desciption;
    }

    public Long getId_sport() {
        return id_sport;
    }

    public void setId_sport(Long id_sport) {
        this.id_sport = id_sport;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id_sport=" + id_sport +
                ", sport_name='" + sport_name + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }

}
