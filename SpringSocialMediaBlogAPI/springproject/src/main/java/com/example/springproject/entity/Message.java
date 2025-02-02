package com.example.springproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Column (name="messageId")
    @Id @GeneratedValue

    private Integer messageId;
    /**
     * id for the message posted by a specific user. Let's assume it is posted by
     * the front end
     */
    @Column (name="postedBy")
    private Integer postedBy;

    /**
     * text for the message.It should not be blank
     */
    @Column (name="messageText")
    private String messageText;

    /**
     * the epoch time is when this tweet was posted. Assume it is provided by the front end
     */
    @Column (name="timePostedEpoch")
    private Long timePostedEpoch;

    /**
     * default no-args constructor
     */
    public Message() {
    }

    /**
     * when posting a new message, the id is generated by the database
     * @param messageText
     * @param postedBy
     * @param timePostedEpoch
    */
    public Message(String messageText, Integer postedBy, Long timePostedEpoch) {
        this.messageText = messageText;
        this.postedBy = postedBy;
        this.timePostedEpoch = timePostedEpoch;
    }
    
    /**
     * when retrieving message from the database all fields are neccessary
     * @param messageId
     * @param messageText
     * @param postedBy
     * @param timePostedEpoch
     */
    public Message(Integer messageId, String messageText, Integer postedBy, Long timePostedEpoch) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.postedBy = postedBy;
        this.timePostedEpoch = timePostedEpoch;
    }


    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @returrn messageId
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @param messageId
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @return postedBy
     */

    public Integer getPostedBy() {
        return postedBy;
    }

    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @param postedBy
     */
    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
    }

      /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @return messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @return timePostedEpoch
     */
    public Long getTimePostedEpoch() {
        return timePostedEpoch;
    }

    /**
     * getters and setters are needed for Jackson ObjectMapper to work
     * @param timePostedEpoch
     */
    public void setTimePostedEpoch(Long timePostedEpoch) {
        this.timePostedEpoch = timePostedEpoch;
    }  

}
