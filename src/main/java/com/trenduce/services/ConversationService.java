package com.trenduce.services;

import com.trenduce.model.Conversation;
import com.trenduce.repositories.ConversationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prafulmantale on 1/5/15.
 */

@Service
public class ConversationService {

    @Autowired
    private ConversationsRepository repository;
}
