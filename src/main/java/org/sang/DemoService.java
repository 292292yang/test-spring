package org.sang;

/**
 * Created by sang on 2017/1/5.
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);

    void updatePerson(String name,Long id);

    void updatePerson2(String name,Long id);
}
