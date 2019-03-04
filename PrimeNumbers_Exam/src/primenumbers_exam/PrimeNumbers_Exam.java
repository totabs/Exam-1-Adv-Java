/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers_exam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author tonip
 */
public class PrimeNumbers_Exam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter("Primedat.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(2);
        bw.close();
        fw.close();

        byte[] primeArray = new byte[(int) 10000];
        for (int i = 3; i < 10000000; i++) {
            File file = new File("Primedat.txt");

            byte[] primeNums = new byte[(int) file.length()];
            InputStream inStream = new FileInputStream(file);
            inStream.read(primeNums);
            inStream.close();

            if (file.length() > 10000) {
                int prime = 1;
                for (int j = 0; j < 10000; j++) {
                    primeArray[j] = primeNums[j];
                }
                for (int z = 0; z < 10000; z++) {
                    if (i % primeArray[z] == 0) {
                        prime = 0;
                        break;
                    }

                }
                if (prime == 1) {
                    for (int index = 10000; index < file.length(); index++) {
                        primeArray[index] = primeNums[index];
                    }
                    for (int jindex = 0; jindex < file.length(); jindex++) {
                        if (i % primeArray[jindex] == 0) {
                            prime = 0;
                            break;
                        }
                    }
                    if (prime == 1) {
                        fw = new FileWriter("Primedat.txt", true);
                        bw = new BufferedWriter(fw);
                        System.out.println("1" + i);
                        bw.write(i);
                        bw.close();
                        fw.close();
                    }
                }

            } else {
                int prime = 1;
                for (int k = 0; k < file.length(); k++) {
                    primeArray[k] = primeNums[k];
                }
                for (int k = 0; k < file.length(); k++) {
                    if (i % primeArray[k] == 0) {
                        prime = 0;
                        break;
                    }

                }
                if (prime == 1) {
                    fw = new FileWriter("Primedat.txt", true);
                    bw = new BufferedWriter(fw);
                    bw.write(i);
                    System.out.println(i);
                    bw.close();
                    fw.close();
                }
            }
        }
    }
}
