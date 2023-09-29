package p28_09_2023.Zadatak_00;

public class FakeDriver {
    public int checkInt (int n) throws ITBootcampException {
        if (n < 0){
            throw new ITBootcampException("Broj je ispod nule!");
        }
        return n++;
    }
}
