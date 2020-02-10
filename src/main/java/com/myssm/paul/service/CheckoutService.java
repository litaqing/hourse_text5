package com.myssm.paul.service;


import com.myssm.paul.pojo.Checkout;

import java.util.List;

public interface CheckoutService {
public void insertcheckout(Checkout checkout);
public List<Checkout> getallcheckout();
public void deletecheckout(Integer id);
}
