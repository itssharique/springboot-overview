package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.transaction.Transactional;

public interface StudentDAO {
    void save(Student theStudent) ;


    Student findById(Integer id) ;
}
