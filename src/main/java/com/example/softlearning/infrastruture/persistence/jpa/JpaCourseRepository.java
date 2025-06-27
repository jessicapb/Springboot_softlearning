package com.example.softlearning.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning.applicationcore.entity.courses.dtos.CoursesDTO;
import com.example.softlearning.applicationcore.entity.courses.persistence.CoursesRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaCourseRepository extends JpaRepository<CoursesDTO, Integer>, CoursesRepository{
    public Optional<CoursesDTO> findByCode(int code);

    public List<CoursesDTO> findByDepartment(String department);

    @Query(value = "SELECT c FROM CoursesDTO c WHERE c.department LIKE %:department%")
    public List<CoursesDTO> findByPartialDepartment(String department);

    @Query(value = "SELECT count(*) FROM CoursesDTO c WHERE c.department LIKE %:department%")
    public Integer countByPartialDepartment(String department);

    @Transactional
    public CoursesDTO save (CoursesDTO courses);

    @Transactional
    public void deleteByCode(int code);
}
