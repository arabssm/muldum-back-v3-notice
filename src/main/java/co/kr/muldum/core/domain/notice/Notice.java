package co.kr.muldum.core.domain.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
    private Long fileId;
    private boolean isAlerted;
}
