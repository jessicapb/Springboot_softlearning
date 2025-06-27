package com.example.softlearning.applicationcore.entity.courses.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning.applicationcore.entity.book.dtos.BooksDTO;
import com.example.softlearning.applicationcore.entity.courses.dtos.CoursesDTO;

public interface CoursesRepository {
    public Optional<CoursesDTO> findByCode(int code);

    public List<CoursesDTO> findByDepartment(String department);

    public List<CoursesDTO> findByPartialDepartment(String department);

    public Integer countByPartialDepartment(String department);

    public CoursesDTO save(CoursesDTO courses);

    public void deleteByCode(int id);
}
