package com.etiqa.sylvester.EtiqaTest.rest.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
}
