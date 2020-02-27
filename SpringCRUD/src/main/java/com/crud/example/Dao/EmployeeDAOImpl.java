package com.crud.example.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.crud.example.Model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
	 public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	    {
	        this.jdbcTemplate = jdbcTemplate;
	    }


	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 String sql = "insert into Employee values(?,?,?,?)";

	        jdbcTemplate.update(sql, new Object[]
	        { employee.getId(), employee.getAge(), employee.getDept(), employee.getName() });


	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from Employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setAge(rs.getInt(2));
                employee.setDept(rs.getString(3));
                employee.setName(rs.getString(4));
                return employee;
            }
        });
        return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		  String sql = "update Employee set age =?, dept=?,name=? where id=?";
	        jdbcTemplate.update(sql, new Object[]
	        { employee.getAge(), employee.getDept(), employee.getName(), employee.getId() });
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from Employee where id=?";
        jdbcTemplate.update(sql, new Object[]
        { id });
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		 String sql = "select * from Employee";

	        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
	        {
	            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
	            {
	                List<Employee> list = new ArrayList<Employee>();
	                while (rs.next())
	                {
	                    Employee employee = new Employee();
	                    employee.setId(rs.getInt(1));
	                    employee.setAge(rs.getInt(2));
	                    employee.setDept(rs.getString(3));
	                    employee.setName(rs.getString(4));
	                    list.add(employee);
	                }
	                return list;
	            }

	        });
	        return employeeList;
	}

}
