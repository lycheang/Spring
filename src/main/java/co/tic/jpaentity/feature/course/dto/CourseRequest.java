package co.tic.jpaentity.feature.course.dto;

import lombok.Builder;

@Builder
public record CourseRequest(
        String name,
        String description,
        String teacherName
) {
}
