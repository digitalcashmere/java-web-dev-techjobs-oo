package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job;
    @Before
    public void createJobObject() {
        test_job = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();

        assertEquals(0,0,.001);

        assertFalse(emptyJob1.equals(emptyJob2));

        assertTrue((emptyJob2.getId() - 1) == emptyJob1.getId());
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);

        assertTrue(testJob.getName() == "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getEmployer().getValue() == "ACME");

        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getLocation().getValue() == "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getPositionType().getValue() == "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char lett[] = testJob.toString().toCharArray();
        assertEquals('\n', lett[lett.length-1]);
        assertEquals('\n', lett[0]);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String answer = "\nID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer() + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + job.getPositionType() + "\n" +
                "Core Competency: " + job.getCoreCompetency() + "\n";
        assertEquals(job.toString(), answer);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String answer = "\nID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer() + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + job.getPositionType() + "\n" +
                "Core Competency: "+ job.getCoreCompetency() + "\n";
        assertEquals(job.toString(), answer);
    }
}
