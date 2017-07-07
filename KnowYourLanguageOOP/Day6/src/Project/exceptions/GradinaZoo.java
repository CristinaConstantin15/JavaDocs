package Project.exceptions;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public final class GradinaZoo {
    private final String denumireGradinaZoo;
    private final Date dataDeschideriiGradinii;
    private final AnimalZooRar animalzoorar;
    private final IngrijitorAnimale angajatulLunii;

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschideriiGradinii, AnimalZooRar animalzoorar, IngrijitorAnimale angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschideriiGradinii = dataDeschideriiGradinii;
        this.animalzoorar = animalzoorar;
        this.angajatulLunii = angajatulLunii;
    }

    public String getDenumireGradinaZoo() {
        return denumireGradinaZoo;
    }

    public void setDenumireGradinaZoo(String denumireGradinaZoo) {
        this.denumireGradinaZoo = denumireGradinaZoo;
    }

    public Date getDataDeschideriiGradinii() {
        return dataDeschideriiGradinii;
    }

    public void setDataDeschideriiGradinii(Date dataDeschideriiGradinii) {
        this.dataDeschideriiGradinii = dataDeschideriiGradinii;
    }

    public AnimalZooRar getAnimalzoorar() {
        return animalzoorar;
    }

    public void setAnimalzoorar(AnimalZooRar animalzoorar) {
        this.animalzoorar = animalzoorar;
    }

    public IngrijitorAnimale getAngajatulLunii() {
        return angajatulLunii;
    }

    public void setAngajatulLunii(IngrijitorAnimale angajatulLunii) {
        this.angajatulLunii = angajatulLunii;
    }
}
