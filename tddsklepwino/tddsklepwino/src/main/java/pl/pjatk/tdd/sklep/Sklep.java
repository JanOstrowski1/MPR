package pl.pjatk.tdd.sklep;

public class Sklep {
    public static void dokonajZakupu(KartaKlienta karta, double kwotaZakupu) {
        //TODO: dodaj algorytm na liczenie ilości kuponów jakie należą się za zakup

        if(kwotaZakupu>=40&&kwotaZakupu<80){
            karta.dodajKupony(1);
        }if(kwotaZakupu>=80&&kwotaZakupu<120){
            karta.dodajKupony(2);
        }if(kwotaZakupu>=120){
            karta.dodajKupony(3);
        }
    }

    public static KartaKlienta wydajNowaKarte(){
        return new KartaKlienta();
    }
}
