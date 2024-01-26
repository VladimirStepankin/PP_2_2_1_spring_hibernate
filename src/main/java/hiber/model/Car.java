package hiber.model;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne(mappedBy = "userCar")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getCarId() {
        return carId;
    }

    public void getCarId(Long id) {
        this.carId = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(carId, car.carId) && Objects.equals(model, car.model) && Objects.equals(user, car.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, model, series, user);
    }
}
