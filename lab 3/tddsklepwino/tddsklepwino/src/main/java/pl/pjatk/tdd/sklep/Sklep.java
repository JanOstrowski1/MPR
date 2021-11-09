package pl.pjatk.tdd.sklep;

public class Sklep {
    public static void dokonajZakupu(KartaKlienta karta, double kwotaZakupu) {
        //TODO: dodaj algorytm na liczenie ilości kuponów jakie należą się za zakup
        //Przypadki brzegowe 84,21 -> 1x
        // 84,22->2x
        //133,33->2x
        //133,34->3x

        if(kwotaZakupu>=40&&kwotaZakupu<84.22){
            karta.dodajKupony(1);
        }if(kwotaZakupu>=84.22&&kwotaZakupu<133.34){
            karta.dodajKupony(2);
        }if(kwotaZakupu>=133.34){
            karta.dodajKupony(3);
        }
    }

    public static KartaKlienta wydajNowaKarte(){
        return new KartaKlienta();
    }
}
