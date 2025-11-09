package co.kr.muldum.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "notice")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    private Long teamId;

    @Column(nullable = false, length = 20)
    private String title;

    @Lob
    private String content;

    @ElementCollection
    @CollectionTable(name = "notice_file", joinColumns = @JoinColumn(name = "notice_id"))
    @Column(name = "file_url")
    private List<String> fileUrls;

    private LocalDate deadlineDate;
}
