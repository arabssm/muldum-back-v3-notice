package co.kr.muldum.core.domain.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeFile {

    private Long id;
    private String fileUrl;
    private String fileName;
    private String fileType;
    private String fileExtension;
    private Long userId;
    private LocalDateTime updatedAt;
}
