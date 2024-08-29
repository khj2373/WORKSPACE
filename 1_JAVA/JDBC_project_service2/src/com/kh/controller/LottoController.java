package com.kh.controller;

import com.kh.model.vo.Lotto;
import com.kh.model.vo.Member;
import com.kh.service.LottoService;
import com.kh.view.MemberMenu;

public class LottoController {

	
	public int drawingLotto(Member m, String[] n) {
		int i = 0;
		String[] result = new String[6];
		
		for(int j = 0; j < 6; j++) {
			result[j] = (int)((Math.random() * 9) + 1) + "";
		}
		
		for(int k = 0; k < 6; k++) {
			if(n[k].equals(result[k])) {
				i++;
			}
		}
		
		new MemberMenu().lottoResult(result);
		
		String lottoUser = "";
		for(String rs : n) {
			lottoUser += (rs + " ");
		}
		
		String lottoRs = "";
		for(String rs : result) {
			lottoRs += (rs + " ");
		}
		
		Lotto l = new Lotto(m.getUserId(), lottoUser, lottoRs, i);
		new LottoService().insertLotto(l);
		
		return i;
	}
	
	public void loading() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
	
}
