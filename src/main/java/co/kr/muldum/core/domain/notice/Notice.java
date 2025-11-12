package co.kr.muldum.core.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

    private Long id;
    private UUID userId;
    private Long teamId;
    private String title;
    private String content;
    private List<String> fileUrls;
    private LocalDate deadlineDate;
}
