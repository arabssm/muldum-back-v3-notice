package co.kr.muldum.adapter.in.web;

import co.kr.muldum.core.application.notice.*;
import co.kr.muldum.core.domain.notice.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final CreateNoticeUseCase createNoticeUseCase;
    private final GetNoticeUseCase getNoticeUseCase;
    private final GetNoticeListUseCase getNoticeListUseCase;
    private final UpdateNoticeUseCase updateNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    @PostMapping
    public ResponseEntity<Notice> createNotice(@RequestBody CreateNoticeUseCase.CreateNoticeCommand command) {
        Notice notice = createNoticeUseCase.create(command);
        return ResponseEntity.ok(notice);
    }

    @GetMapping("/{noticeId}")
    public ResponseEntity<Notice> getNotice(@PathVariable Long noticeId) {
        return getNoticeUseCase.findById(noticeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<Notice>> getNoticeList(Pageable pageable) {
        Page<Notice> notices = getNoticeListUseCase.findList(pageable);
        return ResponseEntity.ok(notices);
    }

    @PatchMapping("/{noticeId}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long noticeId, @RequestBody UpdateNoticeUseCase.UpdateNoticeCommand command) {
        Notice updatedNotice = updateNoticeUseCase.update(noticeId, command);
        return ResponseEntity.ok(updatedNotice);
    }

    @DeleteMapping("/{noticeId}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeId) {
        deleteNoticeUseCase.delete(noticeId);
        return ResponseEntity.noContent().build();
    }
}
