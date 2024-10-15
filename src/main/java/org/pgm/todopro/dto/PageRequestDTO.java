package org.pgm.todopro.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;

@Data //getter, setter, toString, equals, hashCode를 자동 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 생성
@NoArgsConstructor //기본 생성자를 생성
@Builder
public class PageRequestDTO { //pagerequest 목적은 parameter를 받아서 쿼리스트링을 만들어주는 것

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 3)
    @Max(value = 100)
    @Positive
    private int size = 3;

    private String link;

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;


    public int getSkip() {
        return (page - 1) * size;

    }
    //쿼리스트링을 만들어주는 메서드
   /* public String getLink(){
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        return builder.toString();

    }*/

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if (finished) {
            builder.append("&finished=on");
        }
        if (types != null && types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }
        if (keyword != null) {
            builder.append("&keyword=" + keyword);
        }
        if (from != null) {
            builder.append("&from=" + from.toString());
        }
        if (to != null) {
            builder.append("&to=" + to.toString());
        }
        return builder.toString();

    }

    public boolean checkType(String type) {
        if (types == null || types.length == 0) { //types가 null이거나 비어있으면 false
            return false;

        }
        return Arrays.stream(types).anyMatch(type::equals); //types 배열을 stream으로 만들어서 type과 같은 것이 있는지 확인
    }


}
