package co.kr.muldum.core.application.notice;

import java.util.UUID;

public interface DeleteNoticeUseCase {
    void delete(UUID userId, Long noticeId);
}
