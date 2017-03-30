package org.sang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sang on 2017/1/5.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("sang")) {
            throw new IllegalArgumentException("sang 已存在，数据将回滚");
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("sang")) {
            throw new IllegalArgumentException("sang已存在，但数据不会回滚");
        }
        return p;
    }


    @Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor = {RuntimeException.class})
    public void updatePerson(String name,Long id){
        System.out.println("9999999999999999");
        personRepository.updatePerson(name,id);
        System.out.println("00000000000000000000000");
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    public void updatePerson2(String name,Long id){
        System.out.println("------------------11111------------");
        updatePerson(name,id);
        System.out.println("--------------1结束----------");
        System.out.println("--------------2抛出异常----------");
        personRepository.updatePerson("y98",id);
        System.out.println("--------------------333333333333-----------");
        throw new RuntimeException("tttttt");
    }
}
