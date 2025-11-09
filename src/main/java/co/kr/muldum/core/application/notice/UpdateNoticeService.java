package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;
import co.kr.muldum.core.domain.notice.NoticeRepositoryPort;
import co.kr.muldum.infrastructure.exception.BusinessException;
import co.kr.muldum.infrastructure.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateNoticeService implements UpdateNoticeUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public Notice update(Long noticeId, UpdateNoticeCommand command) {
        Notice notice = noticeRepositoryPort.findById(noticeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOTICE_NOT_FOUND));

        // The domain object would have methods to update its state.
        // For now, we'll create a new object, but a real implementation
        // should have a more sophisticated way to handle updates.
        Notice updatedNotice = Notice.builder()
                .id(notice.getId())
                .userId(notice.getUserId())
                .teamId(notice.getTeamId())
                .title(command.title())
                .content(command.content())
                .fileUrls(command.fileUrls())
                .deadlineDate(command.deadlineDate())
                .build();

        return noticeRepositoryPort.save(updatedNotice);
    }
}
