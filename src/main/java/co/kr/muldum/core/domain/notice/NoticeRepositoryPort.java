package co.kr.muldum.core.domain.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NoticeRepositoryPort {

    Notice save(Notice notice);

    Optional<Notice> findById(Long noticeId);

    Page<Notice> findAll(Pageable pageable);

    void deleteById(Long noticeId);
}
