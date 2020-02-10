package com.myssm.paul.dao;


import com.myssm.paul.pojo.Checkout;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CheckoutMapper {
	public void insertcheckout(Checkout checkout);
	public List<Checkout> getallcheckout();
	public void deletecheckout(Integer id);
}
