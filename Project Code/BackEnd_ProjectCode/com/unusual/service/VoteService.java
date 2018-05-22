package com.unusual.service;

import com.unusual.dao.VoteDao;

public class VoteService {

	public void addVoteUp() {
		VoteDao dao = new VoteDao();
		dao.addVote();
	}

}
