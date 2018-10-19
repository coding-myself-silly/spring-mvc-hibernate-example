package stan.org.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="automobile")
public class Automobile {

	@Id 
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min=3, max=255)
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@NotNull
	@Size(min=3, max=255)
	@Column(name = "MODEL", nullable = false)
	private String model;

	@NotNull
	@Column(name = "country_of_origin", nullable = false)
	private String countryOfOrigin;
	
	@NotNull
	@Column(name = "YEAR", nullable = false)
	private Integer year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((countryOfOrigin == null) ? 0 : countryOfOrigin.hashCode());
        result = prime * result + id;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Automobile other = (Automobile) obj;
        if (countryOfOrigin == null) {
            if (other.countryOfOrigin != null)
                return false;
        } else if (!countryOfOrigin.equals(other.countryOfOrigin))
            return false;
        if (id != other.id)
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Automobile [id=" + id + ", name=" + name + ", model=" + model + ", countryOfOrigin=" + countryOfOrigin
                + ", year=" + year + "]";
    }

   
}
