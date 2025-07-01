package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.domain.Course;
import co.tic.jpaentity.feature.course.dto.CourseRequest;
import co.tic.jpaentity.feature.course.dto.CourseRespond;
import co.tic.jpaentity.feature.teacher.dto.TeacherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<List<CourseRespond>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.CreateCourse(courseRequest);
        return ResponseEntity.ok("Course created");
    }
    @PatchMapping("/{uuid}")
    public ResponseEntity<String> updateCourse(@PathVariable String uuid, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourse(uuid, courseRequest);
        return ResponseEntity.ok("Course updated");
    }
    @GetMapping("/pagination")
    public ResponseEntity<Map<String, Object>> getAllCourses(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursePage = courseRepository.findAll(pageable);

        List<CourseRespond> courseResponds = coursePage.getContent().stream()
                .map(course -> new CourseRespond(course.getUuid(), course.getName(), course.getDescription(),course.getName()))
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("courses", courseResponds);
        response.put("currentPage", coursePage.getNumber());
        response.put("totalItems", coursePage.getTotalElements());
        response.put("totalPages", coursePage.getTotalPages());

        return ResponseEntity.ok(response);
    }

}
