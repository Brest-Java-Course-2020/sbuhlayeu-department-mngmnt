package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
public class DepartmentJdbcDaoImplTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void getDepartments() {

        List<Department> departments = departmentDao.getDepartments();
        assertNotNull(departments);
    }

    @Test
    public void getDepartmentById() {

        Department departmentFirstRow = departmentDao.getDepartmentById(1);
        assertEquals("firstDepartment", departmentFirstRow.getDepartmentName());

        Department departmentSecondRow = departmentDao.getDepartmentById(2);
        assertEquals("secondDepartment", departmentSecondRow.getDepartmentName());


    }

    @Test
    public void addDepartment() {
    }

    @Test
    public void updateDepartment() {
    }

    @Test
    public void deleteDepartment() {
    }

}