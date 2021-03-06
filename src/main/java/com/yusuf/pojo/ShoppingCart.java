package com.yusuf.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="shoppingcart")
public class ShoppingCart {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private long id;
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "cartId", nullable = false,insertable = false, updatable = false)
//	private Set<CartItem> cartItem = new HashSet<CartItem>();
//	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="Shoppingcart")
	private Set<ChartItem> chartItem = new HashSet<ChartItem>();
	
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="id")
	//@JoinColumn(name = "id")
	private User user;
	
	public ShoppingCart()
	{
		
	}
	
	public ShoppingCart(User user)
	{
		
		this.user=user;
        //this.chartItem = new HashSet<ChartItem>();
	}
	
	public Set<ChartItem> getCartItem() {
		return chartItem;
	}
	public void setCartItem(Set<ChartItem> cartItem) {
		this.chartItem = chartItem;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
