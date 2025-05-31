package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;

public interface UpdateNoticeUseCase {
    Notice update(Long noticeId, UpdateNoticeCommand command);

    record UpdateNoticeCommand(
            String title,
            String content,
            Long fileId,
            boolean isAlerted
    ) {
    }
}
