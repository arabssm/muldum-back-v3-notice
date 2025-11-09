package co.kr.muldum.adapter.in.web;

import co.kr.muldum.adapter.in.web.common.ApiResponse;
import co.kr.muldum.core.application.notice.*;
import co.kr.muldum.core.domain.notice.Notice;
import co.kr.muldum.infrastructure.exception.BusinessException;
import co.kr.muldum.infrastructure.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final CreateNoticeUseCase createNoticeUseCase;
    private final GetNoticeUseCase getNoticeUseCase;
    private final GetNoticeListUseCase getNoticeListUseCase;
    private final UpdateNoticeUseCase updateNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    @PostMapping("/tch")
    public ApiResponse<Map<String, Object>> createNotice(@RequestHeader("X-User-Id") Long userId, @RequestBody NoticeRequest noticeRequest) {
        List<String> fileUrls = noticeRequest.files() != null ?
                noticeRequest.files().stream().map(NoticeRequest.FileRequest::url).toList() :
                null;

        Notice notice = createNoticeUseCase.create(
                new CreateNoticeUseCase.CreateNoticeCommand(
                        userId,
                        null,
                        noticeRequest.title(),
                        noticeRequest.content(),
                        fileUrls,
                        noticeRequest.deadlineDate()
                )
        );
        Map<String, Object> response = Map.of(
                "id", notice.getId()
        );
        return ApiResponse.of(HttpStatus.CREATED, "공지사항이 성공적으로 등록되었습니다.", response);
    }

    @GetMapping("/{noticeId}")
    public ApiResponse<Notice> getNotice(@PathVariable Long noticeId) {
        return ApiResponse.ok(getNoticeUseCase.findById(noticeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOTICE_NOT_FOUND)));
    }

    @GetMapping
    public ApiResponse<Page<Notice>> getNoticeList(Pageable pageable) {
        Page<Notice> notices = getNoticeListUseCase.findList(pageable);
        return ApiResponse.ok(notices);
    }

    @PatchMapping("/{noticeId}")
    public ApiResponse<Notice> updateNotice(@PathVariable Long noticeId, @RequestBody UpdateNoticeUseCase.UpdateNoticeCommand command) {
        Notice updatedNotice = updateNoticeUseCase.update(noticeId, command);
        return ApiResponse.ok(updatedNotice);
    }

    @DeleteMapping("/{noticeId}")
    public ApiResponse<Void> deleteNotice(@PathVariable Long noticeId) {
        deleteNoticeUseCase.delete(noticeId);
        return ApiResponse.of(HttpStatus.NO_CONTENT, "공지사항이 성공적으로 삭제되었습니다.", null);
    }
}
