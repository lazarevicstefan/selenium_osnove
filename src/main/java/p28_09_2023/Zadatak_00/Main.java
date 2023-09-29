package p28_09_2023.Zadatak_00;

public class Main {
    public static void main(String[] args) throws ITBootcampException {
        FakeDriver fakeDriver = new FakeDriver();

        try {
            fakeDriver.checkInt(-10);
        }catch (ITBootcampException e){
            throw e;
        }
    }
}
