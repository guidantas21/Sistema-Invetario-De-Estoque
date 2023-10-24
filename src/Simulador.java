import java.util.Random;

public class Simulador {
    Simulador() {
    }

    public int[][] generetorAdijacenseMatriz() {
        int[][] matrizAdjacencia = {
                { 0, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 1, 1, 0, 0 },
                { 1, 0, 1, 0, 0 }
        };

        Random gen = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizAdjacencia[i][j] = matrizAdjacencia[i][j] * gen.nextInt(10);
            }
        }

        return matrizAdjacencia;
    }

    public int[][] ids = {
            { 45891234, 76540982, 12387645, 89054321, 67543210 },
            { 23456789, 87651234, 98704523, 54321876, 65783210 },
            { 31429087, 98762310, 89017645, 45673210, 87654092 },
            { 12349876, 54321678, 87650912, 65789012, 98126754 },
            { 45678901, 67894523, 54321987, 89012675, 23456789 },
            { 12345678, 56781234, 90871234, 43219876, 76541290 },
            { 56782310, 89012345, 54329876, 34561278, 65431290 },
            { 78906543, 10987654, 87654321, 98761234, 76543210 }

    };

    public int generetorId() {
        Random gen = new Random();
        int positonSectorOfId = gen.nextInt(8);
        int positonOfProduct = gen.nextInt(5);

        return ids[positonSectorOfId][positonOfProduct];
    }

    public void locationDrone() {

        int rfps = 0;
        int x = 0;
        int y = 0;
        int nextPallet = 0;
        while (true) {
            if (nextPallet > 6) {
                break;
            }

            while (true) {
                if (rfps > 99) {
                    rfps = 0;
                    break;
                }
                System.out.println(generetorId());
                rfps++;
            }

            x++;
            if (x > 2) {
                x = 0;
            }

            if (y > 2) {
                y = 0;
                nextPallet++;

            } else {

                y++;
            }

            System.out.println("(" + x + ", " + y + ", " + nextPallet + ")");

        }
    }
}
