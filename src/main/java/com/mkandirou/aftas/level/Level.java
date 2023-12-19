package com.mkandirou.aftas.level;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Level {
    @Id
    @NonNull private Integer code;
    @NonNull private String description;
    @NonNull private Integer points;

}
