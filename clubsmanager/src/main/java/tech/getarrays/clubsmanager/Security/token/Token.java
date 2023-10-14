package tech.getarrays.clubsmanager.Security.token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.getarrays.clubsmanager.model.Actors.Club;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    public TokenType tokenType = TokenType.BEARER;


    public boolean revoked;

    public boolean expired;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    public Club club;


}
