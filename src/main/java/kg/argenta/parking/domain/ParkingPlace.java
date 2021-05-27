package kg.argenta.parking.domain;

import com.sun.istack.NotNull;
import kg.argenta.parking.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parking_place")
public class ParkingPlace extends BaseEntity {

    @NotNull
    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name = "taken")
    private Boolean taken;
}
