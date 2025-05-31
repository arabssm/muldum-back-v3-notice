package co.kr.muldum.adapter.out.persistence;

import co.kr.muldum.core.domain.notice.Notice;
import co.kr.muldum.core.domain.notice.NoticeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NoticePersistenceAdapter implements NoticeRepositoryPort {

    private final NoticeJpaRepository noticeJpaRepository;

    @Override
    public Notice save(Notice notice) {
        NoticeJpaEntity entity = toEntity(notice);
        NoticeJpaEntity savedEntity = noticeJpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Notice> findById(Long noticeId) {
        return noticeJpaRepository.findById(noticeId).map(this::toDomain);
    }

    @Override
    public Page<Notice> findAll(Pageable pageable) {
        return noticeJpaRepository.findAll(pageable).map(this::toDomain);
    }

    @Override
    public void deleteById(Long noticeId) {
        noticeJpaRepository.deleteById(noticeId);
    }

    private NoticeJpaEntity toEntity(Notice notice) {
        return NoticeJpaEntity.builder()
                .id(notice.getId())
                .userId(notice.getUserId())
                .teamId(notice.getTeamId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .fileId(notice.getFileId())
                .isAlerted(notice.isAlerted())
                .build();
    }

    private Notice toDomain(NoticeJpaEntity entity) {
        return Notice.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .teamId(entity.getTeamId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .fileId(entity.getFileId())
                .isAlerted(entity.isAlerted())
                .build();
    }
}
