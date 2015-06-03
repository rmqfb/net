package net.swing;

import java.util.Arrays;

public class Lotto {
	int[] lotto = new int[6];
	
	public int[] getLotto(){
		return lotto;
	}
	
	public void setLotto() {
		for(int k=0; k<lotto.length; k++){  // 한줄에 여섯개의 숫자 발생
			lotto[k] = (int)(Math.random()*45)+1; // 로또 숫자
			
			for(int j = 0; j<k; j++){ // 숫자 중복 제거
				if(lotto[k] == lotto[j]){
					k--;
					break;
					} //if
				}// for j
			}// for k	
		Arrays.sort(lotto);
		}
}
