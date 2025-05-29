package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.Notice;

import java.util.Optional;

public interface GetNoticeUseCase {
    Optional<Notice> findById(Long noticeId);
}
