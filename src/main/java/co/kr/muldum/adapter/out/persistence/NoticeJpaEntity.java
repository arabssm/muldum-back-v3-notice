package co.kr.muldum.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "notices")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "UUID")
    private UUID userId;

    private Long teamId;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    // This should probably be a separate table in a real application
    // For now, we'll just store it as a string for simplicity as per the domain model.
    private String fileUrls;

    private LocalDate deadlineDate;
}
