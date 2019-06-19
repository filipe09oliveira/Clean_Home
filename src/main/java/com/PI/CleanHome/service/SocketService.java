package com.PI.CleanHome.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.PI.CleanHome.model.Socket;

@Service
public class SocketService {
	
	@PersistenceContext
    private EntityManager manager;
	
	public Socket localizar(int userid, String userType) {
		try {
			TypedQuery<Socket> query = manager.createQuery("select s from socket s where s.user_id = :userId and s.user_type = :userType", Socket.class);
			query.setParameter("userId", userid);
			query.setParameter("userType", userType);
			
			return query.getSingleResult();
		
		} catch (Exception e) {
			System.err.println("Não encontrou socket id do usuário " + userid + " do tipo " + userType);
			return null;
		}
	}

}
