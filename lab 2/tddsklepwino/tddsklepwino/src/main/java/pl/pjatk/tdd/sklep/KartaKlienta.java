package pl.pjatk.tdd.sklep;

public class KartaKlienta {
    private int dostepneKupony;

    KartaKlienta(){
        this.dostepneKupony = 0;
    }

    void dodajKupony(int ilośćKuponów) {
        this.dostepneKupony += ilośćKuponów;
    }

    public int pobierzIloscDostepnychKuponow() {
        return dostepneKupony;
    }
}
