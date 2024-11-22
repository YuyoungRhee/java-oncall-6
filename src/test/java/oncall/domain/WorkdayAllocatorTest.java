package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkdayAllocatorTest {
    
    @DisplayName("연속 2일 근무하게 될 시 다음 근무자와 순번을 바꿔 편성한다.")
    @Test
    void allocate_not_2days() {
        // given
        Workers weekdayWorkers = new Workers(List.of("준팍","도밥","고니","수아","글로","솔로스타"));
        Workers weekendWorkers = new Workers(List.of("수아","루루","글로","솔로스타","우코","슬링키"));
        WorkdayAllocator workdayAllocator = new WorkdayAllocator(weekdayWorkers, weekendWorkers);

        // when
        String worker1 = workdayAllocator.allocate(false, "");
        String worker2 = workdayAllocator.allocate(false, worker1);
        String worker3 = workdayAllocator.allocate(false, worker2);
        String worker4 = workdayAllocator.allocate(false, worker3);
        String worker5 = workdayAllocator.allocate(true, worker4);
        String worker6 = workdayAllocator.allocate(true, worker5);
        // then
        Assertions.assertThat(worker5).isEqualTo("루루");
        Assertions.assertThat(worker6).isEqualTo("수아");

    }

}