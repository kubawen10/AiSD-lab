package lab1;

public class Modyfikacja1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("\nPrzypadek dla n: " + i);
            drawJoinedTriangles(i);
        }
    }

    public static void drawBase(int n) {
        for (int i = 0; i < 2 * n + 1; i++) {
            System.out.print("X");
        }
        System.out.println();
    }

    public static void drawLeftSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public static void drawSingle(int spacesLeft, int spacesBetween) {
        drawLeftSpaces(spacesLeft);
        System.out.print("X");
        for (int i = 0; i < spacesBetween; i++) {
            System.out.print(" ");
        }
        System.out.print("X");
        drawLeftSpaces(spacesLeft - 1);
    }

    public static void drawConnection(int n, int spacesLeft) {
        drawLeftSpaces(spacesLeft);
        if (n % 2 == 0) {
            System.out.print("X");
            drawLeftSpaces(spacesLeft - 1);
            drawLeftSpaces(spacesLeft);
            System.out.print("X");

        } else {
            System.out.print("XX");
            drawLeftSpaces(spacesLeft - 1);

            drawLeftSpaces(spacesLeft);
            System.out.println("XX");
            drawLeftSpaces(spacesLeft);
            System.out.print("XX");
            drawLeftSpaces(spacesLeft - 1);
            drawLeftSpaces(spacesLeft);
            System.out.print("XX");
        }
        System.out.println();
    }

    public static void drawJoinedTriangles(int n) {
        //n<=1
        if (n == 1) {
            drawBase(1);
            drawBase(1);
            return;
        } else if (n < 1) {
            return;
        }

        drawBase(n);
        int spacesBetween = n - 3;
        int spacesLeft = 1;

        //top part
        while (spacesBetween > 0) {
            //left
            drawSingle(spacesLeft, spacesBetween);
            //right
            drawSingle(spacesLeft, spacesBetween);

            spacesBetween -= 2;
            spacesLeft += 1;
            System.out.println();
        }

        drawConnection(n, spacesLeft);

        //bottom part
        while (spacesBetween < n - 3) {
            spacesLeft -= 1;
            spacesBetween += 2;
            //left
            drawSingle(spacesLeft, spacesBetween);
            //right
            drawSingle(spacesLeft, spacesBetween);
            System.out.println();
        }

        drawBase(n);
    }
}
