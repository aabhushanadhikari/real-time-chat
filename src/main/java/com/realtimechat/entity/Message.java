package com.realtimechat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "message")
public class Message extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "message_seq_gen")
    @SequenceGenerator(name = "message_seq_gen", sequenceName = "message_seq",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "content")
    private String content;
}
