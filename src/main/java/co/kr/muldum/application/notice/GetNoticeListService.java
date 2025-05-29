package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.Notice;
import co.kr.muldum.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetNoticeListService implements GetNoticeListUseCase {

    private final NoticeRepositoryPort noticeRepositoryPort;

    @Override
    public Page<Notice> findList(Pageable pageable) {
        return noticeRepositoryPort.findAll(pageable);
    }
}
