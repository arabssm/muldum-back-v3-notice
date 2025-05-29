package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.Notice;

import java.time.LocalDate;
import java.util.List;

public interface UpdateNoticeUseCase {
    Notice update(Long userId, Long noticeId, UpdateNoticeCommand command);

    record UpdateNoticeCommand(
            String title,
            String content,
            List<String> fileUrls,
            LocalDate deadlineDate
    ) {
    }
}
