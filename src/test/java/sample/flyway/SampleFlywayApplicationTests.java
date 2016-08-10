package sample.flyway;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import sample.flyway.entity.Employee;
import sample.flyway.repositories.EmployeeRepository;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleFlywayApplication.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
public class SampleFlywayApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(this.jdbcTemplate.queryForObject("SELECT COUNT(*) from EMPLOYEE", Integer.class), is(2));
    }

    @Test
    @Transactional
    public void testLasyLoading() {
        List<Employee> employees = employeeRepository.findByFirstName("Ivan");
        MatcherAssert.assertThat(employees, is(notNullValue()));
        MatcherAssert.assertThat(employees.size(), is(1));
        MatcherAssert.assertThat(employees.get(0).getLastName(), is("Ivanov"));
        assertThat(employees.get(0).getAddress().getStreet(), is("Bozhenko"));
//        assertThat(employees.get(0).getMetaData(), is("Some metadata"));
    }

}
