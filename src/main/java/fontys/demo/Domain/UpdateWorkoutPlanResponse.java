package fontys.demo.Domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateWorkoutPlanResponse {
    private List<WorkoutPlan> workoutPlans;
}
