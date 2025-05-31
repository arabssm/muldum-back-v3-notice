package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteNoticeService implements DeleteNoticeUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public void delete(Long noticeId) {
        noticeRepositoryPort.deleteById(noticeId);
    }
}
