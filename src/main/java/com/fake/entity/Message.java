package com.fake.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Message{

  String content;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  String id;

  @PrePersist
  private void ensureId() {
      this.setId(UUID.randomUUID().toString());

      if(getCreatedAt() == null){
          setCreatedAt(new Date());
      }

      if(getUpdatedAt() == null){
          setUpdatedAt(new Date());
      }
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "from")
  String from;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "id")
  String to;

  public String getFrom(){
    return from;
  }

  public void setFrom(String from){
    this.from = from;
  }

  public String getTo(){
      return to;
  }

  public void setTo(String to){
      this.to = to;
  }

  public String getContent(){
      return content;
  }

  public void setContent(String content){
      this.content = content;
  }


  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }





}
