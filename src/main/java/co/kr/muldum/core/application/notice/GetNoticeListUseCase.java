package co.kr.muldum.core.application.notice;

import co.kr.muldum.core.domain.notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetNoticeListUseCase {
    Page<Notice> findList(Pageable pageable);
}
