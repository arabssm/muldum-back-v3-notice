package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.Notice;

import java.time.LocalDate;
import java.util.List;

public interface CreateNoticeUseCase {
    Notice create(CreateNoticeCommand command);

    record CreateNoticeCommand(
            Long userId,
            Long teamId,
            String title,
            String content,
            List<String> fileUrls,
            LocalDate deadlineDate
    ) {
    }
}
