package co.tic.jpaentity.feature.teacher.dto;

import lombok.Builder;

@Builder
public record TeacherRequest(
        String name
) {
}
