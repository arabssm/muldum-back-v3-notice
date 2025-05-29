package co.kr.muldum.presentation.web;

import java.time.LocalDate;
import java.util.List;

public record NoticeRequest(
    String title,
    String content,
    List<FileRequest> files,
    LocalDate deadlineDate
) {
    public record FileRequest(String url) {}
}
