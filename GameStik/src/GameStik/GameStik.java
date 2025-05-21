
package GameStik;

import java.util.Random;
import java.util.Scanner;

public class GameStik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random  random  = new Random();

        System.out.print("Masukkan maksimum jumlah stik: ");
        int maxSticks = scanner.nextInt();

        int totalSticks = random.nextInt(maxSticks) + 1;   // ≥1
        System.out.println("Jumlah stik yang dimainkan: " 
        + totalSticks);

        boolean playerTurn = true;
        // Pemain jalan lebih dulu

        while (totalSticks > 0) {
            System.out.println("\nSisa stik: " 
            + totalSticks);
            int sticksTaken;

            if (playerTurn) {// ----- GILIRAN PEMAIN -----
                System.out.print("Ambil 1 sampai 3 stik: ");
                sticksTaken = scanner.nextInt();
                while (sticksTaken < 1 || sticksTaken > 3 
                || sticksTaken > totalSticks) {
                    System.out.print("Input tidak valid. Ambil 1 sampai 3 stik: ");
                    sticksTaken = scanner.nextInt();
                }
            } else {// ----- GILIRAN KOMPUTER -----
                if (totalSticks > 4) {               
                    // fase normal
                    int remainder = totalSticks % 4; 
                    // inginkan sisa 1 (mod 4)
                    sticksTaken = (remainder == 0) ? 3 : remainder - 1;
                    if (sticksTaken == 0) sticksTaken = 1; 
                    // cadangan (tak terjadi)
                } else {                              
                    // sisa 2-4 stik → sisakan 1
                    sticksTaken = totalSticks - 1;
                }
                System.out.println("Komputer mengambil " 
                + sticksTaken + " stik.");
            }

            totalSticks -= sticksTaken;
            playerTurn = !playerTurn;
        }

        // Loop berakhir ketika stok menjadi 0 → yang baru saja berjalan kalah
        if (playerTurn) {
            System.out.println("\nKamu menang! Komputer mengambil stik terakhir.");
        } else {
            System.out.println("\nKomputer menang! Kamu mengambil stik terakhir.");
        }

        scanner.close();
    }
}
