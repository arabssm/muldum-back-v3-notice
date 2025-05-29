package co.kr.muldum.presentation.web;

import co.kr.muldum.global.common.ApiResponse;
import co.kr.muldum.application.notice.GetNoticeListUseCase;
import co.kr.muldum.application.notice.GetNoticeUseCase;
import co.kr.muldum.domain.notice.Notice;
import co.kr.muldum.global.exception.BusinessException;
import co.kr.muldum.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final GetNoticeUseCase getNoticeUseCase;
    private final GetNoticeListUseCase getNoticeListUseCase;

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
}
