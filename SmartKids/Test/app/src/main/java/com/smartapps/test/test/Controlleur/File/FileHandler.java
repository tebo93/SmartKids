package com.smartapps.test.test.Controlleur.File;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esteban Puello on 7/08/2017.
 */

public class FileHandler {
    public static List<String> readFile(Context c, String fileName) {
        List<String> fileLines = new ArrayList<>();
        try {
            InputStream inputStream = c.openFileInput(fileName);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString;
                while ((receiveString = bufferedReader.readLine()) != null) {
                    fileLines.add(receiveString);
                }
                inputStream.close();
            }
        } catch (Exception e) {
            //Get erreur
        }
        return fileLines;
    }
    public static boolean storeFile(Context c, String fileName, List<String> lines) {
        FileOutputStream fos;
        try {
            fos = c.openFileOutput(fileName, Context.MODE_PRIVATE);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
