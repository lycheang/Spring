package co.tic.jpaentity.feature.teacher;

import co.tic.jpaentity.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByUuid(String uuid);
    Optional<Teacher> findByName(String name);
}
