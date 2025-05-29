package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.Notice;
import co.kr.muldum.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetNoticeService implements GetNoticeUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public Optional<Notice> findById(Long noticeId) {
        return noticeRepositoryPort.findById(noticeId);
    }
}
