package com.pluralsight;

import org.junit.Test;

import javax.naming.Name;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class NameFormatTest {

    @Test
    public void format() {

       String actualFirstAndLast = "Kevin Gagante";
       String expectedFirstAndLast = NameFormat.format("Kevin", "Gagante");
       assertEquals(actualFirstAndLast,expectedFirstAndLast);

    }
}