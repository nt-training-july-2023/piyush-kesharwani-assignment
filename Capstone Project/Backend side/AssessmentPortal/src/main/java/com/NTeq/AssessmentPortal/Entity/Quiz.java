package com.NTeq.AssessmentPortal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Quiz {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long quizId;
   
   @Column(nullable = false)
   private String quizName;
   
   @Column(nullable = false)
   private String quizDescription;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "categoryId")
   private Category category;
  
   private int time;
   
   /**
    * get category.
    * @return category
    */
   public Category getCategory() {
       return category;
   }
   /**
    * set Category.
    * @param category category
    */
   public void setCategory(final Category cate) {
       this.category = new Category(cate.getCategoryId(),
               cate.getCategoryName(),
               cate.getDescription());
   }
   
   /**
    * parameter constructor for Quiz.
    * @param quizId quizId.
    * @param quizName quizName.
    * @param quizDescription quizDescription.
    * @param time time.
    */
   public Quiz(final long quizId,
           final String quizName,
           final String quizDescription,
           final int time) {
       this.quizId = quizId;
       this.quizName = quizName;
       this.quizDescription = quizDescription;
       this.time = time;
   }
}
