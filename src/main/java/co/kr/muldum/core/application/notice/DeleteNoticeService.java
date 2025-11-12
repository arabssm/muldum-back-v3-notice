package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.kr.muldum.core.domain.notice.Notice;
import co.kr.muldum.infrastructure.exception.BusinessException;
import co.kr.muldum.infrastructure.exception.ErrorCode;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteNoticeService implements DeleteNoticeUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public void delete(UUID userId, Long noticeId) {
        Notice notice = noticeRepositoryPort.findById(noticeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOTICE_NOT_FOUND));

        if (!notice.getUserId().equals(userId)) {
            throw new BusinessException(ErrorCode.NOTICE_FORBIDDEN);
        }

        noticeRepositoryPort.deleteById(noticeId);
    }
}
