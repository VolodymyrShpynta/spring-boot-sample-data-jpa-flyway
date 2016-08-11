package com.sample;

import com.sample.entity.*;
import com.sample.repositories.EmployeeRepository;
import com.sample.repositories.LecturerRepository;
import com.sample.repositories.StudentRepository;
import org.junit.Ignore;
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

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


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

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LecturerRepository lecturerRepository;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(this.jdbcTemplate.queryForObject("SELECT COUNT(*) from EMPLOYEE", Integer.class), is(2));
    }

    @Test
    @Transactional
    public void testLazyLoadingEmployee() {
        List<Employee> employees = employeeRepository.findByFirstName("Ivan");
        assertThat(employees, is(notNullValue()));
        assertThat(employees.size(), is(1));
        assertThat(employees.get(0).getLastName(), is("Ivanov"));
        assertThat(employees.get(0).getAddress().getStreet(), is("Bozhenko"));
    }

    @Test
    @Transactional
    public void testLazyLoadingStudent() {
        List<Student> students = studentRepository.findByFirstName("Mike");
        assertThat(students, is(notNullValue()));
        assertThat(students.size(), is(1));
        assertThat(students.get(0).getLastName(), is("Ivanov"));
        assertThat(students.get(0).getLobHolder().getMetaData(), is("Mike metadata"));
    }

    @Test
    @Transactional
    public void testLazyLoadingLecturer() {
        List<Lecturer> lecturers = lecturerRepository.findByFirstName("Bill");
        assertThat(lecturers, is(notNullValue()));
        assertThat(lecturers.size(), is(1));
        assertThat(lecturers.get(0).getLastName(), is("Ivanov"));
        assertThat(lecturers.get(0).getLobHolder().getMetaData(), is("Bill metadata"));
    }

    @Test
    @Transactional
    public void testCreateEmployee() {
        Employee employee = Employee.builder()
                .firstName("Employee First Name 1")
                .lastName("Employee Last Name 1")
                .description("Employee description 1")
                .address(Address.builder()
                        .phone("222-22-22")
                        .street("Some street")
                        .build())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);
        assertTrue(savedEmployee.getId() > 0);
        assertTrue(savedEmployee.getAddress().getId() > 0);
    }

    @Ignore
    @Test
    @Transactional
    public void testCreateStudent() {
        Student student = Student.builder()
                .firstName("Student First Name 1")
                .lastName("Student Last Name 1")
                .lobHolder(StudentLobHolder.builder()
                        .metaData("Student 1 metadata")
                        .build())
                .build();

        Student savedStudent = studentRepository.save(student);
        System.out.println(savedStudent.getId());
    }

    @Ignore
    @Test
    @Transactional
    public void testCreateLecturer() {
        Lecturer lecturer = Lecturer.builder()
                .firstName("Lecturer First Name 1")
                .lastName("Lecturer Last Name 1")
                .lobHolder(LecturerLobHolder.builder()
                        .metaData("Lecturer 1 metadata")
                        .build())
                .build();

        Lecturer savedLecturer = lecturerRepository.save(lecturer);
        System.out.println(savedLecturer.getId());
    }

}
