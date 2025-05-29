package co.kr.muldum.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

    private Long id;
    private Long userId;
    private Long teamId;
    private String title;
    private String content;
    private List<String> fileUrls;
    private LocalDate deadlineDate;
}
