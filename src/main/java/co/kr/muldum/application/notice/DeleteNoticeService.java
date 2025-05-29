package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.kr.muldum.domain.notice.Notice;
import co.kr.muldum.global.exception.BusinessException;
import co.kr.muldum.global.exception.ErrorCode;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteNoticeService implements DeleteNoticeUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public void delete(Long userId, Long noticeId) {
        Notice notice = noticeRepositoryPort.findById(noticeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOTICE_NOT_FOUND));

        if (!notice.getUserId().equals(userId)) {
            throw new BusinessException(ErrorCode.NOTICE_FORBIDDEN);
        }

        noticeRepositoryPort.deleteById(noticeId);
    }
}
