package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UpdateNoticeUseCase {
    Notice update(UUID userId, Long noticeId, UpdateNoticeCommand command);

    record UpdateNoticeCommand(
            String title,
            String content,
            List<String> fileUrls,
            LocalDate deadlineDate
    ) {
    }
}
