package net.swing;

import java.util.Arrays;

public class Lotto {
	int[] lotto = new int[6];
	
	public int[] getLotto(){
		return lotto;
	}
	
	public void setLotto() {
		for(int k=0; k<lotto.length; k++){  // ���ٿ� �������� ���� �߻�
			lotto[k] = (int)(Math.random()*45)+1; // �ζ� ����
			
			for(int j = 0; j<k; j++){ // ���� �ߺ� ����
				if(lotto[k] == lotto[j]){
					k--;
					break;
					} //if
				}// for j
			}// for k	
		Arrays.sort(lotto);
		}
}
