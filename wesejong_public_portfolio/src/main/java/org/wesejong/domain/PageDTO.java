package org.wesejong.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
    private int startPage,endPage;		//화면에서 보여지는 페이지의 시작번호, 끝번호
    private boolean prev, next;		//이전, 다음으로 이동가능한 링크의 표시여부
    
    private int total;
    private Criteria cri;

    public PageDTO(Criteria cri, int total){
        this.cri = cri;
        this.total = total;

        this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;	//끝번호는 (현재 페이지 번호 / 10.0)*10 으로  먼저 계산합니다.
        this.startPage = this.endPage - 9;	//화면에서 10개씩 페이징처리를 시작번호 = 끝번호 - 9 입니다.

        int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));	//전체데이터수(total)이 80이라면 endPage는 10의 배수가 아닌 8이 되어야합니다.

        if(realEnd < this.endPage){	//만일 진짜 끝번호(realEnd)가 끝번호(end)보다 작다면 끝번호(end)를 진짜 끝번호(realEnd)로 변경해줍니다.
            this.endPage = realEnd;    
        }

        this.prev = this.startPage > 1;
        
        this.next = this.endPage < realEnd;
    
    }
}
