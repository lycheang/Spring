package co.tic.jpaentity.feature.course.dto;

import lombok.Builder;

@Builder
public record CourseRespond(
        String uuid,
        String name,
        String description,
        String teacherName
) {
}
