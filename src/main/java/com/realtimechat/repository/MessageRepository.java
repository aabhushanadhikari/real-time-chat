package com.realtimechat.repository;

import com.realtimechat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message,Long> {


}
