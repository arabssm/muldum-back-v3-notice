package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;

import java.util.Optional;

public interface GetNoticeUseCase {
    Optional<Notice> findById(Long noticeId);
}
