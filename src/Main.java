import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Plate> plates = new ArrayList<>();

//        plates.add(new Plate("Plate1"));
//        plates.add(new Plate("Plate2"));
//        plates.add(new Plate("Plate4"));
//        plates.add(new Plate("Plate1"));
//        plates.add(new Plate("Plate3"));
        plates.add(new Plate(Type.plateType.PLATE1));
        plates.add(new Plate(Type.plateType.PLATE2));
        plates.add(new Plate(Type.plateType.PLATE4));
        plates.add(new Plate(Type.plateType.PLATE1));
        plates.add(new Plate(Type.plateType.PLATE3));
//        plates.add(new Plate("Plate1"));

        PlateOrganizationSimulator T = new PlateOrganizationSimulator();
        T.initializeCupBoard(plates);
        //System.out.println(T.display());
        T.arrange();
        //System.out.println(T.display());
    }
}
