package oncall.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalenderTest {

    @DisplayName("시작일이 수요일일 때 4일이 주말이므로 휴일임을 확인한다.")
    @Test
    void isHoliday_start_WEDNESDAY() {
        // given
        Calender calender = new Calender(Month.May, Week.WEDNESDAY);

        // when & then
        assertThat(calender.isHoliday(1,4)).isTrue();
    }

    @DisplayName("공휴일일 때 휴일임을 확인한다.")
    @Test
    void isHoliday_LegalHoliday() {
        // given
        Calender calender = new Calender(Month.May, Week.WEDNESDAY);

        // when & then
        assertThat(calender.isHoliday(1,1)).isTrue();
    }

}