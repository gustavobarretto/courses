package Class06_integrator;

public class Serie implements ISerie {

    @Override
    public String getSerie(String seriesName) {
        return "www." + seriesName + "/guguflix";
    }

}
