package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.LotsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeopleManagerTest {
    protected PeopleManager peopleManager = new PeopleManager();
    
    @BeforeEach
    void setUp() throws LotsException {
        String[] names = {"Markus", "Adam", "Andrew"};
        for (int i = 0; i < 3; i++) {
            Person person = new Person(names[i]);
            peopleManager.addPerson(person);
        }
    }

    @Test
    public void testcountPeopleInList() {
        assertEquals(3, peopleManager.countPeopleInList());
    }

    @Test
    public void testgetPerson() {
        assertEquals("Adam", peopleManager.getPerson(1));
    }

    @Test
    public void testgetSize() {
        assertEquals(3, peopleManager.getSize());
    }

    @Test
    public void isEmpty_Test() {
        assertEquals(false, peopleManager.isEmpty());
    }

    @Test
    public void deletePerson_InvalidPersonIndex_expectException() {
        assertThrows(LotsException.class, () -> {
            peopleManager.deletePerson(5);
        });
    }

}