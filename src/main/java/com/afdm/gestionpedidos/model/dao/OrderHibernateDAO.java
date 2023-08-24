package com.afdm.gestionpedidos.model.dao;

import com.afdm.gestionpedidos.model.Customer;
import com.afdm.gestionpedidos.model.Employee;
import com.afdm.gestionpedidos.model.OrderDetail;
import com.afdm.gestionpedidos.model.Orders;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderHibernateDAO implements OrderDAO{

    @Override
    public Orders findOrderById(int orderId) {
        Orders order = null;
        Session session = DaoUtility.getSession();
        session.enableFetchProfile("getOrdersD");
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

    @Override
    public void deleteOrderById(int orderId){
        Boolean isDeleted = false;
        Session session = DaoUtility.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(new Orders(orderId));
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    @Override
    public Orders editOrder (Orders order){
        Orders orderUpdate = null;
        Session session = DaoUtility.getSession();
        session.enableFetchProfile("getOrdersD");
        Transaction transaction = session.beginTransaction();
        try {
            orderUpdate = session.get(Orders.class, order.getOrderID());
            if (order.equals(orderUpdate)){

            }else{
                if (order.getCustomer() != null){
                    orderUpdate.setCustomer(order.getCustomer());
                }

                if (order.getEmployee() != null){
                    orderUpdate.setEmployee(order.getEmployee());
                }

                if (order.getOrderDetail() != null){
                    orderUpdate.setOrderDetail(order.getOrderDetail());
                }

                if (order.getOrderDate() != null){
                    orderUpdate.setOrderDate(order.getOrderDate());
                }

                if (order.getRequiredDate() != null){
                    orderUpdate.setRequiredDate(order.getRequiredDate());
                }

                if (order.getShippedDate() != null){
                    orderUpdate.setShippedDate(order.getShippedDate());
                }

                if (order.getFreight() != null){
                    orderUpdate.setFreight(order.getFreight());
                }

                if (order.getShipName() != null){
                    orderUpdate.setShipName(order.getShipName());
                }

                if (order.getShipAddress() != null){
                    orderUpdate.setShipAddress(order.getShipAddress());
                }

                if (order.getShipCity() != null){
                    orderUpdate.setShipCity(order.getShipCity());
                }

                if (order.getShipRegion() != null){
                    orderUpdate.setShipRegion(order.getShipRegion());
                }

                if (order.getShipPostalCode() != null){
                    orderUpdate.setShipPostalCode(order.getShipPostalCode());
                }

                if (order.getShipCountry() != null){
                    orderUpdate.setShipCity(order.getShipCountry());
                }
            }
            session.update(orderUpdate);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
        return orderUpdate;
    }
}
