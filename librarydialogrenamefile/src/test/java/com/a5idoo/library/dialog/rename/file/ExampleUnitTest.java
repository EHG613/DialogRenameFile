package com.a5idoo.library.dialog.rename.file;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        String s="123.txt";
        System.out.println(s.substring(s.lastIndexOf(".")));
        s="123";
        if(s.lastIndexOf(".")<0){
            System.out.println("");
        }else {
            System.out.println(s.substring(s.lastIndexOf(".")));
        }
    }
}