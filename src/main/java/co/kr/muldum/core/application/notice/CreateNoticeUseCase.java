package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;

public interface CreateNoticeUseCase {
    Notice create(CreateNoticeCommand command);

    record CreateNoticeCommand(
            Long userId,
            Long teamId,
            String title,
            String content,
            Long fileId,
            boolean isAlerted
    ) {
    }
}
