package org.sang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sang on 2017/1/5.
 */
@RestController
public class MyController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/norollback")
    public Person noRollback(Person person) {
        return demoService.savePersonWithoutRollBack(person);
    }

    @RequestMapping("/rollback")
    public Person rollback(Person person) {
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/requireNew")
    public String testRequireNew(String name,Long id){
        demoService.updatePerson2(name,id);
        return "OK!!!";
    }
}
