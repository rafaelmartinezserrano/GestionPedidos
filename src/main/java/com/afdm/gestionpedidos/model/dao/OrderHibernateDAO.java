package com.afdm.gestionpedidos.model.dao;

import com.afdm.gestionpedidos.model.Orders;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OrderHibernateDAO implements OrderDAO{

    @Override
    public Orders findOrderById(int orderId) {
        Orders order = null;
        Session session = DaoUtility.getSession();
        session.enableFetchProfile("getOrdersD");
        //insertar en el model el FetchProfile para la lista de Order details -> @FetchProfile(fetchOverrides = {@FetchProfile.FetchOverride(entity = OrderDetails.class, mode = FetchMode.JOIN, association = "???")}, name = "getOrdersD")
        Transaction transaction = session.beginTransaction();
        try{
            order = session.get(Orders.class, orderId);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
        return order;
    }

    @Override
    public List<Orders> findOrdersByCustomer(String customerId) {
        List<Orders> orders = new ArrayList<>();
        Session session = DaoUtility.getSession();
        Transaction transaction = session.beginTransaction();
        TypedQuery<Orders> consulta = session.createQuery("from Orders where customer = :customerid", Orders.class);
        consulta.setParameter(":customerid", customerId);
        try{
            orders = consulta.getResultList();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
        return orders;
    }

    @Override
    public Orders insertOrder(Orders order) {

        Orders orderinsertada = null;
        Session session = DaoUtility.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.merge(order);
            transaction.commit();
            orderinsertada = order;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
        return orderinsertada;
    }
}
