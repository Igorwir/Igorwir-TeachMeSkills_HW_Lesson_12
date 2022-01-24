package com.teachmeskills.lesson_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/** НЕ ПОНЯЛ КАК СДЕЛАТЬ ЭТУ ПРОВЕРКУ!!!!
 * Учесть, что номера документов могут повторяться в пределах одного файла
 * и так же разные документы могут содержать одни и те же номера документов.
 */
public class CheckDokuments {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> dokuments = new ArrayList<>();
        while (true) {
            System.out.println("Enter way to file and name: ");                  // C:\\Users\\admin\\Desktop\\DocumentsNew.txt
            System.out.println("If you need finish input,push->'o'");             //C:\Users\admin\Desktop\DokMore.txt
            String inputWay = sc.nextLine();
            if (inputWay.equals("o")) {
                break;
            } else {
                dokuments.add(inputWay);
            }
            //System.out.println(dokuments);
        }
        Set<String> noDoble = new HashSet<>();
        for (String spisokWays : dokuments) {
            File file = new File(spisokWays);
            Scanner scan = new Scanner(file);
            String files = "";
            while (scan.hasNextLine()) {
                files = scan.next();
                noDoble.add(files);
            }
        }
        Map<String, Integer> rezoltStatus = new TreeMap<>();
        for (String listRez : noDoble) {
            if (listRez.length() == 15) {
                rezoltStatus.put("Valid " + listRez, 1);
            }
            if (listRez.length() < 15) {
                rezoltStatus.put("No Valid-short number " + listRez, 2);
            } else if (listRez.length() > 15) {
                rezoltStatus.put("No Valid-long number " + listRez, 3);
            }
        }
        //ЗАПИСАЛ БЕЗ ЦИКЛА,НЕ ПОНЯЛ КАК С ЦИКЛОМ ЭТО СДЕЛАТЬ!
        File file1 = new File("C:\\Users\\admin\\Desktop\\ResoltWork.txt");
        try {
            FileWriter writer = new FileWriter(file1, true);
            writer.write(rezoltStatus + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

