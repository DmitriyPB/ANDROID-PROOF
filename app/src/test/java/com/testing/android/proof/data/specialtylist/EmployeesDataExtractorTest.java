package com.testing.android.proof.data.specialtylist;

import com.testing.android.proof.data.database.entity.EmployeeEntity;
import com.testing.android.proof.data.specialtylist.employeeservice.Response;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Collections.emptyList;

public final class EmployeesDataExtractorTest {

    @Test
    public void testConvertResponseToEmployeeEntityBirthDayFormat1() {
        Date expectedDate = new GregorianCalendar(1987, Calendar.MARCH, 23).getTime();
        String birthday = "1987-03-23";
        EmployeesDataExtractor extractor = new EmployeesDataExtractor();

        EmployeeEntity result = extractor.convertResponseToEmployeeEntity(new Response("Петр", "петроВ", birthday, null, emptyList()));
        Assert.assertEquals(expectedDate, result.getBirthday());
    }

    @Test
    public void testConvertResponseToEmployeeEntityBirthDayFormat2() {
        String birthday = "23-07-2000";
        Date expected = new GregorianCalendar(2000, Calendar.JULY, 23).getTime();
        EmployeesDataExtractor extractor = new EmployeesDataExtractor();

        EmployeeEntity result = extractor.convertResponseToEmployeeEntity(new Response("Петр", "петроВ", birthday, null, emptyList()));
        Assert.assertEquals(expected, result.getBirthday());
    }

    @Test
    public void testConvertResponseToEmployeeEntityBirthDayNull() {
        EmployeesDataExtractor extractor = new EmployeesDataExtractor();

        EmployeeEntity result = extractor.convertResponseToEmployeeEntity(new Response("Петр", "петроВ", null, null, emptyList()));
        Assert.assertNull(result.getBirthday());
    }

    @Test
    public void testCapitalizingNames() {
        EmployeesDataExtractor extractor = new EmployeesDataExtractor();

        EmployeeEntity result = extractor.convertResponseToEmployeeEntity(new Response("петр", "петроВ", null, null, emptyList()));
        Assert.assertEquals("Петр", result.getFirstName());
        Assert.assertEquals("ПетроВ", result.getLastName());
    }
}