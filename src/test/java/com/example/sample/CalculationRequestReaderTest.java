package com.example.sample;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationRequestReaderTest {

    @Test
    public void System_in으로_데이터를_읽어들일_수_있다() {
        // given
        CalculationRequestReader calculationRequestReader = new CalculationRequestReader();

        // when
        System.setIn(new ByteArrayInputStream("2 + 3".getBytes()));
        CalculationRequest calculationRequest = calculationRequestReader.read();

        // then
        assertThat(calculationRequest.getNum1()).isEqualTo(2);
        assertThat(calculationRequest.getOperator()).isEqualTo("+");
        assertThat(calculationRequest.getNum2()).isEqualTo(3);
    }

}
