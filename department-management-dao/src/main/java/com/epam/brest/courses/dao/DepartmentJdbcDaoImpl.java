package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentJdbcDaoImpl implements DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentJdbcDaoImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DepartmentJdbcDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Department> getDepartments() {
        LOGGER.trace("Get all departments {}", 0);
        List<Department> departments = namedParameterJdbcTemplate
                .query("SELECT d.department_id, d.department_name FROM department d ORDER BY d.department_name", new DepartmentRowMapper());
        return departments;
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("department_id", departmentId);
        Department department =  namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM department WHERE department_id = :department_id",sqlParameterSource,  new DepartmentRowMapper());
        return department;
    }

    @Override
    public Department addDepartment(Department department) {
        return null;
    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteDepartment(Integer departmentId) {

    }

    private class DepartmentRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));
            department.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
            return department;
        }
    }
}
