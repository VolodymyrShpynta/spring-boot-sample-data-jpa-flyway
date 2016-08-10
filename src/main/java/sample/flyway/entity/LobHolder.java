package sample.flyway.entity;
//
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
//@Entity
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "EMPLOYEE")
//public class LobHolder {
//
//    @Id
//    @Column(name = "id", nullable = false)
//    @GeneratedValue(generator="gen")
//    @GenericGenerator(name="gen", strategy="foreign",
//            parameters=@org.hibernate.annotations.Parameter(name="property", value="employee"))
//    @Basic(optional = false)
//    private long id;
//
//    @Lob
//    @Column(name = "META_DATA")
//    private String metaData;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
//    public Employee employee;
//}
