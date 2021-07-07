package com.nology.nologer;

public interface ICourseRepository {
    public interface ICourseRepository extends JpaRepository<Course, String> {

    }
}

