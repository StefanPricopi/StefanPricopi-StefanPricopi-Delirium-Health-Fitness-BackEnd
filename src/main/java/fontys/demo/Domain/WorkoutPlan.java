package fontys.demo.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WorkoutPlan {
    private Long id;
    private String name;
    private String description;
    private int durationInDays;
    private List<Exercise> exercises;
}
