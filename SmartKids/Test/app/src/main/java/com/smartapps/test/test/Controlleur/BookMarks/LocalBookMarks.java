package com.smartapps.test.test.Controlleur.BookMarks;


import android.content.Context;
import com.smartapps.test.test.Controlleur.File.FileHandler;
import com.smartapps.test.test.Model.BookMark;

import java.util.List;

/**
 * Created by Esteban Puello on 7/08/2017.
 */

public class LocalBookMarks {
    public void addBookMark(Context c, String element){
        List<String> als = FileHandler.readFile(c, BookMark.FILENAME);
        als.add(element);
        FileHandler.storeFile(c, BookMark.FILENAME, als);
    }

    public void removeBookMark(Context c, String element){
        List<String> als = FileHandler.readFile(c, BookMark.FILENAME);
        for (String s :
                als) {
            if (s.contentEquals(element)) {
                als.remove(s);
                break;
            }
        }
    }
}
