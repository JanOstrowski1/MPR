package pl.pjatk.tdd.sklep;

public class Sklep {
    public static void dokonajZakupu(KartaKlienta karta, double kwotaZakupu) {
        //TODO: dodaj algorytm na liczenie ilości kuponów jakie należą się za zakup
        if (kwotaZakupu==40.00){
            karta.dodajKupony(1);
        }
    }

    public static KartaKlienta wydajNowaKarte(){
        return new KartaKlienta();
    }
}
