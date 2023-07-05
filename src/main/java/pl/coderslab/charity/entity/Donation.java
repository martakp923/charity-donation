package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1)
    @Column(name="quantity")
    private Integer quantity;

    @NotEmpty
    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @NotBlank
    @Column(name="street")
    private String street;

    @NotBlank
    @Column(name="city")
    private String city;

    @NotBlank
    @Column(name="zip_code")
    private String zipCode;

    @Future
    @Column(name="pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Column(name="pick_up_time")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    @Column(name="pick_up_comment")
    private String pickUpComment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
