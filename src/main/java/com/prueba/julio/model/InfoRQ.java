package com.prueba.julio.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "info_rq")
public class InfoRQ implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "El Email no puede estar vacio")
    @Email(message = "El Email debe ser una direccion valida")
	private String email;

    @NotEmpty(message = "El Nombre no puede estar vacio")
    private String name;

    @NotEmpty(message = "El Apellido no puede estar vacio")
    private String lastName;

    @NotEmpty(message = "El Numero de Tarjeta no puede estar vacio")
    @Size(min=16, max=16, message = "El Numero de Tarjeta debe ser de 16 digitos")
    private String cardNumber;

    @NotNull(message = "El Año de Vencimiento de la Tarjeta no puede estar vacio")
    @Min(value=2019)
    @Max(value=2039)
    private Integer expirationDateYear;

    @NotEmpty(message = "El Mes de Vencimiento de la Tarjeta no puede estar vacio")
    @Size(max=2)
    @Min(value=1)
    @Max(value=12)
    private String expirationDateMonth;

    @NotNull(message = "El Tipo de Gasolina no puede estar vacio")
    @Min(value=1)
    @Max(value=3)
    private Integer gasType;

    @NotNull(message = "El Monto no puede estar vacio")
    @Min(value=1)
    private Double amount;
    
    @NotEmpty(message = "El Nombre del Vendedor no puede estar vacio")
    private String sellerName;
    
    @NotEmpty(message = "La Clave de la Estacion no puede estar vacia")
    private String gasStation;
    
    private String gasStationAddr;
    
    private String gasStationZp;
    
    private String gasStationRfc;
    
    private String gasStationPermNum;
    
    private String gasStationName;
    
    private Double priceRegular;
    
    private Double pricePremium;
    
    private Double priceDiesel;
    
    private Double liters;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpirationDateYear() {
        return expirationDateYear;
    }

    public void setExpirationDateYear(Integer expirationDateYear) {
        this.expirationDateYear = expirationDateYear;
    }

    public String getExpirationDateMonth() {
        return expirationDateMonth;
    }

    public void setExpirationDateMonth(String expirationDateMonth) {
        this.expirationDateMonth = expirationDateMonth;
    }

    public Integer getGasType() {
        return gasType;
    }

    public void setGasType(Integer gasType) {
        this.gasType = gasType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getGasStation() {
        return gasStation;
    }

    public void setGasStation(String gasStation) {
        this.gasStation = gasStation;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGasStationAddr() {
		return gasStationAddr;
	}

	public void setGasStationAddr(String gasStationAddr) {
		this.gasStationAddr = gasStationAddr;
	}

	public String getGasStationRfc() {
		return gasStationRfc;
	}

	public void setGasStationRfc(String gasStationRfc) {
		this.gasStationRfc = gasStationRfc;
	}

	public String getGasStationPermNum() {
		return gasStationPermNum;
	}

	public void setGasStationPermNum(String gasStationPermNum) {
		this.gasStationPermNum = gasStationPermNum;
	}

	public String getGasStationName() {
		return gasStationName;
	}

	public void setGasStationName(String gasStationName) {
		this.gasStationName = gasStationName;
	}

	public Double getPriceRegular() {
		return priceRegular;
	}

	public void setPriceRegular(Double priceRegular) {
		this.priceRegular = priceRegular;
	}

	public Double getPricePremium() {
		return pricePremium;
	}

	public void setPricePremium(Double pricePremium) {
		this.pricePremium = pricePremium;
	}

	public Double getPriceDiesel() {
		return priceDiesel;
	}

	public void setPriceDiesel(Double priceDiesel) {
		this.priceDiesel = priceDiesel;
	}

	public Double getLiters() {
		return liters;
	}

	public void setLiters(Double liters) {
		this.liters = liters;
	}

	public String getGasStationZp() {
		return gasStationZp;
	}

	public void setGasStationZp(String gasStationZp) {
		this.gasStationZp = gasStationZp;
	}
    
}