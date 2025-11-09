package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;

import java.time.LocalDate;
import java.util.List;

public interface UpdateNoticeUseCase {
    Notice update(Long noticeId, UpdateNoticeCommand command);

    record UpdateNoticeCommand(
            String title,
            String content,
            List<String> fileUrls,
            LocalDate deadlineDate
    ) {
    }
}
