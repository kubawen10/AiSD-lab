package lab1;

public class Lista1Zadanie1 {
    public static void main(String[] args) {
        System.out.println("Piramida dla n=1, h=3:\n");
        drawPyramid(1,3);

        System.out.println("\nPiramida dla n=3, h=4:\n");
        drawPyramid(3,4);

        System.out.println("\nPiramida dla n=0, h=0:\n");
        drawPyramid(0,0);

        System.out.println("\nPiramida dla n=5, h=0:\n");
        drawPyramid(5,0);

        System.out.println("\nPiramida dla n=0, h=5:\n");
        drawPyramid(0,5);

        drawAFigure(4);
        drawAFigure(0);

    }

    public static void drawAFigure(int n){
        for (int i = 0; i < n; i++) {
            drawPyramid(i, n-i);
        }
    }

    public static void drawPyramid(int n, int h) {
        int numOfSpaces = h - 1;
        int numOfX = 2 * n + 1;

        for (int i = 0; i < h; i++) {
            //wypisanie spacji
            for (int j = 0; j < numOfSpaces; j++) {
                System.out.print(" ");
            }
            numOfSpaces--;

            //wypisanie X
            for (int j = 0; j < numOfX; j++) {
                System.out.print("X");
            }
            numOfX+=2;

            System.out.println();
        }
    }
}
