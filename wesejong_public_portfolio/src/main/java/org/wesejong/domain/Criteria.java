package org.wesejong.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;	//현재 페이지 번호를 나타냅니다.
	private int amount;		//한 페이지당 몇개의 데이터(amount)를 보여줄지 나타냅니다.
	private int first;		
	private int second;
	
	//for Searching
	private String type;
	private String keyword;
	
	
    public Criteria(){	//기본값을 1페이지, 15개로 나타냅니다.
        this(1,20);
    }
  
    
    public Criteria(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
        
    }
    
    public String[] getTypeArr() {
    	System.out.println("type:"+type);
    	return type == null? new String[] {}: type.split("");

    }
    

}


