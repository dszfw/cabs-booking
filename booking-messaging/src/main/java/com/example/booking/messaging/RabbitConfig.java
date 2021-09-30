package com.example.booking.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  public final static String EXCHANGE_MESSAGE = "exchange.message";
  public static final String EXCHANGE_BOOKING = "exchange.booking";

  public final static String QUEUE_BOOKING_ADD = "queue.booking.add";
  public final static String QUEUE_BOOKING_EDIT = "queue.booking.edit";
  public final static String QUEUE_BOOKING_DELETE = "queue.booking.delete";
  public final static String QUEUE_MESSAGE_AUDIT = "queue.message.audit";

  public static final String BINDING_PATTERN_ALL = "#";
  public static final String BINDING_PATTERN_BOOKING = "booking.#";
  public static final String BINDING_PATTERN_BOOKING_ADD = "booking.add.#";
  public static final String BINDING_PATTERN_BOOKING_EDIT = "booking.edit.#";
  public static final String BINDING_PATTERN_BOOKING_DELETE = "booking.delete.#";

  private static final boolean NON_DURABLE = false;

  @Bean
  public Declarables amqpBindings() {
    TopicExchange messageExchange = new TopicExchange(EXCHANGE_MESSAGE, NON_DURABLE, false);
    TopicExchange bookingExchange = new TopicExchange(EXCHANGE_BOOKING, NON_DURABLE, false);

    Queue messageAuditQueue = new Queue(QUEUE_MESSAGE_AUDIT, NON_DURABLE);
    Queue bookingAddQueue = new Queue(QUEUE_BOOKING_ADD, NON_DURABLE);
    Queue bookingEditQueue = new Queue(QUEUE_BOOKING_EDIT, NON_DURABLE);
    Queue bookingDeleteQueue = new Queue(QUEUE_BOOKING_DELETE, NON_DURABLE);

    Binding messageAuditBinding = BindingBuilder.bind(messageAuditQueue)
        .to(messageExchange)
        .with(BINDING_PATTERN_ALL);
    Binding bookingExchangeBinding = BindingBuilder.bind(bookingExchange)
        .to(messageExchange)
        .with(BINDING_PATTERN_BOOKING);
    Binding bookingAddBinding = BindingBuilder.bind(bookingAddQueue)
        .to(bookingExchange)
        .with(BINDING_PATTERN_BOOKING_ADD);
    Binding bookingEditBinding = BindingBuilder.bind(bookingEditQueue)
        .to(bookingExchange)
        .with(BINDING_PATTERN_BOOKING_EDIT);
    Binding bookingDeleteBinding = BindingBuilder.bind(bookingDeleteQueue)
        .to(bookingExchange)
        .with(BINDING_PATTERN_BOOKING_DELETE);

    return new Declarables(messageExchange, bookingExchange, messageAuditQueue, bookingAddQueue,
        bookingEditQueue, bookingDeleteQueue, messageAuditBinding, bookingExchangeBinding,
        bookingAddBinding, bookingEditBinding, bookingDeleteBinding);
  }

}
