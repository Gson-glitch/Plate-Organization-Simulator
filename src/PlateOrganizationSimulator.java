import java.util.*;

public class PlateOrganizationSimulator {
    private Stack<Plate> cupBoard;
    private List<String> typesOfPlates;

    public PlateOrganizationSimulator() {
        cupBoard = new Stack<>();
        typesOfPlates = new ArrayList<>();
    }

    public void initializeCupBoard(List<Plate> plates) {
        cupBoard.addAll(plates);
        System.out.println("Initial State of the Cup Board: ");
        System.out.println(display());
    }

    public boolean correctOrder() {
        Stack<Plate> cupBoardCopy = (Stack<Plate>) cupBoard.clone();
        List<String> hashSet = new ArrayList<>();

        for (Plate P: cupBoardCopy) {
            if (hashSet.contains(P.plateType)) {
                continue;
            }
            hashSet.add(P.plateType);
        }

        //System.out.println(hashSet.toString() + " " + Arrays.toString(Type.plateType.values()));
        return Objects.equals(hashSet.toString(), Arrays.toString(Type.plateType.values()));
    }

    public void arrange() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (correctOrder()) {
            System.out.println("The plates are already in the correct order.");
            return;
        }

        System.out.println("Arranging the Cup Board...");

        while (!cupBoard.isEmpty()) {
            Plate P = cupBoard.pop();
            System.out.println("Moving " + P.plateType + " out of the Cup Board.");
            hashMap.putIfAbsent(P.plateType, 0);
            hashMap.merge(P.plateType, 1, Integer::sum);
        }

//        System.out.println(hashMap.keySet());
//        System.out.println(Arrays.toString(Type.plateType.values()));

        int countOfTypesOfPlates = Type.plateType.values().length;
        Type.plateType[] arrayOfPlateTypes = Type.plateType.values();

        for (int i=countOfTypesOfPlates-1; i>=0; i--) {
            int count = hashMap.get(arrayOfPlateTypes[i].toString());
            while (count>=1) {
                System.out.println("Moving " + arrayOfPlateTypes[i] + " into the Cup Board.");
                cupBoard.push(new Plate(arrayOfPlateTypes[i]));
                count--;
            }
        }
        System.out.println("State of the Cup Board after arranging:");
        System.out.println(display());
    }

    public String display() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        String delimiter = "";
        for (Plate P: cupBoard) {
            //System.out.println(P);
            builder.append(delimiter);
            delimiter = ", ";
            builder.append(P.plateType);
        }
        builder.append("]");
        return builder.toString();
    }
}
