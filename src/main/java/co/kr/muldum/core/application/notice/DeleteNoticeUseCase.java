package co.kr.muldum.core.application.notice;

public interface DeleteNoticeUseCase {
    void delete(Long userId, Long noticeId);
}
