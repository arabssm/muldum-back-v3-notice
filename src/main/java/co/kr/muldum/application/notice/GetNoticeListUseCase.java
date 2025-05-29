package co.kr.muldum.application.notice;

import co.kr.muldum.domain.notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetNoticeListUseCase {
    Page<Notice> findList(Pageable pageable);
}
