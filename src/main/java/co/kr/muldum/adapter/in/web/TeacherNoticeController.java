package co.kr.muldum.adapter.in.web;

import co.kr.muldum.adapter.in.web.common.ApiResponse;
import co.kr.muldum.adapter.in.web.security.UserPrincipal;
import co.kr.muldum.core.application.notice.CreateNoticeUseCase;
import co.kr.muldum.core.application.notice.DeleteNoticeUseCase;
import co.kr.muldum.core.application.notice.UpdateNoticeUseCase;
import co.kr.muldum.core.domain.notice.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tch/notice")
@RequiredArgsConstructor
@PreAuthorize("hasRole('TEACHER')")
public class TeacherNoticeController {

    private final CreateNoticeUseCase createNoticeUseCase;
    private final UpdateNoticeUseCase updateNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    @PostMapping
    public ApiResponse<Map<String, Object>> createNotice(@AuthenticationPrincipal UserPrincipal user, @RequestBody NoticeRequest noticeRequest) {
        List<String> fileUrls = noticeRequest.files() != null ?
                noticeRequest.files().stream().map(NoticeRequest.FileRequest::url).toList() :
                null;

        Notice notice = createNoticeUseCase.create(
                new CreateNoticeUseCase.CreateNoticeCommand(
                        user.getId(),
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

    @PatchMapping("/{noticeId}")
    public ApiResponse<Notice> updateNotice(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable Long noticeId,
            @RequestBody UpdateNoticeUseCase.UpdateNoticeCommand command
    ) {
        Notice updatedNotice = updateNoticeUseCase.update(user.getId(), noticeId, command);
        return ApiResponse.ok(updatedNotice);
    }

    @DeleteMapping("/{noticeId}")
    public ApiResponse<Void> deleteNotice(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long noticeId) {
        deleteNoticeUseCase.delete(user.getId(), noticeId);
        return ApiResponse.of(HttpStatus.NO_CONTENT, "공지사항이 성공적으로 삭제되었습니다.", null);
    }
}
