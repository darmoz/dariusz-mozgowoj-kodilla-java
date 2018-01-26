package com.kodilla.patterns2.facade.api;

import ch.qos.logback.classic.spi.LoggerRemoteView;
import com.kodilla.patterns2.facade.Order;
import com.kodilla.patterns2.facade.ShopService;
import com.sun.org.apache.bcel.internal.generic.BIPUSH;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@EnableAspectJAutoProxy
@Service
public class OrderFacade {
    @Autowired
    private ShopService shopService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    public void processOrder(OrderDto order, Long userId) throws OrderProcessingException {
        boolean wasError = false;
        long orderId = shopService.openOrder(userId);
        LOGGER.info("Registering new order with ID: " + orderId);
        if(orderId<0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORIZED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORIZED);
        }
        try {
            for(ItemDto items: order.getItemsDto() ) {
                LOGGER.info("Adding item " + items.getProductId() + " with quantity of " + items.getQty());
                shopService.addItem(orderId,items.getProductId(),items.getQty());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value is " + value + "USD");
            if(!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            } LOGGER.info("Payment for order " + orderId + " was done");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            } LOGGER.info(" Order is ready to submit");
            if(!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                wasError=true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            } LOGGER.info("Order " + orderId + " has been submitted");
        } finally {
            if(wasError) {
                LOGGER.info("Canceling order");
                shopService.cancelOrder(orderId);
            }
        }

    }
}
