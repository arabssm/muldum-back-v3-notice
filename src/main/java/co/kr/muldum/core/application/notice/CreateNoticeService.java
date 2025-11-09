package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;
import co.kr.muldum.core.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNoticeService implements CreateNoticeUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public Notice create(CreateNoticeCommand command) {
        Notice notice = Notice.builder()
                .userId(command.userId())
                .teamId(command.teamId())
                .title(command.title())
                .content(command.content())
                .fileUrls(command.fileUrls())
                .deadlineDate(command.deadlineDate())
                .build();

        return noticeRepositoryPort.save(notice);
    }
}
