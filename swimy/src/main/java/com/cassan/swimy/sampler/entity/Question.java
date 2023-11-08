package com.cassan.swimy.sampler.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DialectOverride.ColumnDefaults;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity /* 엔티티임을 명시 (JPA) */
@DynamicInsert /* insert시 null 값 제외 */
@Table(name="TB_QUESTION")
public class Question {
	
	
    @Id /* 기본키임을 명시 */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* 시퀀스임을 명시. strategy는 고유번호를 생성하는 옵션으로 GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성 */ 
    private Integer id;									/*              strategy 옵션을 생략할 경우에 @GeneratedValue 애너테이션이 지정된 컬럼들이 모두 동일한 시퀀스로 번호를 생성 */

    @Column(length = 200)   /* 컬럼임을 명시. 해당 클래스가 엔티티로 선언되었다면 @Column 애너테이션을 사용하지 않더라도 테이블 컬럼으로 인식 */
    private String subject; /*            테이블 컬럼으로 인식하고 싶지 않은 경우에만 @Transient 애너테이션을 사용 */      

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) /* Answer와 N:1의 관계임을 명시 */
    private List<Answer> answerList;
    /* CascadeType.REMOVE. 질문 하나에는 여러개의 답변이 작성될 수 있음. 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해서 @OneToMany의 속성으로 cascade = CascadeType.REMOVE를 사용 */
   
    @Column(name = "qt_cost")
    @ColumnDefault("1")  
    private int cost;
    
    @Column(nullable = false)
    private String createId;

    private LocalDateTime createDate;

    private String deleteId;
    
    private LocalDateTime deleteDate;
    
    @ColumnDefault("false")  
    private boolean deleteAt;
    
    public Question() {
		super();
	}

	@Builder
	public Question(Integer id, String subject, String content, List<Answer> answerList, int cost, String createId,
			LocalDateTime createDate, LocalDateTime deleteDate, boolean deleteAt) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.answerList = answerList;
		this.cost = cost;
		this.createId = createId;
		this.createDate = createDate;
		this.deleteDate = deleteDate;
		this.deleteAt = deleteAt;
	}
}