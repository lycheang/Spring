package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{

    Course findByUuid(String uuid);
    Course findByName(String name);

    Page<Course> findAll( Pageable pageable);
}
