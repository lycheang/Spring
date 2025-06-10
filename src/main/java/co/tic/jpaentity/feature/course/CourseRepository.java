package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>
{

    Course findByUuid(String uuid);
}
