package com.example.sample;

import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class CalculationRequestTest {

    @Test
    public void 유효한_숫자를_파싱할_수_있다() {
        // given
        String[] parts = new String[]{"2", "+", "3"};

        // when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertThat(calculationRequest.getNum1()).isEqualTo(2);
        assertThat(calculationRequest.getOperator()).isEqualTo("+");
        assertThat(calculationRequest.getNum2()).isEqualTo(3);
    }

    @Test
    public void 세자리_숫자도_파싱할_수_있다() {
        // given
        String[] parts = new String[]{"212", "+", "312"};

        // when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertThat(calculationRequest.getNum1()).isEqualTo(212);
        assertThat(calculationRequest.getOperator()).isEqualTo("+");
        assertThat(calculationRequest.getNum2()).isEqualTo(312);
    }

    @Test
    public void 유효한_길이의_숫자가_들어오지_않으면_에러를_던진다() {
        // given
        String[] parts = new String[]{"212", "+"};

        // when
        // then
        assertThrows(BadRequestException.class, () -> {
            new CalculationRequest(parts);
        });
    }

    @Test
    public void 유효하지_않은_연산자가_들어오면_에러를_던진다() {
        // given
        String[] parts = new String[]{"2", "X", "1"};

        // when
        // then
        assertThrows(InvalidOperatorException.class, () -> {
            new CalculationRequest(parts);
        });
    }

}
