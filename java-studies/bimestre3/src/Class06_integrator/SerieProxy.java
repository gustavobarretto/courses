package Class06_integrator;

public class SerieProxy implements ISerie {

    private Serie SERIE;
    private int qntdViews;

    public SerieProxy(Serie SERIE) {
        this.qntdViews = 0;
        this.SERIE = SERIE;
    }

    @Override
    public String getSerie(String seriesName) throws SerieNaoHabilitadaException {

        if(this.qntdViews < 5) {
            this.qntdViews++;
            return "A série " + this.SERIE.getSerie(seriesName) + " está disponível para ser assistida. Divirtar-se!";
        } else {
            throw new SerieNaoHabilitadaException("Excede o número de reproduções permitidas!");
        }
    }
}
